package com.ai.pos.controller;

import com.ai.pos.model.MstCategory;
import com.ai.pos.model.MstEmployee;
import com.ai.pos.service.MstCategoryService;
import com.ai.pos.service.MstCategoryServiceImpl;
import com.ai.pos.service.MstItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Resource
public class MstCategoryController {

    @Autowired
    MstCategoryService mstCategoryService;

    @RequestMapping(value = "/category")
    public String getAllCategory(ModelMap mv){
        List<MstCategory> list = mstCategoryService.getAllCategory();
        mv.addAttribute("allCategory",list);
        mv.addAttribute("category",new MstCategory());
//        mv.addAttribute("category2",new MstCategory());
        mv.addAttribute("content_page_url", "category/indexCategory.jsp");
        mv.addAttribute("page_title", "Category");
        return "home";
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
        this.mstCategoryService.saveOrUpdate(mstCategory);
        return "redirect:/category";
    }

    @RequestMapping(value = "/removeStatusCategory", method = RequestMethod.POST)
    public String removeStatusCategory(@ModelAttribute("category") MstCategory mstCategory){
        mstCategory.setActive(false);
        this.mstCategoryService.saveOrUpdate(mstCategory);
        return "redirect:/category";
    }

    @RequestMapping(value="/update/{id}" , method = RequestMethod.GET)
    public @ResponseBody
    MstCategory getCategory(@PathVariable int id) {
        MstCategory category = mstCategoryService.getCategory(id);
        System.out.println(category.getId());
        return category;
    }

//    @RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
//    public String updateCategory(@ModelAttribute("category") MstCategory mstCategory, Model model){
//        mstCategoryService.saveOrUpdate(mstCategory);
//        model.addAttribute("updateCategory",  new MstCategory());
//        return "redirect:/category";
//    }

//    @RequestMapping(value = "/remove_category/{id}", method = RequestMethod.POST)
//    public String removeCategory(@PathVariable int id){
//        MstCategory category = this.mstCategoryService.getCategory(id);
//        category.setActive(false);
//        this.mstCategoryService.saveOrUpdate(category);
//        return "redirect:/category";
//    }

//    @RequestMapping(value="/edit/{id}")
//    public ModelAndView addView(@PathVariable int id) {
//        MstCategory mstCategory = mstCategoryService.getCategory(id);
//        return new ModelAndView("category/indexCategory", "category", mstCategory );
//    }

}
