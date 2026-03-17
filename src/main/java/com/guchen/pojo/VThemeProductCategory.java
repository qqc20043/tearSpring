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
 * @TableName v_theme_product_category
 */
@TableName(value ="v_theme_product_category")
@Data
public class VThemeProductCategory {

    /**
     * 主题ID
     */
    @TableId(type = IdType.AUTO)
//    @TableField(value = "theme_id")
    private Integer themeId;

    /**
     * 主题名称
     */
    @TableField(value = "theme_name")
    private String themeName;

    /**
     * 主题副标题
     */
    @TableField(value = "theme_subtitle")
    private String themeSubtitle;

    /**
     * 主题介绍
     */
    @TableField(value = "theme_description")
    private String themeDescription;

    /**
     * 主题封面图
     */
    @TableField(value = "cover_image")
    private String coverImage;

    /**
     * 主题封面表情
     */
    @TableField(value = "cover_emoji")
    private String coverEmoji;

    /**
     * 包含商品数量
     */
    @TableField(value = "theme_product_count")
    private Integer themeProductCount;

    /**
     * 包含茶叶类型(如:绿茶,红茶,乌龙茶)
     */
    @TableField(value = "tea_types")
    private String teaTypes;

    /**
     * 最低价格
     */
    @TableField(value = "theme_min_price")
    private BigDecimal themeMinPrice;

    /**
     * 最高价格
     */
    @TableField(value = "theme_max_price")
    private BigDecimal themeMaxPrice;

    /**
     * 浏览次数
     */
    @TableField(value = "view_count")
    private Integer viewCount;

    /**
     * 点赞次数
     */
    @TableField(value = "like_count")
    private Integer likeCount;

    /**
     * 状态 0-隐藏 1-显示
     */
    @TableField(value = "theme_status")
    private Integer themeStatus;

    /**
     * 排序
     */
    @TableField(value = "theme_sort_order")
    private Integer themeSortOrder;

    /**
     * 创建时间
     */
    @TableField(value = "theme_created_at")
    private Date themeCreatedAt;

    /**
     * 更新时间
     */
    @TableField(value = "theme_updated_at")
    private Date themeUpdatedAt;

    /**
     * 商品ID
     */
    @TableField(value = "product_id")
    private Long productId;

    /**
     * 分类ID
     */
    @TableField(value = "category_id")
    private Integer categoryId;

    /**
     * 店铺ID
     */
    @TableField(value = "shop_id")
    private Integer shopId;

    /**
     * 商品名称
     */
    @TableField(value = "product_name")
    private String productName;

    /**
     * 副标题
     */
    @TableField(value = "product_subtitle")
    private String productSubtitle;

    /**
     * 商品描述
     */
    @TableField(value = "product_description")
    private String productDescription;

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
     * 规格
     */
    @TableField(value = "product_spec")
    private String productSpec;

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
     * 状态 0-下架 1-上架
     */
    @TableField(value = "product_status")
    private Integer productStatus;

    /**
     * 创建时间
     */
    @TableField(value = "product_created_at")
    private Date productCreatedAt;

    /**
     * 更新时间
     */
    @TableField(value = "product_updated_at")
    private Date productUpdatedAt;

    /**
     * 分类名称
     */
    @TableField(value = "category_name")
    private String categoryName;

    /**
     * 图标
     */
    @TableField(value = "category_icon")
    private String categoryIcon;

    /**
     * 在主题中的排序
     */
    @TableField(value = "theme_product_sort_order")
    private Integer themeProductSortOrder;

    /**
     * 推荐语
     */
    @TableField(value = "recommend_note")
    private String recommendNote;
}