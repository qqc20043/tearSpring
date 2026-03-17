package com.guchen.controller;

import com.guchen.pojo.Teaware;
import com.guchen.pojo.VProductShopFull;
import com.guchen.pojo.VThemeProductCategory;
import com.guchen.service.ProductService;
import com.guchen.service.TeawareService;
import com.guchen.service.VProductShopFullService;
import com.guchen.service.VThemeProductCategoryService;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
@CrossOrigin
public class productController {

    @Autowired
    VProductShopFullService vProductShopFullService;

    @Autowired
    VThemeProductCategoryService vThemeProductCategoryService;

    @Autowired
    ProductService productService;

    @Autowired
    TeawareService teawareService;

    @PostMapping("selectSingle")
    public Result selectSingle(@RequestBody VProductShopFull vProductShopFull) {
        Result result = vProductShopFullService.selectVProductShopFullById(vProductShopFull);
        return result;
    }

    @PostMapping("ThemeSingle")
    public Result ThemeSingle(@RequestBody VThemeProductCategory vThemeProductCategory) {
        Result result = vThemeProductCategoryService.selectProductTheme(vThemeProductCategory);
        return result;
    }

    @GetMapping("shopSpecList")
    public Result shopSpecList() {
        Result result = productService.selectShopSpecList();
        return result;
    }

    @GetMapping("teaware")
    public Result teaware() {
        Result result = teawareService.selectTeawareId();
        return result;
    }

}
