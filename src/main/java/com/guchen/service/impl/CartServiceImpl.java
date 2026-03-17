package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.mapper.VCartDetailEnhancedMapper;
import com.guchen.pojo.Cart;
import com.guchen.pojo.VCartDetailEnhanced;
import com.guchen.service.CartService;
import com.guchen.mapper.CartMapper;
import com.guchen.utils.JwtHelper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author Administrator
* @description 针对表【cart(购物车表)】的数据库操作Service实现
* @createDate 2026-03-05 22:19:36
*/
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart>
    implements CartService{

    @Autowired
    private HttpServletRequest request;

    @Autowired
    JwtHelper jwtHelper;

    @Autowired
    CartMapper cartMapper;

    @Autowired
    VCartDetailEnhancedMapper vCartDetailEnhancedMapper;

    @Override
    public Result selectCartDetailVo() {
        String token = request.getHeader("token");
        Long userId = jwtHelper.getUserId(token);
        LambdaQueryWrapper<Cart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Cart::getUserId, userId);
        Cart cart = cartMapper.selectOne(queryWrapper);
        Long cartId = cart.getId();
        LambdaQueryWrapper<VCartDetailEnhanced> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.eq(VCartDetailEnhanced::getCartId, cartId);
        List<VCartDetailEnhanced> VCartDetailEnhancedList = vCartDetailEnhancedMapper.selectList(queryWrapper1);
        Result result = Result.ok("获取用户购物车商品数据成功！");
        result.put("VCartDetailEnhancedList", VCartDetailEnhancedList);
        return result;
    }
}




