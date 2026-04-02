package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.mapper.CouponUserMapper;
import com.guchen.pojo.CouponCode;
import com.guchen.mapper.CouponCodeMapper;
import com.guchen.pojo.CouponUser;
import com.guchen.service.CouponCodeService;
import com.guchen.utils.JwtHelper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
* @author Administrator
* @description 针对表【coupon_code(优惠券兑换码表)】的数据库操作Service实现
* @createDate 2026-03-08 16:27:39
*/
@Service
public class CouponCodeServiceImpl extends ServiceImpl<CouponCodeMapper, CouponCode>
    implements CouponCodeService {
    @Autowired
    CouponCodeMapper couponCodeMapper;

    @Autowired
    CouponUserMapper couponUserMapper;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    JwtHelper jwtHelper;

    @Override
    public Result selectCodeNo(CouponCode couponCode) {
        LambdaQueryWrapper<CouponCode> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CouponCode::getCode, couponCode.getCode());
        CouponCode couponCode1 = couponCodeMapper.selectOne(wrapper);
        if(couponCode1 == null) return Result.error("券号输入错误！");
        else if(!couponCode.getPassword().equals(couponCode1.getPassword())) return Result.error("优惠券密码错误！");
        else if(couponCode1.getStatus().equals("claimed")) return Result.error("此优惠券已被领取！");
        else if(couponCode1.getStatus().equals("expired")) return Result.error("此优惠券已过期！");
        else if(couponCode1.getStatus().equals("used")) return Result.error("此优惠券已被用户使用！");
        // 直接从注入的request中获取
        String token = request.getHeader("token");
        Long userId = jwtHelper.getUserId(token);
        LambdaQueryWrapper<CouponUser> wrapperCU = new LambdaQueryWrapper<>();
        wrapperCU.eq(CouponUser::getUserId, userId)
                .eq(CouponUser::getStatus, "claimed")
                .eq(CouponUser::getCouponId, couponCode1.getCouponId());
        CouponUser couponUserUR = couponUserMapper.selectOne(wrapperCU);
        if (couponUserUR != null) return Result.error("该用户已领取该类型优惠券！");
        couponCode1.setUserId(userId);
        couponCode1.setReceivedTime(new Date());
        couponCode1.setStatus("claimed");
        couponCodeMapper.updateById(couponCode1);
        CouponUser couponUser = new CouponUser();
        couponUser.setUserId(couponCode1.getUserId());
        couponUser.setCouponId(couponCode1.getCouponId());
        couponUser.setCouponCodeId(couponCode1.getId());
        couponUser.setCode(couponCode1.getCode());
        couponUser.setStatus(couponCode1.getStatus());
        couponUser.setReceivedTime(couponCode1.getReceivedTime());
        couponUser.setExpireTime(couponCode1.getExpireTime());
        couponUserMapper.insert(couponUser);
        return Result.ok("优惠券兑换成功！");
    }
}




