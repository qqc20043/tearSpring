package com.guchen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName v_shop_products
 */
@TableName(value ="v_shop_products")
@Data
public class VShopProducts {
    /**
     * 店铺ID
     */
    @TableId(type = IdType.AUTO)
//    @TableField(value = "shop_id")
    private Integer shopId;

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
     * 副标题
     */
    @TableField(value = "subtitle")
    private String subtitle;

    /**
     * 价格
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 原价
     */
    @TableField(value = "original_price")
    private BigDecimal originalPrice;

    /**
     * 商品表情
     */
    @TableField(value = "emoji")
    private String emoji;

    /**
     * 销量
     */
    @TableField(value = "sales")
    private Integer sales;

    /**
     * 评分
     */
    @TableField(value = "product_rating")
    private BigDecimal productRating;

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
     * 分类ID
     */
    @TableField(value = "category_id")
    private Integer categoryId;

    /**
     * 分类名称
     */
    @TableField(value = "category_name")
    private String categoryName;

    /**
     * 主题ID
     */
    @TableField(value = "theme_id")
    private Integer themeId;
}