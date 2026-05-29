package com.guchen.service;

import com.guchen.pojo.CartItem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【cart_item(购物车项表)】的数据库操作Service
* @createDate 2026-03-14 17:21:12
*/
public interface CartItemService extends IService<CartItem> {
    Result delCartItemOne(CartItem cartItem);
    Result insertCartItemOne(CartItem cartItem);
    Result delAllCartItem();
}
