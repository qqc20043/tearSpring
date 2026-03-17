package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.utils.Result;
import com.guchen.mapper.ThemeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.guchen.pojo.Theme;
import com.guchen.service.ThemeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author Administrator
* @description 针对表【theme(茶文化主题表)】的数据库操作Service实现
* @createDate 2026-03-05 21:49:14
*/
@Service
public class ThemeServiceImpl extends ServiceImpl<ThemeMapper, Theme>
    implements ThemeService {

    @Autowired
    ThemeMapper themeMapper;

    @Override
    public Result lists() {
        LambdaQueryWrapper<Theme> queryWrapper = new LambdaQueryWrapper<>();
        List<Theme> productsList = themeMapper.selectList(queryWrapper);
        Map<String, Object> map = new HashMap<>();
        map.put("themeList", productsList);
        Result result = Result.ok("主题茶叶获取成功");
        result.put("dataList", map);
        return result;
    }
}




