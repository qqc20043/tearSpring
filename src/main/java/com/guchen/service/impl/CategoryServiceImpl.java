package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.pojo.Category;
import com.guchen.pojo.Theme;
import com.guchen.service.CategoryService;
import com.guchen.mapper.CategoryMapper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author Administrator
* @description 针对表【category(商品分类表)】的数据库操作Service实现
* @createDate 2026-03-06 15:00:12
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public Result lists() {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        List<Category> productsList = categoryMapper.selectList(queryWrapper);
        Map<String, Object> map = new HashMap<>();
        map.put("categoryList", productsList);
        Result result = Result.ok("茶叶分类获取成功");
        result.put("dataList", map);
        return result;
    }
}




