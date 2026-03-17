package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.pojo.VShopProducts;
import com.guchen.service.VShopProductsService;
import com.guchen.mapper.VShopProductsMapper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【v_shop_products】的数据库操作Service实现
* @createDate 2026-03-12 10:40:37
*/
@Service
public class VShopProductsServiceImpl extends ServiceImpl<VShopProductsMapper, VShopProducts>
    implements VShopProductsService{

    @Autowired
    VShopProductsMapper vShopProductsMapper;

    @Override
    public Result selectProductList(VShopProducts vShopProducts) {
        LambdaQueryWrapper<VShopProducts> wrapper = new LambdaQueryWrapper<VShopProducts>();
        wrapper.eq(VShopProducts::getShopId, vShopProducts.getShopId());
        List<VShopProducts> list = vShopProductsMapper.selectList(wrapper);
        Result result = Result.ok("获取店铺下的所有商品成功！");
        result.put("shopProductList", list);
        return result;
    }
}




