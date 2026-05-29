package com.guchen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 订单项表
 * @TableName order_item
 */
@TableName(value ="order_item")
@Data
public class OrderItem {
    /**
     * 订单项ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单ID
     */
    @TableField(value = "order_id")
    private Long orderId;

    /**
     * 商品ID
     */
    @TableField(value = "product_id")
    private Long productId;

    /**
     * 商品名称
     */
    @TableField(value = "product_name")
    private String productName;

    /**
     * 商品规格
     */
    @TableField(value = "product_spec")
    private String productSpec;

    /**
     * 商品表情
     */
    @TableField(value = "product_emoji")
    private String productEmoji;

    /**
     * 单价
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 数量
     */
    @TableField(value = "quantity")
    private Integer quantity;

    /**
     * 小计
     */
    @TableField(value = "subtotal")
    private BigDecimal subtotal;

    /**
     * 创建时间
     */
    @TableField(value = "created_at")
    private Date createdAt;
}