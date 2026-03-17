package com.guchen.service;

import com.guchen.pojo.UserBalance;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【user_balance(用户余额表)】的数据库操作Service
* @createDate 2026-03-16 18:26:56
*/
public interface UserBalanceService extends IService<UserBalance> {
    Result selectBalanceI();
}
