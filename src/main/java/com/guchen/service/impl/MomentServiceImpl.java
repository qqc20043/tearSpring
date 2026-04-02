package com.guchen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.pojo.Moment;
import com.guchen.service.MomentService;
import com.guchen.mapper.MomentMapper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

/**
* @author Administrator
* @description 针对表【moment(茶友圈动态表)】的数据库操作Service实现
* @createDate 2026-03-24 19:03:25
*/
@Service
public class MomentServiceImpl extends ServiceImpl<MomentMapper, Moment>
    implements MomentService{

    @Autowired
    MomentMapper momentMapper;

    @Override
    public Result insertMoment(Moment moment) {
        moment.setCreatedAt(new Date());
        System.out.println("前端传来的动态数据：" + moment);
        momentMapper.insert(moment);
        Long newId = moment.getId();
        Result result = Result.ok("动态发布成功！");
        result.put("newId", newId);
        return result;
    }
}




