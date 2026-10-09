package com.guchen.controller;

import com.guchen.pojo.Order;
import com.guchen.pojo.OrderItem;
import com.guchen.service.OrderItemService;
import com.guchen.service.OrderService;
import com.guchen.service.VOrderFullService;
import com.guchen.service.VOrderItemDetailService;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
@CrossOrigin
public class orderController {

    @Autowired
    VOrderFullService vOrderFullService;

    @Autowired
    VOrderItemDetailService vOrderItemDetailService;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderItemService orderItemService;

    @GetMapping("VOrderData")
    public Result vOrderData() {
        Result result = vOrderFullService.selectVOrderData();
        return result;
    }

    @GetMapping("VOrderItemDetail")
    public Result vOrderItemDetail() {
        Result result = vOrderItemDetailService.selectVOrderItemDetail();
        return result;
    }

    @PostMapping("OrderData")
    public Result orderData(@RequestBody Order order) {
        Result result = orderService.insertOrderData(order);
        return result;
    }

    @PostMapping("OrderItemData")
    public Result orderItemData(@RequestBody List<OrderItem> orderItemList) {
        Result result = orderItemService.insertOrderItemList(orderItemList);
        return result;
    }

    /**
     * 取消订单。
     *
     * 背景：前端「取消订单」原先只把本地列表里的那条移除（纯 UI 假动作），
     * 数据库状态从未改变 —— 用户下次进页面又看到同一笔未付款订单。
     * 这个接口补上真正的落库动作（状态置 cancelled + 记录原因）。
     *
     * 约束：只能取消本人的、且尚未发货的订单（unpaid / unship），越权或状态不符会返回错误。
     */
    @PostMapping("CancelOrder")
    public Result cancelOrder(@RequestBody CancelOrderRequest req) {
        return orderService.cancelOrder(req.getOrderId(), req.getReason());
    }

    /**
     * 取消订单请求体。
     * ⚠️ 用普通类而非 record —— 本项目是 JDK 8，record 是 Java 16+ 语法，用了编译不过。
     */
    public static class CancelOrderRequest {
        private Long orderId;
        private String reason;

        public Long getOrderId() { return orderId; }
        public void setOrderId(Long orderId) { this.orderId = orderId; }
        public String getReason() { return reason; }
        public void setReason(String reason) { this.reason = reason; }
    }
}
