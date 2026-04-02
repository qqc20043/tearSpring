package com.guchen.controller;

import com.guchen.pojo.Address;
import com.guchen.pojo.Note;
import com.guchen.service.*;
import com.guchen.utils.Captchayzm;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.guchen.pojo.User;

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

    @Autowired
    NoteService noteService;

    @Autowired
    VUserProductService vUserProductService;

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

    @PostMapping("userDataUpdate")
    public Result userDataUpdate(@RequestBody User user) {
        Result result = userService.userDataUpdate(user);
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

    @PostMapping("addressUpdateIsDefault")
    public Result addressUpdateIsDefault(@RequestBody Address address) {
        Result result = addressService.addressUpdateIsDefault(address);
        return result;
    }

    @DeleteMapping("addressDelete")
    public Result addressDelete(@RequestBody Address address) {
        Result result = addressService.addressDelete(address);
        return result;
    }

    @GetMapping("noteI")
    public Result noteI() {
        Result result = noteService.selectNoteI();
        return result;
    }

    @PostMapping("noteUpdateInsert")
    public Result noteUpdate(@RequestBody Note note) {
        Result result = noteService.noteUpdateInsert(note);
        return result;
    }

    @DeleteMapping("noteDelete")
    public Result noteDelete(@RequestBody Note note) {
        Result result = noteService.noteDelete(note);
        return result;
    }

    @GetMapping("productCategory")
    public Result productCategory() {
        Result result = vUserProductService.selectProductCategory();
        return result;
    }
}
