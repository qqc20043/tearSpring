package com.guchen.controller;

import com.guchen.pojo.CartItem;
import com.guchen.service.CartItemService;
import com.guchen.service.CartService;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("cart")
@CrossOrigin
public class cartController {

    @Autowired
    CartService cartService;

    @Autowired
    CartItemService cartItemService;

    @GetMapping("VCartDetail")
    public Result cartDetailVO() {
        Result result = cartService.selectCartDetailVo();
        return result;
    }

    @DeleteMapping("delCartItem")
    public Result delCartItem(@RequestBody CartItem cartItem) {
        Result result = cartItemService.delCartItemOne(cartItem);
        return result;
    }

    @PostMapping("insertCartItem")
    public Result insertCartItem(@RequestBody CartItem cartItem) {
        Result result = cartItemService.insertCartItemOne(cartItem);
        return result;
    }

    @DeleteMapping("delAllCartItem")
    public Result delAllCartItem() {
        Result result = cartItemService.delAllCartItem();
        return result;
    }
}
