package com.guchen.service;

import com.guchen.pojo.MomentComment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【moment_comment(茶友圈评论表)】的数据库操作Service
* @createDate 2026-03-24 19:03:29
*/
public interface MomentCommentService extends IService<MomentComment> {
    Result selectList(MomentComment momentComment);
    Result insertCommentOne(MomentComment momentComment);
}
