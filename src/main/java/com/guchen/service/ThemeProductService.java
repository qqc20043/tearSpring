package com.guchen.service;

import com.guchen.pojo.ThemeProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【theme_product(主题商品关联表)】的数据库操作Service
* @createDate 2026-03-05 21:53:53
*/
public interface ThemeProductService extends IService<ThemeProduct> {
    Result selectTheme(ThemeProduct id);
    Result selectThemeProductList();
}
