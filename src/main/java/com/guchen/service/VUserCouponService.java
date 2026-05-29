package com.guchen.service;

import com.guchen.pojo.VUserCoupon;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【v_user_coupon】的数据库操作Service
* @createDate 2026-04-07 13:46:36
*/
public interface VUserCouponService extends IService<VUserCoupon> {
    Result selectVUserCouponService();
}
