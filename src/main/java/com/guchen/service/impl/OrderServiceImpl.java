package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.mapper.CouponCodeMapper;
import com.guchen.mapper.CouponUserMapper;
import com.guchen.mapper.UserMapper;
import com.guchen.pojo.CouponCode;
import com.guchen.pojo.CouponUser;
import com.guchen.pojo.Order;
import com.guchen.pojo.User;
import com.guchen.service.OrderService;
import com.guchen.mapper.OrderMapper;
import com.guchen.utils.JwtHelper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

/**
* @author Administrator
* @description 针对表【order(订单表)】的数据库操作Service实现
* @createDate 2026-04-09 13:28:34
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    CouponUserMapper couponUserMapper;

    @Autowired
    CouponCodeMapper couponCodeMapper;

    @Autowired
    HttpServletRequest request;

    @Autowired
    JwtHelper jwtHelper;

    @Override
    public Result insertOrderData(Order order) {
        Long userId = jwtHelper.getUserId(request.getHeader("token"));
        order.setUserId(userId);
        order.setCreatedAt(new Date());
        orderMapper.insert(order);
        LambdaQueryWrapper<CouponUser> queryWrapper = new LambdaQueryWrapper<CouponUser>();
        queryWrapper.eq(CouponUser::getUserId, userId);
        queryWrapper.eq(CouponUser::getCouponCodeId, order.getCouponId());
        CouponUser couponUser = couponUserMapper.selectOne(queryWrapper);
        if(couponUser != null){
            couponUser.setStatus("used");
            couponUser.setUsedTime(new Date());
            couponUserMapper.updateById(couponUser);
            LambdaQueryWrapper<CouponCode> queryWrapper1 = new LambdaQueryWrapper<CouponCode>();
            queryWrapper1.eq(CouponCode::getId, couponUser.getCouponCodeId());
            CouponCode couponCode = couponCodeMapper.selectOne(queryWrapper1);
            couponCode.setStatus("used");
            couponCodeMapper.updateById(couponCode);
        }
        User user = userMapper.selectById(userId);
        if(user != null) {
            int value = Integer.parseInt(order.getUsedPoints().toString());
            user.setTotalPoints(user.getTotalPoints()-value);
            userMapper.updateById(user);
        }
        Result result = Result.ok("插入订单成功！");
        result.put("orderId", order.getId());
        return result;
    }
}




