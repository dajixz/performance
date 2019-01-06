package com.apsd.performance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 大稽
 * @date2019/1/513:05
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String toIndexView(){
        return "index";
    }
}
