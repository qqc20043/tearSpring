package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.mapper.CartMapper;
import com.guchen.pojo.Cart;
import com.guchen.pojo.CartItem;
import com.guchen.service.CartItemService;
import com.guchen.mapper.CartItemMapper;
import com.guchen.utils.JwtHelper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
* @author Administrator
* @description 针对表【cart_item(购物车项表)】的数据库操作Service实现
* @createDate 2026-03-14 17:21:12
*/
@Service
public class CartItemServiceImpl extends ServiceImpl<CartItemMapper, CartItem>
    implements CartItemService{

    @Autowired
    private HttpServletRequest request;

    @Autowired
    JwtHelper jwtHelper;

    @Autowired
    CartItemMapper cartItemMapper;

    @Autowired
    CartMapper cartMapper;

    @Override
    public Result delCartItemOne(CartItem cartItem) {
        String token = request.getHeader("token");
        Long userId = jwtHelper.getUserId(token);
        LambdaQueryWrapper<Cart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Cart::getUserId, userId);
        Cart cart = cartMapper.selectOne(queryWrapper);
        Long cartId = cart.getId();
        LambdaQueryWrapper<CartItem> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.eq(CartItem::getCartId, cartId)
                .eq(CartItem::getProductId, cartItem.getProductId())
                .eq(CartItem::getSpecId, cartItem.getSpecId());
        int n = cartItemMapper.delete(queryWrapper1);
        if(n < 0) return Result.error("数据库中没有这条数据！");
        return Result.ok("将商品从购物车移除成功！");
    }

    @Override
    public Result insertCartItemOne(CartItem cartItem) {
        String token = request.getHeader("token");
        Long userId = jwtHelper.getUserId(token);
        LambdaQueryWrapper<Cart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Cart::getUserId, userId);
        Cart cart = cartMapper.selectOne(queryWrapper);
        Long cartId = cart.getId();
        cartItem.setCartId(cartId);
        cartItem.setCreatedAt(new Date());
        cartItem.setUpdatedAt(new Date());
        LambdaQueryWrapper<CartItem> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.eq(CartItem::getCartId, cartId)
                .eq(CartItem::getProductId, cartItem.getProductId())
                .eq(CartItem::getSpecId, cartItem.getSpecId());
        CartItem cartItem1 = cartItemMapper.selectOne(queryWrapper1);
//        System.out.println("================================");
//        System.out.println("cartItem1 = " + cartItem1);
        if(cartItem1 == null) cartItemMapper.insert(cartItem);
        else {
            cartItem.setId(cartItem1.getId());
            cartItemMapper.updateById(cartItem);
        }
        return Result.ok("购物车更新商品成功！");
    }

    @Override
    public Result delAllCartItem() {
        Long userId = jwtHelper.getUserId(request.getHeader("token"));
        LambdaQueryWrapper<Cart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Cart::getUserId, userId);
        Cart cart = cartMapper.selectOne(queryWrapper);
        Long cartId = cart.getId();
        LambdaQueryWrapper<CartItem> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.eq(CartItem::getCartId, cartId);
        int n = cartItemMapper.delete(queryWrapper1);
        System.out.println("======================================================:" + n);
        if(n < 0) return Result.error("数据库中没有这条数据！");
        return Result.ok("将商品从购物车移除成功！");
    }
}




