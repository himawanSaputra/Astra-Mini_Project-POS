package com.ai.pos.controller;

import com.ai.pos.model.MstItem;
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

    @Autowired
    MstItemServiceImpl mstItemService;

    @RequestMapping(value = "/item")
    public String getAllItem(ModelMap mv){
        List<MstItem> list = mstItemService.getAllItem();
        mv.addAttribute("allItem", list);
        mv.addAttribute("item", new MstItem());
        return "item/indexItem";
    }
}
