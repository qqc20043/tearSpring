package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.pojo.MomentComment;
import com.guchen.service.MomentCommentService;
import com.guchen.mapper.MomentCommentMapper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author Administrator
* @description 针对表【moment_comment(茶友圈评论表)】的数据库操作Service实现
* @createDate 2026-03-24 19:03:29
*/
@Service
public class MomentCommentServiceImpl extends ServiceImpl<MomentCommentMapper, MomentComment>
    implements MomentCommentService{

    @Autowired
    MomentCommentMapper momentCommentMapper;

    @Override
    public Result selectList(MomentComment momentComment) {
        LambdaQueryWrapper<MomentComment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MomentComment::getMomentId, momentComment.getMomentId());
        List<MomentComment> momentComment1 = momentCommentMapper.selectList(queryWrapper);
        Result result = Result.ok("查询评论数据成功");
        result.put("momentComment", momentComment1);
        return result;
    }

    @Override
    public Result insertCommentOne(MomentComment momentComment) {
        momentComment.setCreatedAt(new Date());
        momentCommentMapper.insert(momentComment);
        return Result.ok("评论成功");
    }
}




