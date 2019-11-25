package com.ai.pos.controller;

import com.ai.pos.model.MstCategory;
import com.ai.pos.service.MstCategoryServiceImpl;
import com.ai.pos.service.MstItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MstCategoryController {

    @Autowired
    MstCategoryServiceImpl mstCategoryService;

    @Autowired
    MstItemServiceImpl mstItemService;

    @RequestMapping("/category")
    public ModelAndView getAllCategory(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("category");
        List<MstCategory> list = mstCategoryService.getAllCategory();
        mv.addObject("allCategory", list);
        return mv;
    }
}
