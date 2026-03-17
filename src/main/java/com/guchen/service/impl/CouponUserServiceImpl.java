package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.mapper.CouponUserMapperVO;
import com.guchen.pojo.CouponUser;
import com.guchen.mapper.CouponUserMapper;
import com.guchen.pojo.CouponUserVO;
import com.guchen.service.CouponUserService;
import com.guchen.utils.JwtHelper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author Administrator
* @description 针对表【coupon_user(用户优惠券表)】的数据库操作Service实现
* @createDate 2026-03-08 16:27:42
*/
@Service
public class CouponUserServiceImpl extends ServiceImpl<CouponUserMapper, CouponUser>
    implements CouponUserService {

    @Autowired
    CouponUserMapper couponUserMapper;

    @Autowired
    CouponUserMapperVO couponUserMapperVO;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    JwtHelper jwtHelper;

    @Override
    public Result selectCUListId() {
        String token = request.getHeader("token");
        Long userId = jwtHelper.getUserId(token);
        if(userId == null || token == null) return Result.error("请先登录用户!");
        LambdaQueryWrapper<CouponUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(CouponUser::getUserId, userId);
        List<CouponUser> couponUserList = couponUserMapper.selectList(lambdaQueryWrapper);
        Result result = Result.ok("获取当前用户优惠券");
        Map<String, Object> map = new HashMap<>();
        int claimedCount = 0, unusedCount = 0, expiredCount = 0;
        for (CouponUser couponUser1 : couponUserList) {
            if(couponUser1.getStatus().equals("claimed")) claimedCount ++;
            else if (couponUser1.getStatus().equals("expired")) expiredCount ++;
        }
        unusedCount = claimedCount - expiredCount;
        map.put("couponUserList", couponUserList);
        map.put("claimedCount", claimedCount);
        map.put("unusedCount", unusedCount);
        map.put("expiredCount", expiredCount);
        result.put("dataList", map);
        return result;
    }

    @Override
    public Result selectCouponUserVOList() {
        String token = request.getHeader("token");
        Long userId = jwtHelper.getUserId(token);
        if(userId == null || token == null) return Result.error("请先登录用户!");
        List<CouponUserVO> cuvoList = couponUserMapperVO.selectCouponUserVO(userId);
        Map<String, Object> map = new HashMap<>();
        map.put("cuvoList", cuvoList);
        Result result = Result.ok("用户拥有的优惠券获取成功!");
        result.put("dataList", map);
        return result;
    }
}




