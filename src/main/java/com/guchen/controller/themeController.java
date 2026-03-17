package com.guchen.controller;

import com.guchen.service.ThemeProductService;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.guchen.service.ThemeService;

@RestController
@RequestMapping("theme")
@CrossOrigin
public class themeController {

    @Autowired
    ThemeService themeService;

    @Autowired
    ThemeProductService themeProductService;

    @GetMapping("lists")
    public Result lists() {
        Result result = themeService.lists();
        return result;
    }

    @GetMapping("themeProductList")
    public Result themeProductList() {
        Result result = themeProductService.selectThemeProductList();
        return result;
    }

}
