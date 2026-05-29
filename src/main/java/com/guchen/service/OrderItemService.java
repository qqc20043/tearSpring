package com.guchen.service;

import com.guchen.pojo.OrderItem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

import java.util.List;

/**
* @author Administrator
* @description 针对表【order_item(订单项表)】的数据库操作Service
* @createDate 2026-04-09 22:25:42
*/
public interface OrderItemService extends IService<OrderItem> {
    Result insertOrderItemList(List<OrderItem> orderItemList);
}
