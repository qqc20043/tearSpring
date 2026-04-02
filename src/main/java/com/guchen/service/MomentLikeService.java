package com.guchen.service;

import com.guchen.pojo.MomentLike;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【moment_like(茶友圈点赞表)】的数据库操作Service
* @createDate 2026-03-24 19:03:32
*/
public interface MomentLikeService extends IService<MomentLike> {
    Result selectFlag(MomentLike momentLike);
    Result updateMomentLike(MomentLike momentLike);
}
