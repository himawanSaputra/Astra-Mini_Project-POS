package com.ai.pos.controller;

import com.ai.pos.model.MstCategory;
import com.ai.pos.service.MstCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class categoryRestController {

    @Autowired
    MstCategoryService mstCategoryService;

    @GetMapping("/rest/category/get/{id}")
    public MstCategory getOutletById(@PathVariable("id") int id, Model model){
        MstCategory mstCategory;

        if(id > 0){
            mstCategory = mstCategoryService.getCategory(id);
        } else {
            mstCategory = new MstCategory();
        }
        return mstCategory;
    }
}
