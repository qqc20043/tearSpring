package com.guchen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 茶友圈动态emoji图片表
 * @TableName moment_image
 */
@TableName(value ="moment_image")
@Data
public class MomentImage {
    /**
     * 图片ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 动态ID
     */
    @TableField(value = "moment_id")
    private Long momentId;

    /**
     * emoji表情
     */
    @TableField(value = "emoji")
    private String emoji;

    /**
     * 排序
     */
    @TableField(value = "sort_order")
    private Integer sortOrder;

    /**
     * 创建时间
     */
    @TableField(value = "created_at")
    private Date createdAt;
}