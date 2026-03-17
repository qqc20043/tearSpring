package com.guchen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 收货地址表
 * @TableName address
 */
@TableName(value ="address")
@Data
public class Address {
    /**
     * 地址ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 收货人姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 标签 家/公司/学校
     */
    @TableField(value = "tag")
    private String tag;

    /**
     * 省
     */
    @TableField(value = "province")
    private String province;

    /**
     * 省代码
     */
    @TableField(value = "province_code")
    private String provinceCode;

    /**
     * 市
     */
    @TableField(value = "city")
    private String city;

    /**
     * 市代码
     */
    @TableField(value = "city_code")
    private String cityCode;

    /**
     * 区
     */
    @TableField(value = "district")
    private String district;

    /**
     * 区代码
     */
    @TableField(value = "district_code")
    private String districtCode;

    /**
     * 详细地址
     */
    @TableField(value = "detail")
    private String detail;

    /**
     * 完整地址
     */
    @TableField(value = "full_address")
    private String fullAddress;

    /**
     * 是否默认 0-否 1-是
     */
    @TableField(value = "is_default")
    private Integer isDefault;

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