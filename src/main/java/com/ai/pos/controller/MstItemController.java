package com.ai.pos.controller;

import com.ai.pos.model.ItemInventory;
import com.ai.pos.model.MstItem;
import com.ai.pos.service.ItemInventoryService;
import com.ai.pos.service.MstItemService;
import com.ai.pos.service.MstItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Resource
public class MstItemController {

//    @Autowired
//    MstItemService mstItemService;

//    @RequestMapping(value = "/item")
//    public String getAllItem(ModelMap mv){
//        List<MstItem> list = mstItemService.getAllItem();
//        mv.addAttribute("allItem", list);
//        mv.addAttribute("item", new MstItem());
//        mv.addAttribute("content_page_url", "item/indexItem.jsp");
//        mv.addAttribute("page_title", "Item");
//        return "home";
//    }

    @Autowired
    ItemInventoryService itemInventoryService;

    @RequestMapping(value = "/item")
    public String getAllItem(ModelMap mv){
        List<ItemInventory> list = itemInventoryService.getAllItemInventory();
        mv.addAttribute("allItem", list);
        mv.addAttribute("item", new ItemInventory());
        mv.addAttribute("content_page_url", "item/indexItem.jsp");
        mv.addAttribute("page_title", "Item");
        return "home";
    }

}
