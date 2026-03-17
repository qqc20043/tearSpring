package com.guchen.controller;

import com.guchen.pojo.Address;
import com.guchen.service.AddressService;
import com.guchen.service.UserBalanceService;
import com.guchen.utils.Captchayzm;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.guchen.pojo.User;
import com.guchen.service.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin
public class userController {

    @Autowired
    UserService userService;

    @Autowired
    UserBalanceService userBalanceService;

    @Autowired
    AddressService addressService;

    @PostMapping("login")
    public Result login(@RequestBody User user) {
        Result result = userService.login(user);
        return result;
    }

    @PostMapping("regist")
    public Result regist(@RequestBody User user) {
        System.out.println("前端传来的数据=" + user);
        Result result = userService.regist(user);
        return result;
    }

    @GetMapping("userInfo") // 根据token获取用户ID和用户名
    public Result userInfo(@RequestHeader String token) {
//        System.out.println("tokensd="+token);
        Result result = userService.userInfo(token);
        return result;
    }

    @GetMapping("captcha") // 获取验证码
    public Result captcha() {
        Result result = userService.captcha();
        return result;
    }

    @PostMapping("yzmcap")
    public Result yzmcap(@RequestBody Captchayzm captchayzm) {
        Result result = userService.yzmcap(captchayzm);
        return result;
    }

    @GetMapping("userData")
    public Result userData() {
        Result result = userService.selectUserData();
        return result;
    }

    @GetMapping("balanceI")
    public Result balanceI() {
        Result result = userBalanceService.selectBalanceI();
        return result;
    }

    @GetMapping("addressI")
    public Result addressI() {
        Result result = addressService.selectAddressI();
        return result;
    }

    @PostMapping("addressUpdateInsert")
    public Result addressUpdate(@RequestBody Address address) {
        Result result = addressService.addressUpdateInsert(address);
        return result;
    }

    @PostMapping("addressDelete")
    public Result addressDelete(@RequestBody Address address) {
        Result result = addressService.addressDelete(address);
        return result;
    }
}
