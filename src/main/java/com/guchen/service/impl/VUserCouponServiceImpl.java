package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.pojo.VUserCoupon;
import com.guchen.service.VUserCouponService;
import com.guchen.mapper.VUserCouponMapper;
import com.guchen.utils.JwtHelper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author Administrator
* @description 针对表【v_user_coupon】的数据库操作Service实现
* @createDate 2026-04-07 13:46:36
*/
@Service
public class VUserCouponServiceImpl extends ServiceImpl<VUserCouponMapper, VUserCoupon>
    implements VUserCouponService{

    @Autowired
    HttpServletRequest request;

    @Autowired
    JwtHelper jwtHelper;

    @Autowired
    VUserCouponMapper vUserCouponMapper;

    @Override
    public Result selectVUserCouponService() {
        String token = request.getHeader("token");
        Long userId = jwtHelper.getUserId(token);
        LambdaQueryWrapper<VUserCoupon> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(VUserCoupon::getUserId, userId);
        List<VUserCoupon> vUserCouponList = vUserCouponMapper.selectList(queryWrapper);
        if(vUserCouponList.isEmpty()) return Result.error("用户没有优惠券！");
        Result result = Result.ok("获取用户优惠券成功！");
        result.put("vUserCouponList", vUserCouponList);
        return result;
    }
}




