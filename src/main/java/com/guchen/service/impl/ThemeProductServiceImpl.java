package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.mapper.ThemeProductMapperVO;
import com.guchen.pojo.ThemeProduct;
import com.guchen.pojo.ThemeProductVO;
import com.guchen.service.ThemeProductService;
import com.guchen.mapper.ThemeProductMapper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author Administrator
* @description 针对表【theme_product(主题商品关联表)】的数据库操作Service实现
* @createDate 2026-03-05 21:53:53
*/
@Service
public class ThemeProductServiceImpl extends ServiceImpl<ThemeProductMapper, ThemeProduct>
    implements ThemeProductService{

    @Autowired
    ThemeProductMapperVO themeProductMapperVO;

    @Override
    public Result selectTheme(ThemeProduct id) {
        List<ThemeProductVO> themeProductIdList = themeProductMapperVO.selectProductTheme(id);
        System.out.println("themeProductIdList" + themeProductIdList);
        Map<String, Object> map = new HashMap<>();
        map.put("themeProductIdList", themeProductIdList);
        Result result = Result.ok("主题茶叶单个主题获取成功");
        result.put("dataList", map);
        return result;
    }

    @Override
    public Result selectThemeProductList() {
        List<ThemeProductVO> themeProductList = themeProductMapperVO.selectProductThemeList();
        Map<String, Object> map = new HashMap<>();
        map.put("ProductThemeList", themeProductList);
        Result result = Result.ok("茶叶获取成功");
        result.put("dataList", map);
        return result;
    }
}




