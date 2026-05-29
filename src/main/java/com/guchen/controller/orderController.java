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
}
