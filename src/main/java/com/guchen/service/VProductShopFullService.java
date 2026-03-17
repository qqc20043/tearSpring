package com.guchen.service;

import com.guchen.pojo.VProductShopFull;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【v_product_shop_full】的数据库操作Service
* @createDate 2026-03-11 10:27:43
*/
public interface VProductShopFullService extends IService<VProductShopFull> {
    Result selectVProductShopFullById(VProductShopFull vProductShopFull);
}
