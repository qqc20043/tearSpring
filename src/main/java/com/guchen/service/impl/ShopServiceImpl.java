package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.pojo.Shop;
import com.guchen.service.ShopService;
import com.guchen.mapper.ShopMapper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【shop(店铺表)】的数据库操作Service实现
* @createDate 2026-03-11 21:40:14
*/
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop>
    implements ShopService{

    @Autowired
    ShopMapper shopMapper;

    @Override
    public Result selectSingleOne(Shop shop) {
        LambdaQueryWrapper<Shop> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Shop::getId, shop.getId());
        Shop shop1 = shopMapper.selectOne(wrapper);
        Result result = Result.ok("店铺消息信息获取成功！");
        result.put("shopData", shop1);
        return result;
    }
}




