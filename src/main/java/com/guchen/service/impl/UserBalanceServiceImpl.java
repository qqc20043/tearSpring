package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.pojo.UserBalance;
import com.guchen.service.UserBalanceService;
import com.guchen.mapper.UserBalanceMapper;
import com.guchen.utils.JwtHelper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
* @author Administrator
* @description 针对表【user_balance(用户余额表)】的数据库操作Service实现
* @createDate 2026-03-16 18:26:56
*/
@Service
public class UserBalanceServiceImpl extends ServiceImpl<UserBalanceMapper, UserBalance>
    implements UserBalanceService {

    @Autowired
    HttpServletRequest request;

    @Autowired
    JwtHelper jwtHelper;

    @Autowired
    UserBalanceMapper userBalanceMapper;
    
    @Override
    public Result selectBalanceI() {
        String token = request.getHeader("token");
        Long userId = jwtHelper.getUserId(token);
        LambdaQueryWrapper<UserBalance> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserBalance::getUserId, userId);
        UserBalance userBalance = userBalanceMapper.selectOne(queryWrapper);
        if (userBalance != null) {
            Result result = Result.ok("获取用户余额成功");
            result.put("userBalance", userBalance);
            return result;
        }
        return Result.error("用户余额不存在");
    }
}



