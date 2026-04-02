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
 * @TableName v_order_full
 */
@TableName(value ="v_order_full")
@Data
public class VOrderFull {
    /**
     * 订单ID
     */
    @TableField(value = "order_id")
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
     * 使用积分
     */
    @TableField(value = "used_points")
    private Integer usedPoints;

    /**
     * 订单备注
     */
    @TableField(value = "order_remark")
    private String orderRemark;

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
    @TableField(value = "order_created_at")
    private Date orderCreatedAt;

    /**
     * 更新时间
     */
    @TableField(value = "order_updated_at")
    private Date orderUpdatedAt;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

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
     * 头像表情
     */
    @TableField(value = "user_avatar")
    private String userAvatar;

    /**
     * 会员等级 0-普通 1-青铜 2-白银 3-黄金
     */
    @TableField(value = "vip_level")
    private Integer vipLevel;

    /**
     * 茶龄(天)
     */
    @TableField(value = "tea_age")
    private Integer teaAge;

    /**
     * 地址ID
     */
    @TableField(value = "address_id")
    private Long addressId;

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
     * 标签 家/公司/学校
     */
    @TableField(value = "address_tag")
    private String addressTag;

    /**
     * 省
     */
    @TableField(value = "province")
    private String province;

    /**
     * 市
     */
    @TableField(value = "city")
    private String city;

    /**
     * 区
     */
    @TableField(value = "district")
    private String district;

    /**
     * 详细地址
     */
    @TableField(value = "address_detail")
    private String addressDetail;

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
     * LOGO表情
     */
    @TableField(value = "shop_logo")
    private String shopLogo;

    /**
     * 店铺标签 官方/精选/旗舰店等
     */
    @TableField(value = "shop_badge")
    private String shopBadge;

    /**
     * 联系电话
     */
    @TableField(value = "shop_phone")
    private String shopPhone;

    /**
     * 店铺地址
     */
    @TableField(value = "shop_address")
    private String shopAddress;

    /**
     * 
     */
    @TableField(value = "product_ids")
    private String productIds;

    /**
     * 
     */
    @TableField(value = "product_names")
    private String productNames;

    /**
     * 
     */
    @TableField(value = "total_quantity")
    private Long totalQuantity;

    /**
     * 
     */
    @TableField(value = "total_subtotal")
    private BigDecimal totalSubtotal;

    /**
     * 
     */
    @TableField(value = "order_items_json")
    private Object orderItemsJson;
}