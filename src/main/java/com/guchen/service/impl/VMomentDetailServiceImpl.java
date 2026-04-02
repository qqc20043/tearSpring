package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.pojo.VMomentDetail;
import com.guchen.service.VMomentDetailService;
import com.guchen.mapper.VMomentDetailMapper;
import com.guchen.utils.JwtHelper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author Administrator
* @description 针对表【v_moment_detail】的数据库操作Service实现
* @createDate 2026-03-24 18:10:24
*/
@Service
public class VMomentDetailServiceImpl extends ServiceImpl<VMomentDetailMapper, VMomentDetail>
    implements VMomentDetailService{

    @Autowired
    JwtHelper jwtHelper;

    @Autowired
    HttpServletRequest request;

    @Autowired
    VMomentDetailMapper vMomentDetailMapper;

    @Override
    public Result selectList() {
        LambdaQueryWrapper<VMomentDetail> wrapper = new LambdaQueryWrapper<>();
        List<VMomentDetail> list = vMomentDetailMapper.selectList(wrapper);
        Result result = Result.ok("查询成功");
        result.put("list", list);
        return result;
    }
}




