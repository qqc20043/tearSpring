package com.guchen.service;

import com.guchen.pojo.VThemeProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【v_theme_product_category】的数据库操作Service
* @createDate 2026-03-11 20:15:54
*/
public interface VThemeProductCategoryService extends IService<VThemeProductCategory> {
    Result selectProductTheme(VThemeProductCategory productCategory);
}
