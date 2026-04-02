package com.guchen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 品茶笔记表
 * @TableName note
 */
@TableName(value ="note")
@Data
public class Note {
    /**
     * 笔记ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 茶品名称
     */
    @TableField(value = "tea_name")
    private String teaName;

    /**
     * 关联茶品ID
     */
    @TableField(value = "tea_id")
    private Long teaId;

    /**
     * 笔记内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 评分 1-5
     */
    @TableField(value = "rating")
    private Integer rating;

    /**
     * 图片URL
     */
    @TableField(value = "image_url")
    private String imageUrl;

    /**
     * 是否公开
     */
    @TableField(value = "is_public")
    private Integer isPublic;

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