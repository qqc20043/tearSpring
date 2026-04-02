package com.guchen.controller;

import com.guchen.pojo.*;
import com.guchen.service.*;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("moment")
@CrossOrigin
public class momentController {

    @Autowired
    VMomentDetailService vmomentDetailService;

    @Autowired
    MomentCommentService momentCommentService;

    @Autowired
    MomentLikeService momentLikeService;

    @Autowired
    MomentImageService momentImageService;

    @Autowired
    MomentService momentService;

    @GetMapping("list")
    public Result list(){
        Result result = vmomentDetailService.selectList();
        return result;
    }

    @PostMapping("insertMoment")
    public Result insertMoment(@RequestBody Moment moment){
        Result result = momentService.insertMoment(moment);
        return result;
    }

    @PostMapping("commentList")
    public Result commentList(@RequestBody MomentComment momentComment){
        Result result = momentCommentService.selectList(momentComment);
        return result;
    }

    @PostMapping("likeFlag")
    public Result likeFlag(@RequestBody MomentLike momentLike){
        Result result = momentLikeService.selectFlag(momentLike);
        return result;
    }

    @PostMapping("imageList")
    public Result imageList(@RequestBody MomentImage momentImage){
        Result result = momentImageService.selectImageList(momentImage);
        return result;
    }

    @PostMapping("insertImage")
    public Result insertImage(@RequestBody MomentImage momentImage){
        Result result = momentImageService.insertImage(momentImage);
        return result;
    }


    @PostMapping("updateLike")
    public Result updateLike(@RequestBody MomentLike momentLike){
        Result result = momentLikeService.updateMomentLike(momentLike);
        return result;
    }

    @PostMapping("insertComment")
    public Result insertComment(@RequestBody MomentComment momentComment){
        Result result = momentCommentService.insertCommentOne(momentComment);
        return result;
    }
}
