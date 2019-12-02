package com.ai.pos.controller;

import com.ai.pos.model.MstCategory;
import com.ai.pos.service.MstCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Resource
public class MstCategoryController {

    @Autowired
    MstCategoryServiceImpl mstCategoryService;

    @RequestMapping(value = "/category")
    public String getAllCategory(ModelMap mv){
        List<MstCategory> list = mstCategoryService.getAllCategory();
        mv.addAttribute("allCategory",list);
        mv.addAttribute("category",new MstCategory());
        return "category/indexCategory";
    }

    @RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
    public String saveCategory (@ModelAttribute("category") MstCategory mstCategory){
        mstCategory.setActive(true);
        mstCategoryService.save(mstCategory);
        return "redirect:/category";
    }

//    @RequestMapping(value="/edit/{id}")
//    public ModelAndView addView(@PathVariable int id) {
//        MstCategory mstCategory = mstCategoryService.getCategory(id);
//        return new ModelAndView("category/indexCategory", "category", mstCategory );
//    }

    @RequestMapping(value = "/editCategory", method = RequestMethod.POST)
    public String editCategory(@ModelAttribute("category") MstCategory mstCategory){
        mstCategoryService.update(mstCategory);
        return "redirect:/category";
    }

}
