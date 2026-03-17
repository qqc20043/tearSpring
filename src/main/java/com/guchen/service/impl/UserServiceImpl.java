package com.guchen.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.mapper.CartMapper;
import com.guchen.pojo.Cart;
import com.guchen.utils.Captchayzm;
import com.guchen.utils.JwtHelper;
import com.guchen.utils.MD5Util;
import com.guchen.utils.Result;
import com.wf.captcha.SpecCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import com.guchen.pojo.User;
import com.guchen.service.UserService;
import com.guchen.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
* @author Administrator
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2026-03-05 19:26:05
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    UserMapper userMapper;

    @Autowired
    JwtHelper jwtHelper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    HttpServletRequest request;

    @Autowired
    CartMapper cartMapper;

    String yzmcode;

    String yzmuid;

    String yzmcodinfo;

    @Override
    public Result login(User user) {
        // 判断验证码是否正确
//        if (yzmcodinfo == null) return Result.error("验证码已失效");
//        if (!yzmcodinfo.equals(yzmcode)) {
//            return Result.error("验证码不正确");
//        }
        // 根据账号查询用户
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getPhone, user.getPhone());
        User user1 = baseMapper.selectOne(wrapper);
        // 判断账号是否存在
        if (user1 == null) return Result.error("账号错误");
        System.out.println("登录角色：" + user1.getUsername());
        // 判断密码
        if (user.getPassword() != null && user1.getPassword().equals(MD5Util.encrypt(user.getPassword()))) {
            // 根据用户生成token
            String token = jwtHelper.createToken(Long.valueOf(user1.getId()));
            // 把token存入redis并设置过期时间2小时
            this.stringRedisTemplate.opsForValue().set(user1.getUsername(), token, 120*60, TimeUnit.SECONDS);
            System.out.println("token = " + token);
            Result result = Result.ok("用户登录成功");
            result.put("token", token);
            result.put("user", user1);
            return result;
        }
        return Result.error("密码错误");
    }

    @Override
    public Result regist(User user) {
        // 根据账号查询用户
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, user.getUsername());
        Long count = userMapper.selectCount(queryWrapper);
        // 判断是否存在
        if (count > 0) return Result.error("用户已存在");
        // 加密用户密码
        user.setPassword(MD5Util.encrypt(user.getPassword()));
        System.out.println("加密后的密码=" + user.getPassword());
        // 插入用户
        int rows = userMapper.insert(user);
        // 插入购物车
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        User user1 = baseMapper.selectOne(wrapper);
        Cart cart = new Cart();
        cart.setUserId(user1.getId());
        cart.setCreatedAt(new Date());
        cart.setUpdatedAt(new Date());
        cartMapper.insert(cart);
        System.out.println("rows = " + rows);
        return Result.ok("用户注册成功");
    }

    @Override
    public Result userInfo(String token) {
        System.out.println("验证token: " + token);
        // 1.判断是否有效
        if (token == null || jwtHelper.isExpiration(token)) {
            // true 过期，直接返回
            return Result.error("身份已过期");
        }
        // 2.获取token对于的用户
        int userId = jwtHelper.getUserId(token).intValue();
        // 3.查询数据
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getId, userId);
        User user = userMapper.selectOne(queryWrapper);
        if (user != null) {
            user.setPassword(null);
            return (Result) Result.ok("获取用户数据成功").put("user", user);
        }
        return Result.error("身份错误");
    }

    @Override
    public Result captcha() {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);
        String code = specCaptcha.text().toLowerCase();
        String uuid = IdUtil.simpleUUID();

        // 存入redis并设置过期时间为2分钟
        this.stringRedisTemplate.opsForValue().set(uuid, code, 120, TimeUnit.SECONDS);
        Map<String, String> map = new HashMap<>(3);
        map.put("uuid", uuid);
        map.put("code", code);
        map.put("captcha", specCaptcha.toBase64());
        System.out.println("code="+code);
        yzmcode = code;
        return (Result) Result.ok("验证码生成成功").put("yzm", map);
    }

    @Override
    public Result yzmcap(Captchayzm captchayzm) {
        yzmuid = captchayzm.getUseruid();
//        System.out.println("前端传来的uid: " + yzmuid);
        yzmcodinfo = this.stringRedisTemplate.opsForValue().get(yzmuid);
//        System.out.println("根据uid在redis中获取的验证码: " + yzmcodinfo);
        return Result.ok("成功接收验证码");
    }

    @Override
    public Result selectUserData() {
        String token = request.getHeader("token");
        Long userId = jwtHelper.getUserId(token);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getId, userId);
        User userData = userMapper.selectOne(wrapper);
        Result result = Result.ok("获取用户数据成功！");
        result.put("userData", userData);
        return result;
    }
}




