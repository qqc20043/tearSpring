package com.guchen.service;

import com.guchen.pojo.CouponUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【coupon_user(用户优惠券表)】的数据库操作Service
* @createDate 2026-03-08 17:39:21
*/
public interface CouponUserService extends IService<CouponUser> {
    Result selectCUListId();

    Result selectCouponUserVOList();
}
