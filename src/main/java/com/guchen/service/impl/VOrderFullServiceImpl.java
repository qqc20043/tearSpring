package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.pojo.VOrderFull;
import com.guchen.service.VOrderFullService;
import com.guchen.mapper.VOrderFullMapper;
import com.guchen.utils.JwtHelper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
* @author Administrator
* @description 针对表【v_order_full】的数据库操作Service实现
* @createDate 2026-04-02 14:42:56
*/
@Service
public class VOrderFullServiceImpl extends ServiceImpl<VOrderFullMapper, VOrderFull>
    implements VOrderFullService{

    @Autowired
    VOrderFullMapper vOrderFullMapper;

    @Autowired
    HttpServletRequest request;

    @Autowired
    JwtHelper jwtHelper;

    @Override
    public Result selectVOrderData() {
        Long userId = jwtHelper.getUserId(request.getHeader("token"));
        VOrderFull vOrderFull = vOrderFullMapper.selectOne(new LambdaQueryWrapper<VOrderFull>().eq(VOrderFull::getUserId, userId));
        if (vOrderFull == null) {
            return Result.ok("用户未下单");
        }
        Result result = Result.ok("用户已下单");
        result.put("vOrderFull", vOrderFull);
        return result;
    }
}




