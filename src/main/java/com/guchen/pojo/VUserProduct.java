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
 * @TableName v_user_product
 */
@TableName(value ="v_user_product")
@Data
public class VUserProduct {
    /**
     * 记录ID
     */
//    @TableField(value = "record_id")
    @TableId(type = IdType.AUTO)
    private Long recordId;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

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
     * 规格ID
     */
    @TableField(value = "spec_id")
    private Long specId;

    /**
     * 店铺ID
     */
    @TableField(value = "shop_id")
    private Integer shopId;

    /**
     * 商品名称（购买时的名称）
     */
    @TableField(value = "product_name")
    private String productName;

    /**
     * 商品表情
     */
    @TableField(value = "product_emoji")
    private String productEmoji;

    /**
     * 规格名称（购买时的规格）
     */
    @TableField(value = "spec_name")
    private String specName;

    /**
     * 购买数量
     */
    @TableField(value = "quantity")
    private Integer quantity;

    /**
     * 购买单价
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 总金额
     */
    @TableField(value = "total_amount")
    private BigDecimal totalAmount;

    /**
     * 支付方式
     */
    @TableField(value = "payment_method")
    private String paymentMethod;

    /**
     * 购买时间
     */
    @TableField(value = "purchase_time")
    private Date purchaseTime;

    /**
     * 是否可以评价 0-否 1-是
     */
    @TableField(value = "can_review")
    private Integer canReview;

    /**
     * 评价状态 0-未评价 1-已评价
     */
    @TableField(value = "review_status")
    private Integer reviewStatus;

    /**
     * 是否可以售后 0-否 1-是
     */
    @TableField(value = "can_after_sale")
    private Integer canAfterSale;

    /**
     * 分类名称
     */
    @TableField(value = "categoryName")
    private String categoryname;

    /**
     * 副标题
     */
    @TableField(value = "current_subtitle")
    private String currentSubtitle;

    /**
     * 商品描述
     */
    @TableField(value = "description")
    private String description;

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
     * 评分
     */
    @TableField(value = "current_rating")
    private BigDecimal currentRating;

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
     * 状态 0-下架 1-上架
     */
    @TableField(value = "product_status")
    private Integer productStatus;

    /**
     * 店铺名称
     */
    @TableField(value = "shop_name")
    private String shopName;

    /**
     * LOGO表情
     */
    @TableField(value = "logo_emoji")
    private String logoEmoji;

    /**
     * 店铺标签 官方/精选/旗舰店等
     */
    @TableField(value = "shop_badge")
    private String shopBadge;

    /**
     * 店铺评分
     */
    @TableField(value = "shop_rating")
    private BigDecimal shopRating;

    /**
     * 规格名称（包含名称和描述，如：品鉴装 50g）
     */
    @TableField(value = "current_spec_name")
    private String currentSpecName;

    /**
     * 规格价格
     */
    @TableField(value = "current_price")
    private BigDecimal currentPrice;

    /**
     * 规格库存
     */
    @TableField(value = "current_stock")
    private Integer currentStock;
}