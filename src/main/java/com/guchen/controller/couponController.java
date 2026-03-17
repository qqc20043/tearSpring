package com.guchen.controller;

import com.guchen.pojo.CouponCode;
import com.guchen.pojo.CouponUser;
import com.guchen.service.CouponCodeService;
import com.guchen.service.CouponUserService;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("coupon")
@CrossOrigin
public class couponController {

    @Autowired
    CouponCodeService couponCodeService;

    @Autowired
    CouponUserService couponUserService;

    @PostMapping("codeNo")
    public Result codeNo(@RequestBody CouponCode couponCode) {
        Result result = couponCodeService.selectCodeNo(couponCode);
        return result;
    }

    @GetMapping("selectCUListId")
    public Result selectCUListId() {
        Result result = couponUserService.selectCUListId();
        return result;
    }

    @GetMapping("selectCouponUserVOList")
    public Result selectCouponUserVOList() {
        Result result = couponUserService.selectCouponUserVOList();
        return result;
    }
}
