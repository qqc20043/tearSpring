package com.guchen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guchen.pojo.ThemeProduct;
import com.guchen.pojo.ThemeProductVO;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【theme_product(主题商品关联表)】的数据库操作Mapper
 * @createDate 2026-03-08 16:46:56
 * @Entity com.guchen.pojo.ThemeProduct
 */
public interface ThemeProductMapperVO extends BaseMapper<ThemeProductVO> {
    List<ThemeProductVO> selectProductTheme(ThemeProduct themeProduct);

    List<ThemeProductVO> selectProductThemeList();
}