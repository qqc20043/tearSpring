package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.pojo.MomentImage;
import com.guchen.service.MomentImageService;
import com.guchen.mapper.MomentImageMapper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author Administrator
* @description 针对表【moment_image(茶友圈动态emoji图片表)】的数据库操作Service实现
* @createDate 2026-03-25 10:38:13
*/
@Service
public class MomentImageServiceImpl extends ServiceImpl<MomentImageMapper, MomentImage>
    implements MomentImageService{

    @Autowired
    MomentImageMapper momentImageMapper;

    @Override
    public Result selectImageList(MomentImage momentImage) {
        Long momentId = momentImage.getMomentId();
        LambdaQueryWrapper<MomentImage> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MomentImage::getMomentId, momentId);
        List<MomentImage> imageList = momentImageMapper.selectList(wrapper);
        Result result = Result.ok("查询动态emoji图片成功");
        result.put("imageList", imageList);
        return result;
    }

    @Override
    public Result insertImage(MomentImage momentImage) {
        momentImage.setCreatedAt(new Date());
        momentImageMapper.insert(momentImage);
        Result result = Result.ok("动态emoji图片发布成功！");
        return result;
    }
}




