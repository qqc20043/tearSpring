package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.pojo.Product;
import com.guchen.service.ProductService;
import com.guchen.mapper.ProductMapper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【product(商品表)】的数据库操作Service实现
* @createDate 2026-03-11 10:27:27
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

    @Autowired
    ProductMapper productMapper;

    @Override
    public Result selectShopSpecList() {
        LambdaQueryWrapper<Product> wrapper = new LambdaQueryWrapper<>();
        List<Product> ShopSpecList = productMapper.selectList(wrapper);
        Result result = Result.ok("获取所有的商品");
        result.put("ShopSpecList", ShopSpecList);
        return result;
    }
}




