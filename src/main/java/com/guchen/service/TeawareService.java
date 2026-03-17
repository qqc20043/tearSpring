package com.guchen.service;

import com.guchen.pojo.Teaware;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【teaware(茶具表)】的数据库操作Service
* @createDate 2026-03-16 11:12:30
*/
public interface TeawareService extends IService<Teaware> {
    Result selectTeawareId();
}
