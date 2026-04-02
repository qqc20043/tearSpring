package com.guchen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 茶友圈评论表
 * @TableName moment_comment
 */
@TableName(value ="moment_comment")
@Data
public class MomentComment {
    /**
     * 评论ID
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
     * 昵称
     */
    @TableField(value = "user_nickname")
    private String userNickname;

    /**
     * 父评论ID（回复评论）
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 回复目标用户ID
     */
    @TableField(value = "reply_to")
    private Long replyTo;

    /**
     * 回复目标用户昵称
     */
    @TableField(value = "reply_to_name")
    private String replyToName;

    /**
     * 评论内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 点赞数
     */
    @TableField(value = "like_count")
    private Integer likeCount;

    /**
     * 状态 0-隐藏 1-显示
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(value = "created_at")
    private Date createdAt;
}