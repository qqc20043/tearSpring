package com.guchen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 用户优惠券表
 * @TableName coupon_user
 */
@TableName(value ="coupon_user")
@Data
public class CouponUser {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 优惠券ID
     */
    @TableField(value = "coupon_id")
    private Long couponId;

    /**
     * 兑换码ID
     */
    @TableField(value = "coupon_code_id")
    private Long couponCodeId;

    /**
     * 券号
     */
    @TableField(value = "code")
    private String code;

    /**
     * 使用订单ID
     */
    @TableField(value = "order_id")
    private Long orderId;

    /**
     * 状态 claimed-已领取 used-已使用 expired-已过期
     */
    @TableField(value = "status")
    private String status;

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
}