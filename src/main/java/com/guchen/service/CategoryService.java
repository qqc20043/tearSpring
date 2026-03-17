package com.guchen.service;

import com.guchen.pojo.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【category(商品分类表)】的数据库操作Service
* @createDate 2026-03-06 15:00:12
*/
public interface CategoryService extends IService<Category> {
    Result lists();
}
