package com.guchen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 优惠券表
 * @TableName coupon
 */
@TableName(value ="coupon")
@Data
public class Coupon {
    /**
     * 优惠券ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 优惠券名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 类型 full-满减 discount-折扣
     */
    @TableField(value = "type")
    private String type;

    /**
     * 面值（满减为金额，折扣为折扣率如0.8表示8折）
     */
    @TableField(value = "value")
    private BigDecimal value;

    /**
     * 使用条件描述
     */
    @TableField(value = "condition")
    private String condition;

    /**
     * 最低订单金额（0表示无门槛）
     */
    @TableField(value = "min_order_amount")
    private BigDecimal minOrderAmount;

    /**
     * 最高抵扣金额（折扣券专用）
     */
    @TableField(value = "max_discount")
    private BigDecimal maxDiscount;

    /**
     * 关联主题ID，NULL表示通用券
     */
    @TableField(value = "theme_id")
    private Integer themeId;

    /**
     * 主题名称（冗余字段）
     */
    @TableField(value = "theme_name")
    private String themeName;

    /**
     * 是否专享券 0-通用券 1-专享券（仅限主题商品使用）
     */
    @TableField(value = "is_exclusive")
    private Integer isExclusive;

    /**
     * 库存
     */
    @TableField(value = "stock")
    private Integer stock;

    /**
     * 发行总量
     */
    @TableField(value = "total_count")
    private Integer totalCount;

    /**
     * 已领取数量
     */
    @TableField(value = "received_count")
    private Integer receivedCount;

    /**
     * 已使用数量
     */
    @TableField(value = "used_count")
    private Integer usedCount;

    /**
     * 开始时间
     */
    @TableField(value = "start_time")
    private Date startTime;

    /**
     * 结束时间
     */
    @TableField(value = "end_time")
    private Date endTime;

    /**
     * 状态 0-失效 1-有效
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
}