package com.guchen.service;

import com.guchen.pojo.Shop;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【shop(店铺表)】的数据库操作Service
* @createDate 2026-03-11 21:40:14
*/
public interface ShopService extends IService<Shop> {
    Result selectSingleOne(Shop shop);
}
