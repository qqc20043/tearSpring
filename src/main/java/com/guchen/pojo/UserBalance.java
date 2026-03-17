package com.guchen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 用户余额表
 * @TableName user_balance
 */
@TableName(value ="user_balance")
@Data
public class UserBalance {
    /**
     * 余额ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 微信余额
     */
    @TableField(value = "wechat_balance")
    private BigDecimal wechatBalance;

    /**
     * 支付宝余额
     */
    @TableField(value = "alipay_balance")
    private BigDecimal alipayBalance;

    /**
     * 总余额（计算字段）
     */
    @TableField(value = "total_balance")
    private BigDecimal totalBalance;

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