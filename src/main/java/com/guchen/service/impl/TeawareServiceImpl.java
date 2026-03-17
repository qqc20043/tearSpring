package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.pojo.Teaware;
import com.guchen.service.TeawareService;
import com.guchen.mapper.TeawareMapper;
import com.guchen.utils.JwtHelper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author Administrator
* @description 针对表【teaware(茶具表)】的数据库操作Service实现
* @createDate 2026-03-16 11:12:30
*/
@Service
public class TeawareServiceImpl extends ServiceImpl<TeawareMapper, Teaware>
    implements TeawareService{

    @Autowired
    HttpServletRequest request;

    @Autowired
    JwtHelper jwtHelper;

    @Autowired
    TeawareMapper teawareMapper;

    @Override
    public Result selectTeawareId() {
        String token = request.getHeader("token");
        Long userId = jwtHelper.getUserId(token);
        LambdaQueryWrapper<Teaware> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Teaware::getUserId, userId);
        List<Teaware> teawareList = teawareMapper.selectList(queryWrapper);
        Result result = Result.ok("获取茶具成功！");
        result.put("teawareList", teawareList);
        return result;
    }
}




