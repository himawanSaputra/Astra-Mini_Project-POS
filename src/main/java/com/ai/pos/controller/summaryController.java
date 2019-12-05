package com.ai.pos.controller;

import com.ai.pos.model.ItemInventory;
import com.ai.pos.model.MstCategory;
import com.ai.pos.model.MstItem;
import com.ai.pos.service.MstCategoryService;
import com.ai.pos.service.MstItemInventoryService;
import com.ai.pos.service.TransferStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Resource
public class summaryController {

    @Autowired
    MstItemInventoryService mstItemInventoryService;

    @Autowired
    MstCategoryService mstCategoryService;

    @Autowired
    TransferStockService transferStockService;

    @RequestMapping(value = "/summary", method = RequestMethod.GET)
    public String defaultSummaryController(Model model){
        model.addAttribute("content_page_url", "summary.jsp");
        model.addAttribute("page_title", "Summary");
        return "home";
    }

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public String getAllItem(ModelMap mv){
//        List<ItemInventory> list = itemInventoryService.getAllItemInventory();
//        mv.addAttribute("allItem", list);
//        mv.addAttribute("item", new ItemInventory());
//        mv.addAttribute("content_page_url", "summary.jsp");
//        mv.addAttribute("page_title", "Item");
//        return "redirect/summary";
//    }

}
