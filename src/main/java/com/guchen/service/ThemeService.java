package com.guchen.service;

import com.guchen.utils.Result;
import com.guchen.pojo.Theme;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【theme(茶文化主题表)】的数据库操作Service
* @createDate 2026-03-05 21:49:14
*/
public interface ThemeService extends IService<Theme> {
    Result lists();
}
