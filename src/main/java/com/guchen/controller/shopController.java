package com.guchen.controller;

import com.guchen.pojo.Shop;
import com.guchen.pojo.VShopProducts;
import com.guchen.service.ShopService;
import com.guchen.service.VShopProductsService;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shop")
@CrossOrigin
public class shopController {

    @Autowired
    ShopService shopService;

    @Autowired
    VShopProductsService vShopProductsService;

    @PostMapping("SingleOne")
    public Result SingleOne(@RequestBody Shop shop) {
        Result result = shopService.selectSingleOne(shop);
        return result;
    }

    @PostMapping("productList")
    public Result productList(@RequestBody VShopProducts vShopProducts) {
        Result result = vShopProductsService.selectProductList(vShopProducts);
        return result;
    }

}
