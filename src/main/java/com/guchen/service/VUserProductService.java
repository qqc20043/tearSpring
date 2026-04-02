package com.guchen.service;

import com.guchen.pojo.VUserProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【v_user_product】的数据库操作Service
* @createDate 2026-03-23 18:56:26
*/
public interface VUserProductService extends IService<VUserProduct> {
    Result selectProductCategory();
}
