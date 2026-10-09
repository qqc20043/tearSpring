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

    /**
     * 取消订单。
     *
     * 为什么需要这个接口：
     *  前端「取消订单」原本只是把本地数组里的那条 splice 掉（纯 UI 假动作），
     *  数据库状态从未改变，所以用户下次进页面又看到同一笔未付款订单。
     *  这里补上真正的落库动作。
     *
     * 安全与业务约束：
     *  1. 只能取消**本人**的订单——用 token 里的 userId 与订单 userId 比对，防越权；
     *  2. 只能取消尚未发货的订单（unpaid / unship），已发货/已完成的不可取消；
     *  3. 记录 cancelReason 与取消时间，便于审计。
     */
    @Override
    public Result cancelOrder(Long orderId, String reason) {
        if (orderId == null) {
            return Result.error("订单 id 不能为空");
        }
        Order order = orderMapper.selectById(orderId);
        if (order == null) {
            return Result.error("订单不存在");
        }
        Long userId = jwtHelper.getUserId(request.getHeader("token"));
        if (userId == null || !userId.equals(order.getUserId())) {
            return Result.error("无权操作该订单");
        }
        String status = order.getStatus();
        if (!"unpaid".equals(status) && !"unship".equals(status)) {
            return Result.error("当前订单状态不可取消（" + status + "）");
        }
        order.setStatus("cancelled");
        order.setCancelReason(reason == null || reason.trim().isEmpty() ? "用户取消" : reason);
        order.setUpdatedAt(new Date());
        orderMapper.updateById(order);
        Result result = Result.ok("订单已取消");
        result.put("orderId", orderId);
        result.put("status", "cancelled");
        return result;
    }
}




