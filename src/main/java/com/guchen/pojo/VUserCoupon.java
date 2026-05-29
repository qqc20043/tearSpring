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
 * @TableName v_user_coupon
 */
@TableName(value ="v_user_coupon")
@Data
public class VUserCoupon {
    /**
     * 用户ID
     */
    @TableId(type = IdType.AUTO)
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
     * ID
     */
    @TableField(value = "user_coupon_id")
    private Long userCouponId;

    /**
     * 兑换码ID
     */
    @TableField(value = "coupon_code_id")
    private Long couponCodeId;

    /**
     * 券号
     */
    @TableField(value = "coupon_code")
    private String couponCode;

    /**
     * 状态 claimed-已领取 used-已使用 expired-已过期
     */
    @TableField(value = "coupon_status")
    private String couponStatus;

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
     * 优惠券ID
     */
    @TableField(value = "coupon_id")
    private Long couponId;

    /**
     * 优惠券名称
     */
    @TableField(value = "coupon_name")
    private String couponName;

    /**
     * 类型 full-满减 discount-折扣
     */
    @TableField(value = "coupon_type")
    private String couponType;

    /**
     * 面值（满减为金额，折扣为折扣率如0.8表示8折）
     */
    @TableField(value = "coupon_value")
    private BigDecimal couponValue;

    /**
     * 使用条件描述
     */
    @TableField(value = "coupon_condition")
    private String couponCondition;

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
     * 是否专享券 0-通用券 1-专享券（仅限主题商品使用）
     */
    @TableField(value = "is_exclusive")
    private Integer isExclusive;

    /**
     * 主题ID
     */
    @TableField(value = "theme_id")
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
     * 主题封面表情
     */
    @TableField(value = "theme_emoji")
    private String themeEmoji;

    /**
     * 
     */
    @TableField(value = "available_status")
    private String availableStatus;

    /**
     * 
     */
    @TableField(value = "days_remaining")
    private Integer daysRemaining;

    /**
     * 
     */
    @TableField(value = "coupon_description")
    private String couponDescription;

    /**
     * 
     */
    @TableField(value = "coupon_display_name")
    private String couponDisplayName;
}