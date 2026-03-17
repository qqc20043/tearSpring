package com.guchen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName v_cart_detail_enhanced
 */
@TableName(value ="v_cart_detail_enhanced")
@Data
public class VCartDetailEnhanced {
    /**
     * 购物车项ID
     */
    @TableId(value = "cart_item_id", type = IdType.AUTO)
    private Long cartItemId;

    /**
     * 购物车ID
     */
    @TableField(value = "cart_id")
    private Long cartId;

    /**
     * 数量
     */
    @TableField(value = "quantity")
    private Integer quantity;

    /**
     * 是否选中
     */
    @TableField(value = "checked")
    private Integer checked;

    /**
     * 创建时间
     */
    @TableField(value = "cart_item_created_at")
    private Date cartItemCreatedAt;

    /**
     * 更新时间
     */
    @TableField(value = "cart_item_updated_at")
    private Date cartItemUpdatedAt;

    /**
     * 商品ID
     */
    @TableField(value = "product_id")
    private Long productId;

    /**
     * 商品名称
     */
    @TableField(value = "product_name")
    private String productName;

    /**
     * 副标题
     */
    @TableField(value = "product_subtitle")
    private String productSubtitle;

    /**
     * 商品表情
     */
    @TableField(value = "product_emoji")
    private String productEmoji;

    /**
     * 主题ID
     */
    @TableField(value = "theme_id")
    private Integer themeId;

    /**
     * 规格ID
     */
    @TableField(value = "spec_id")
    private Long specId;


    /**
     * 规格名称（包含名称和描述，如：品鉴装 50g）
     */
    @TableField(value = "spec_name")
    private String specName;

    /**
     * 规格价格
     */
    @TableField(value = "spec_price")
    private BigDecimal specPrice;

    /**
     * 规格原价
     */
    @TableField(value = "spec_original_price")
    private BigDecimal specOriginalPrice;

    /**
     * 规格库存
     */
    @TableField(value = "spec_stock")
    private Integer specStock;

    /**
     * 规格销量
     */
    @TableField(value = "spec_sales")
    private Integer specSales;

    /**
     * 店铺ID
     */
    @TableField(value = "shop_id")
    private Integer shopId;

    /**
     * 店铺名称
     */
    @TableField(value = "shop_name")
    private String shopName;

    /**
     * LOGO表情
     */
    @TableField(value = "shop_emoji")
    private String shopEmoji;

    /**
     * 店铺标签 官方/精选/旗舰店等
     */
    @TableField(value = "shop_badge")
    private String shopBadge;

    /**
     * 
     */
    @TableField(value = "subtotal")
    private BigDecimal subtotal;

    /**
     * 
     */
    @TableField(value = "original_subtotal")
    private BigDecimal originalSubtotal;

    /**
     * 
     */
    @TableField(value = "discount_amount")
    private BigDecimal discountAmount;

    /**
     * 
     */
    @TableField(value = "stock_status")
    private String stockStatus;

    /**
     * 
     */
    @TableField(value = "shop_display_name")
    private String shopDisplayName;
}