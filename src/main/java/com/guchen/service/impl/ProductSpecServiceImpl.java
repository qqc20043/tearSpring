package com.guchen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.pojo.ProductSpec;
import com.guchen.service.ProductSpecService;
import com.guchen.mapper.ProductSpecMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【product_spec(商品规格表)】的数据库操作Service实现
* @createDate 2026-03-10 23:07:56
*/
@Service
public class ProductSpecServiceImpl extends ServiceImpl<ProductSpecMapper, ProductSpec>
    implements ProductSpecService{

}




