package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.pojo.VThemeProductCategory;
import com.guchen.service.VThemeProductCategoryService;
import com.guchen.mapper.VThemeProductCategoryMapper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【v_theme_product_category】的数据库操作Service实现
* @createDate 2026-03-11 20:15:54
*/
@Service
public class VThemeProductCategoryServiceImpl extends ServiceImpl<VThemeProductCategoryMapper, VThemeProductCategory>
    implements VThemeProductCategoryService{

    @Autowired
    VThemeProductCategoryMapper vThemeProductCategoryMapper;

    @Override
    public Result selectProductTheme(VThemeProductCategory productCategory) {
        LambdaQueryWrapper<VThemeProductCategory> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(VThemeProductCategory::getThemeId, productCategory.getThemeId());
        List<VThemeProductCategory> list = vThemeProductCategoryMapper.selectList(wrapper);
        Result result = Result.ok("主题商品获取成功！");
        result.put("themeProductCategory", list);
        return result;
    }
}




