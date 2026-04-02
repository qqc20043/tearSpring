package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.pojo.VUserProduct;
import com.guchen.service.VUserProductService;
import com.guchen.mapper.VUserProductMapper;
import com.guchen.utils.JwtHelper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author Administrator
* @description 针对表【v_user_product】的数据库操作Service实现
* @createDate 2026-03-23 18:56:26
*/
@Service
public class VUserProductServiceImpl extends ServiceImpl<VUserProductMapper, VUserProduct>
    implements VUserProductService{

    @Autowired
    JwtHelper jwtHelper;

    @Autowired
    VUserProductMapper vUserProductMapper;

    @Autowired
    HttpServletRequest request;

    @Override
    public Result selectProductCategory() {
        Long userId = jwtHelper.getUserId(request.getHeader("token"));
        LambdaQueryWrapper<VUserProduct> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(VUserProduct::getUserId, userId);
        List<VUserProduct> products = vUserProductMapper.selectList(wrapper);
        Result result = Result.ok("获取用户商品分类成功！");
        result.put("productCategory", products);
        return result;
    }
    
}




