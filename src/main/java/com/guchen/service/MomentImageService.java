package com.guchen.service;

import com.guchen.pojo.MomentImage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【moment_image(茶友圈动态emoji图片表)】的数据库操作Service
* @createDate 2026-03-25 10:38:13
*/
public interface MomentImageService extends IService<MomentImage> {
    Result selectImageList(MomentImage momentImage);
    Result insertImage(MomentImage momentImage);
}
