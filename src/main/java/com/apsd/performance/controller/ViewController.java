package com.apsd.performance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 大稽
 * @date2019/1/513:06
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    @GetMapping("/educational_reform")
    public String toEducationalReformView(){
        return "educational_reform";
    }

    @GetMapping("/teaching_quality")
    public String toTeachingQualityView(){
        return "teaching_quality";
    }
    @GetMapping("/teaching_quality_form")
    public String toTeachingQualityFormView(){
        return "teaching_quality_form";
    }
}
