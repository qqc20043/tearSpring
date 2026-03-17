package com.guchen.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 优惠券兑换码表
 * @TableName coupon_code
 */
@TableName(value ="coupon_code")
@Data
public class CouponCode {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 优惠券ID
     */
    @TableField(value = "coupon_id")
    private Long couponId;

    /**
     * 券号（唯一）
     */
    @TableField(value = "code")
    private String code;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 批次号
     */
    @TableField(value = "batch_no")
    private String batchNo;

    /**
     * 面值
     */
    @TableField(value = "value")
    private BigDecimal value;

    /**
     * 优惠券类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 关联主题ID
     */
    @TableField(value = "theme_id")
    private Integer themeId;

    /**
     * 主题名称
     */
    @TableField(value = "theme_name")
    private String themeName;

    /**
     * 是否专享券
     */
    @TableField(value = "is_exclusive")
    private Integer isExclusive;

    /**
     * 状态 unclaimed-未领取 claimed-已领取 used-已使用 expired-已过期
     */
    @TableField(value = "status")
    private String status;

    /**
     * 领取用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 领取时间
     */
    @TableField(value = "received_time")
    private Date receivedTime;

    /**
     * 使用时间
     */
    @TableField(value = "used_time")
    private Date usedTime;

    /**
     * 过期时间
     */
    @TableField(value = "expire_time")
    private Date expireTime;

    /**
     * 创建时间
     */
    @TableField(value = "created_at")
    private Date createdAt;

    /**
     * 版本号
     */
    @Version
    @TableField(value = "version")
    private Integer version;
}