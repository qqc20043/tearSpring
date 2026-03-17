package com.guchen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 茶文化主题表
 * @TableName theme
 */
@TableName(value ="theme")
@Data
public class Theme {
    /**
     * 主题ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 主题名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 主题副标题
     */
    @TableField(value = "subtitle")
    private String subtitle;

    /**
     * 主题介绍
     */
    @TableField(value = "description")
    private String description;

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
    @TableField(value = "product_count")
    private Integer productCount;

    /**
     * 包含茶叶类型(如:绿茶,红茶,乌龙茶)
     */
    @TableField(value = "tea_types")
    private String teaTypes;

    /**
     * 最低价格
     */
    @TableField(value = "min_price")
    private BigDecimal minPrice;

    /**
     * 最高价格
     */
    @TableField(value = "max_price")
    private BigDecimal maxPrice;

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
    @TableField(value = "status")
    private Integer status;

    /**
     * 排序
     */
    @TableField(value = "sort_order")
    private Integer sortOrder;

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
     * 评分
     */
    @TableField(value = "rating")
    private BigDecimal rating;
}