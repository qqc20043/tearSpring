package com.guchen.service;

import com.guchen.pojo.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【order(订单表)】的数据库操作Service
* @createDate 2026-04-09 13:28:34
*/
public interface OrderService extends IService<Order> {
    Result insertOrderData(Order order);
}
