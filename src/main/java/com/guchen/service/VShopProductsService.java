package com.guchen.service;

import com.guchen.pojo.VShopProducts;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【v_shop_products】的数据库操作Service
* @createDate 2026-03-12 10:40:37
*/
public interface VShopProductsService extends IService<VShopProducts> {
    Result selectProductList(VShopProducts vShopProducts);
}
