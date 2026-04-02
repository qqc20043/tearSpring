package com.guchen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 茶友圈点赞表
 * @TableName moment_like
 */
@TableName(value ="moment_like")
@Data
public class MomentLike {
    /**
     * 点赞ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 动态ID
     */
    @TableField(value = "moment_id")
    private Long momentId;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 创建时间
     */
    @TableField(value = "created_at")
    private Date createdAt;
}