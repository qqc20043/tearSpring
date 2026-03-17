package com.guchen.service;

import com.guchen.pojo.CouponCode;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【coupon_code(优惠券兑换码表)】的数据库操作Service
* @createDate 2026-03-08 17:38:42
*/
public interface CouponCodeService extends IService<CouponCode> {
    Result selectCodeNo(CouponCode couponCode);
}
