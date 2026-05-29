package com.guchen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 订单表
 * @TableName order
 */
@TableName(value ="`order`")
@Data
public class Order {
    /**
     * 订单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    @TableField(value = "order_no")
    private String orderNo;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 地址ID
     */
    @TableField(value = "address_id")
    private Long addressId;

    /**
     * 店铺ID
     */
    @TableField(value = "shop_id")
    private Integer shopId;

    /**
     * 店铺名称
     */
    @TableField(value = "shop_name")
    private String shopName;

    /**
     * 店铺标签
     */
    @TableField(value = "shop_badge")
    private String shopBadge;

    /**
     * 订单状态 unpaid-待付款 unship-待发货 unreceive-待收货 unreview-待评价 completed-已完成 cancelled-已取消
     */
    @TableField(value = "status")
    private String status;

    /**
     * 商品总额
     */
    @TableField(value = "total_amount")
    private Double totalAmount;

    /**
     * 优惠金额
     */
    @TableField(value = "discount_amount")
    private Double discountAmount;

    /**
     * 积分抵扣
     */
    @TableField(value = "points_discount")
    private Double pointsDiscount;

    /**
     * 优惠券抵扣
     */
    @TableField(value = "coupon_discount")
    private Double couponDiscount;

    /**
     * 运费
     */
    @TableField(value = "delivery_fee")
    private Double deliveryFee;

    /**
     * 实付金额
     */
    @TableField(value = "pay_amount")
    private Double payAmount;

    /**
     * 使用的优惠券ID
     */
    @TableField(value = "coupon_id")
    private Long couponId;

    /**
     * 使用积分
     */
    @TableField(value = "used_points")
    private Integer usedPoints;

    /**
     * 订单备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 送达时间
     */
    @TableField(value = "delivery_time")
    private String deliveryTime;

    /**
     * 配送方式
     */
    @TableField(value = "delivery_method")
    private String deliveryMethod;

    /**
     * 发票类型
     */
    @TableField(value = "invoice_type")
    private String invoiceType;

    /**
     * 支付方式
     */
    @TableField(value = "payment_method")
    private String paymentMethod;

    /**
     * 支付时间
     */
    @TableField(value = "payment_time")
    private Date paymentTime;

    /**
     * 发货时间
     */
    @TableField(value = "delivery_time_actual")
    private Date deliveryTimeActual;

    /**
     * 收货时间
     */
    @TableField(value = "receive_time")
    private Date receiveTime;

    /**
     * 取消原因
     */
    @TableField(value = "cancel_reason")
    private String cancelReason;

    /**
     * 创建时间
     */
    @TableField(value = "created_at")
    private Date createdAt;

    /**
     * 更新时间
     */
    @TableField(value = "updated_at")
    private Date updatedAt;
}