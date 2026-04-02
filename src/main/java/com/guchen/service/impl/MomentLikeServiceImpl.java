package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.pojo.MomentLike;
import com.guchen.service.MomentLikeService;
import com.guchen.mapper.MomentLikeMapper;
import com.guchen.utils.JwtHelper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
* @author Administrator
* @description 针对表【moment_like(茶友圈点赞表)】的数据库操作Service实现
* @createDate 2026-03-24 19:03:32
*/
@Service
public class MomentLikeServiceImpl extends ServiceImpl<MomentLikeMapper, MomentLike>
    implements MomentLikeService{

    @Autowired
    MomentLikeMapper momentLikeMapper;

    @Autowired
    JwtHelper jwtHelper;

    @Autowired
    HttpServletRequest request;

    @Override
    public Result selectFlag(MomentLike momentLike) {
        Long userId = jwtHelper.getUserId(request.getHeader("token"));
        LambdaQueryWrapper<MomentLike> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MomentLike::getMomentId, momentLike.getMomentId());
        List<MomentLike> list = momentLikeMapper.selectList(wrapper);
        for (MomentLike m : list) {
            if (m.getUserId().equals(userId)) {
                Result result = Result.ok("已点赞");
                result.put("flag", true);
                return result;
            }
        }
        Result result = Result.ok("未点赞");
        result.put("flag", false);
        return result;
    }

    @Override
    public Result updateMomentLike(MomentLike momentLike) {
        Long userId = jwtHelper.getUserId(request.getHeader("token"));
        LambdaQueryWrapper<MomentLike> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MomentLike::getMomentId, momentLike.getMomentId());
        wrapper.eq(MomentLike::getUserId, userId);
        MomentLike momentLike1 = momentLikeMapper.selectOne(wrapper);
        if (momentLike1 == null) {
            momentLike.setCreatedAt(new Date());
            momentLike.setUserId(userId);
            momentLikeMapper.insert(momentLike);
            Result result = Result.ok("点赞成功");
            return result;
        }
        momentLikeMapper.deleteById(momentLike1.getId());
        Result result = Result.ok("取消点赞成功");
        return result;
    }
}




