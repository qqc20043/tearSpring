package com.guchen.service;

import com.guchen.pojo.VOrderItemDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【v_order_item_detail】的数据库操作Service
* @createDate 2026-04-02 19:34:14
*/
public interface VOrderItemDetailService extends IService<VOrderItemDetail> {
    Result selectVOrderItemDetail();
}
