package com.guchen.service;

import com.guchen.pojo.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【cart(购物车表)】的数据库操作Service
* @createDate 2026-03-05 22:19:36
*/
public interface CartService extends IService<Cart> {
    Result selectCartDetailVo();
}
