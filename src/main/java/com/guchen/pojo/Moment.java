package com.guchen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 茶友圈动态表
 * @TableName moment
 */
@TableName(value ="moment")
@Data
public class Moment {
    /**
     * 动态ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 动态内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 图片列表（JSON格式存储）
     */
    @TableField(value = "images")
    private String images;

    /**
     * 关联茶品标签
     */
    @TableField(value = "tea_tag")
    private String teaTag;

    /**
     * 关联茶品ID
     */
    @TableField(value = "tea_id")
    private Long teaId;

    /**
     * 发布位置
     */
    @TableField(value = "location")
    private String location;

    /**
     * 话题标签
     */
    @TableField(value = "topic")
    private String topic;

    /**
     * 点赞数
     */
    @TableField(value = "like_count")
    private Integer likeCount;

    /**
     * 评论数
     */
    @TableField(value = "comment_count")
    private Integer commentCount;

    /**
     * 浏览数
     */
    @TableField(value = "view_count")
    private Integer viewCount;

    /**
     * 分享数
     */
    @TableField(value = "share_count")
    private Integer shareCount;

    /**
     * 是否置顶 0-否 1-是
     */
    @TableField(value = "is_top")
    private Integer isTop;

    /**
     * 是否热门 0-否 1-是
     */
    @TableField(value = "is_hot")
    private Integer isHot;

    /**
     * 状态 0-隐藏 1-显示 2-审核中
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