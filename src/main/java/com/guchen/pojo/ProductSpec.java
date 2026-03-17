package com.guchen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 商品规格表
 * @TableName product_spec
 */
@TableName(value ="product_spec")
@Data
public class ProductSpec {
    /**
     * 规格ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品ID
     */
    @TableField(value = "product_id")
    private Long productId;

    /**
     * 规格名称（包含名称和描述，如：品鉴装 50g）
     */
    @TableField(value = "spec_name")
    private String specName;

    /**
     * 规格价格
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 规格原价
     */
    @TableField(value = "original_price")
    private BigDecimal originalPrice;

    /**
     * 规格库存
     */
    @TableField(value = "stock")
    private Integer stock;

    /**
     * 规格销量
     */
    @TableField(value = "sales")
    private Integer sales;

    /**
     * 是否默认规格
     */
    @TableField(value = "is_default")
    private Integer isDefault;

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

    /**
     * 更新时间
     */
    @TableField(value = "updated_at")
    private Date updatedAt;
}