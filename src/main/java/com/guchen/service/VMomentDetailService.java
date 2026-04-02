package com.guchen.service;

import com.guchen.pojo.VMomentDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【v_moment_detail】的数据库操作Service
* @createDate 2026-03-24 18:10:24
*/
public interface VMomentDetailService extends IService<VMomentDetail> {
    Result selectList();
}
