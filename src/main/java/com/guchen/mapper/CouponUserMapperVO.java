package com.guchen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guchen.pojo.CouponUser;
import com.guchen.pojo.CouponUserVO;
import com.guchen.pojo.ThemeProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【coupon_user(用户优惠券表)】的数据库操作Mapper
 * @createDate 2026-03-08 16:27:42
 * @Entity com.guchen.pojo.CouponUser
 */
public interface CouponUserMapperVO extends BaseMapper<CouponUserVO> {
    List<CouponUserVO> selectCouponUserVO(@Param("userID") Long userID);
}