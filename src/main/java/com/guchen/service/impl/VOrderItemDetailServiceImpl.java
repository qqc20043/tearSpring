package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.pojo.VOrderItemDetail;
import com.guchen.service.VOrderItemDetailService;
import com.guchen.mapper.VOrderItemDetailMapper;
import com.guchen.utils.JwtHelper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author Administrator
* @description 针对表【v_order_item_detail】的数据库操作Service实现
* @createDate 2026-04-02 19:34:14
*/
@Service
public class VOrderItemDetailServiceImpl extends ServiceImpl<VOrderItemDetailMapper, VOrderItemDetail>
    implements VOrderItemDetailService{

    @Autowired
    HttpServletRequest request;

    @Autowired
    JwtHelper jwtHelper;

    @Autowired
    VOrderItemDetailMapper vOrderItemDetailMapper;

    @Override
    public Result selectVOrderItemDetail() {
        String token = request.getHeader("token");
        Long userId = jwtHelper.getUserId(token);
        LambdaQueryWrapper<VOrderItemDetail> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(VOrderItemDetail::getUserId, userId);
        List<VOrderItemDetail> vOrderItemDetailList = vOrderItemDetailMapper.selectList(queryWrapper);
        if(vOrderItemDetailList.isEmpty()) return Result.error("用户没有订单详情！");
        Result result = Result.ok("获取用户订单详情成功！");
        result.put("vOrderItemDetailList", vOrderItemDetailList);
        return result;
    }
}




