package com.guchen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 店铺表
 * @TableName shop
 */
@TableName(value ="shop")
@Data
public class Shop {
    /**
     * 店铺ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 店铺名称
     */
    @TableField(value = "name")
    private String name;

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
    @TableField(value = "badge")
    private String badge;

    /**
     * 店铺描述
     */
    @TableField(value = "description")
    private String description;

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
    @TableField(value = "rating")
    private BigDecimal rating;

    /**
     * 累计销量
     */
    @TableField(value = "sales_count")
    private Integer salesCount;

    /**
     * 商品数量
     */
    @TableField(value = "product_count")
    private Integer productCount;

    /**
     * 粉丝数
     */
    @TableField(value = "fans_count")
    private Integer fansCount;

    /**
     * 状态 0-关闭 1-营业中
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
}