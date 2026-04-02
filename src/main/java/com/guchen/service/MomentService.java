package com.guchen.service;

import com.guchen.pojo.Moment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【moment(茶友圈动态表)】的数据库操作Service
* @createDate 2026-03-24 19:03:25
*/
public interface MomentService extends IService<Moment> {
    Result insertMoment(Moment moment);
}
