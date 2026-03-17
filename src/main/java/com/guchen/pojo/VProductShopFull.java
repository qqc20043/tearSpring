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
 * @TableName v_product_shop_full
 */
@TableName(value ="v_product_shop_full")
@Data
public class VProductShopFull {
    /**
     * 商品ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 分类名称
     */
    @TableField(value = "category_name")
    private String categoryName;

    /**
     * 店铺ID
     */
    @TableField(value = "shop_id")
    private Integer shopId;

    /**
     * 商品名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 副标题
     */
    @TableField(value = "subtitle")
    private String subtitle;

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
     * 规格
     */
    @TableField(value = "spec")
    private String spec;

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
     * 库存
     */
    @TableField(value = "stock")
    private Integer stock;

    /**
     * 销量
     */
    @TableField(value = "sales")
    private Integer sales;

    /**
     * 评分
     */
    @TableField(value = "rating")
    private BigDecimal rating;

    /**
     * 商品表情
     */
    @TableField(value = "emoji")
    private String emoji;

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
    @TableField(value = "status")
    private Integer status;

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

    /**
     * 店铺名称
     */
    @TableField(value = "shop_name")
    private String shopName;

    /**
     * 店铺LOGO
     */
    @TableField(value = "logo")
    private String logo;

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
     * 店铺描述
     */
    @TableField(value = "shop_description")
    private String shopDescription;

    /**
     * 店铺地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 联系电话
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 营业时间
     */
    @TableField(value = "business_hours")
    private String businessHours;

    /**
     * 店铺评分
     */
    @TableField(value = "shop_rating")
    private BigDecimal shopRating;

    /**
     * 累计销量
     */
    @TableField(value = "sales_count")
    private Integer salesCount;

    /**
     * 商品数量
     */
    @TableField(value = "shop_product_count")
    private Integer shopProductCount;

    /**
     * 粉丝数
     */
    @TableField(value = "fans_count")
    private Integer fansCount;

    /**
     * 状态 0-关闭 1-营业中
     */
    @TableField(value = "shop_status")
    private Integer shopStatus;

    /**
     * 排序
     */
    @TableField(value = "sort_order")
    private Integer sortOrder;

    /**
     * 创建时间
     */
    @TableField(value = "shop_created_at")
    private Date shopCreatedAt;

    /**
     * 更新时间
     */
    @TableField(value = "shop_updated_at")
    private Date shopUpdatedAt;
}