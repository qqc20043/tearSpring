package com.guchen.controller;

import com.guchen.service.CategoryService;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
@CrossOrigin
public class categoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("lists")
    public Result list() {
        Result result = categoryService.lists();
        return result;
    }
}
