package com.guchen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CouponUserVO {
    /**
     * 关联ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 优惠券名称
     */
    @TableField(value = "name")
    private String name;

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
     * 过期时间
     */
    @TableField(value = "expire_time")
    private Date expireTime;

    /**
     * 状态 claimed-已领取 used-已使用 expired-已过期
     */
    @TableField(value = "status")
    private String status;
}
