package com.guchen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.pojo.OrderItem;
import com.guchen.service.OrderItemService;
import com.guchen.mapper.OrderItemMapper;
import com.guchen.utils.JwtHelper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
* @author Administrator
* @description 针对表【order_item(订单项表)】的数据库操作Service实现
* @createDate 2026-04-09 22:25:42
*/
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem>
    implements OrderItemService{

    @Autowired
    OrderItemMapper orderItemMapper;

    @Override
    public Result insertOrderItemList(List<OrderItem> orderItemList) {
        for(OrderItem orderItem:orderItemList){
            orderItem.setCreatedAt(new Date());
            orderItemMapper.insert(orderItem);
        }
        Result result = Result.ok("插入订单项成功！");
        return result;
    }
}




