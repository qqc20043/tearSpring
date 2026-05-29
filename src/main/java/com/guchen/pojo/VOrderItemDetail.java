package com.guchen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName v_order_item_detail
 */
@TableName(value ="v_order_item_detail")
@Data
public class VOrderItemDetail {
    /**
     * 订单ID
     */
    @TableId(type = IdType.AUTO)
    private Long orderId;

    /**
     * 订单号
     */
    @TableField(value = "order_no")
    private String orderNo;

    /**
     * 订单状态 unpaid-待付款 unship-待发货 unreceive-待收货 unreview-待评价 completed-已完成 cancelled-已取消
     */
    @TableField(value = "order_status")
    private String orderStatus;

    /**
     * 商品总额
     */
    @TableField(value = "total_amount")
    private BigDecimal totalAmount;

    /**
     * 优惠金额
     */
    @TableField(value = "discount_amount")
    private BigDecimal discountAmount;

    /**
     * 积分抵扣
     */
    @TableField(value = "points_discount")
    private BigDecimal pointsDiscount;

    /**
     * 优惠券抵扣
     */
    @TableField(value = "coupon_discount")
    private BigDecimal couponDiscount;

    /**
     * 运费
     */
    @TableField(value = "delivery_fee")
    private BigDecimal deliveryFee;

    /**
     * 实付金额
     */
    @TableField(value = "pay_amount")
    private BigDecimal payAmount;

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
     * 创建时间
     */
    @TableField(value = "order_created_at")
    private Date orderCreatedAt;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 昵称
     */
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 手机号
     */
    @TableField(value = "user_phone")
    private String userPhone;

    /**
     * 收货人姓名
     */
    @TableField(value = "receiver_name")
    private String receiverName;

    /**
     * 手机号
     */
    @TableField(value = "receiver_phone")
    private String receiverPhone;

    /**
     * 完整地址
     */
    @TableField(value = "full_address")
    private String fullAddress;

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
     * 店铺标签 官方/精选/旗舰店等
     */
    @TableField(value = "shop_badge")
    private String shopBadge;

    /**
     * 订单项ID
     */
    @TableField(value = "order_item_id")
    private Long orderItemId;

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
    @TableField(value = "order_item_emoji")
    private String orderItemEmoji;

    /**
     * 单价
     */
    @TableField(value = "unit_price")
    private BigDecimal unitPrice;

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
     * 价格
     */
    @TableField(value = "current_price")
    private BigDecimal currentPrice;

    /**
     * 原价
     */
    @TableField(value = "original_price")
    private BigDecimal originalPrice;

    /**
     * 库存
     */
    @TableField(value = "current_stock")
    private Integer currentStock;

    /**
     * 销量
     */
    @TableField(value = "total_sales")
    private Integer totalSales;

    /**
     * 评分
     */
    @TableField(value = "product_rating")
    private BigDecimal productRating;

    /**
     * 商品表情
     */
    @TableField(value = "product_emoji")
    private String productEmoji;

    /**
     * 是否新品
     */
    @TableField(value = "is_new")
    private Integer isNew;

    /**
     * 是否热卖
     */
    @TableField(value = "is_hot")
    private Integer isHot;

    /**
     * 品鉴笔记
     */
    @TableField(value = "tasting_notes")
    private String tastingNotes;

    /**
     * 年份（如：2025、2018年）
     */
    @TableField(value = "year")
    private String year;

    /**
     * 工艺（如：传统手工炒制、机制）
     */
    @TableField(value = "craft")
    private String craft;

    /**
     * 产地
     */
    @TableField(value = "origin")
    private String origin;

    /**
     * 产地详情
     */
    @TableField(value = "origin_detail")
    private String originDetail;

    /**
     * 规格ID
     */
    @TableField(value = "spec_id")
    private Long specId;

    /**
     * 规格名称（包含名称和描述，如：品鉴装 50g）
     */
    @TableField(value = "current_spec_name")
    private String currentSpecName;

    /**
     * 规格价格
     */
    @TableField(value = "current_spec_price")
    private BigDecimal currentSpecPrice;

    /**
     * 规格库存
     */
    @TableField(value = "current_spec_stock")
    private Integer currentSpecStock;
}