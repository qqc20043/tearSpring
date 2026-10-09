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

    /**
     * 取消订单：把订单状态置为 cancelled 并记录原因。
     * 仅允许取消「本人的、且尚未发货的」订单（unpaid / unship）。
     */
    Result cancelOrder(Long orderId, String reason);
}
