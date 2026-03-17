package com.guchen.service;

import com.guchen.utils.Captchayzm;
import com.guchen.utils.Result;
import com.guchen.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2026-03-05 19:26:05
*/
public interface UserService extends IService<User> {
    Result login(User user);

    Result regist(User user);

    Result userInfo(String token);

    Result captcha();

    Result yzmcap(Captchayzm captchayzm);

    Result selectUserData();
}
