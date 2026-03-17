package com.guchen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 主题商品关联表
 * @TableName theme_product
 */
@TableName(value ="theme_product")
@Data
public class ThemeProduct {
    /**
     * 关联ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 主题ID
     */
    @TableField(value = "theme_id")
    private Integer themeId;

    /**
     * 商品ID
     */
    @TableField(value = "product_id")
    private Long productId;

    /**
     * 在主题中的排序
     */
    @TableField(value = "sort_order")
    private Integer sortOrder;

    /**
     * 推荐语
     */
    @TableField(value = "recommend_note")
    private String recommendNote;

    /**
     * 创建时间
     */
    @TableField(value = "created_at")
    private Date createdAt;
}