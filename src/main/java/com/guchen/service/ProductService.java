package com.guchen.service;

import com.guchen.pojo.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【product(商品表)】的数据库操作Service
* @createDate 2026-03-11 10:27:27
*/
public interface ProductService extends IService<Product> {
    Result selectShopSpecList();
}
