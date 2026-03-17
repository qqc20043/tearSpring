package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.mapper.ProductSpecMapper;
import com.guchen.pojo.ProductSpec;
import com.guchen.pojo.VProductShopFull;
import com.guchen.service.VProductShopFullService;
import com.guchen.mapper.VProductShopFullMapper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【v_product_shop_full】的数据库操作Service实现
* @createDate 2026-03-11 10:27:43
*/
@Service
public class VProductShopFullServiceImpl extends ServiceImpl<VProductShopFullMapper, VProductShopFull>
    implements VProductShopFullService{
    @Autowired
    VProductShopFullMapper vProductShopFullMapper;

    @Autowired
    ProductSpecMapper productSpecMapper;


    @Override
    public Result selectVProductShopFullById(VProductShopFull vProductShopFull) {
        LambdaQueryWrapper<VProductShopFull> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(VProductShopFull::getId, vProductShopFull.getId());
        VProductShopFull vProductShopFull1 = vProductShopFullMapper.selectOne(queryWrapper);
        Result result = Result.ok("获取单一商品数据成功！");
        LambdaQueryWrapper<ProductSpec> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.eq(ProductSpec::getProductId, vProductShopFull.getId());
        List<ProductSpec> productSpecs = productSpecMapper.selectList(queryWrapper1);
        result.put("productSpecs", productSpecs);
        result.put("vProductShopFull", vProductShopFull1);
        return result;
    }
}




