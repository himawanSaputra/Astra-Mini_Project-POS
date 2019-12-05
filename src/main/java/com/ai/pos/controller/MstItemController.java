package com.ai.pos.controller;

import com.ai.pos.model.*;
import com.ai.pos.service.MstItemInventoryService;
import com.ai.pos.service.MstCategoryService;
import com.ai.pos.service.MstItemService;
import com.ai.pos.service.MstItemVariantService;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Resource
public class MstItemController {

    @Autowired
    MstItemInventoryService itemInventoryService;

    @Autowired
    MstItemService mstItemService;

    @Autowired
    MstItemVariantService mstItemVariantService;

    @Autowired
    MstCategoryService mstCategoryService;

    @RequestMapping(value = "/item",  method = RequestMethod.GET)
    public String getAllItem(@ModelAttribute ItemInventory itemInventory, Model model){
        List<ItemInventory> list = itemInventoryService.getAllItemInventory();
        model.addAttribute("items", list );

        //view list Category
        List<MstCategory> categoryList = mstCategoryService.getAllCategory();
        Map<Integer, String> category = new HashMap<>();
        for (MstCategory curCategory : categoryList){
            category.put(curCategory.getId(), curCategory.getName());
        }

        List<ItemInventory> variantList = itemInventoryService.getAllItemInventory();
        model.addAttribute("variants", variantList);

        ItemInventory itemInventory1 = new ItemInventory();
        itemInventory1.setMstOutlet(new MstOutlet());
        itemInventory1.setMstItemVariant(new MstItemVariant());
//        itemInventory1.getMstItemVariant().getMstItem().setCategory_id(new MstCategory());

        model.addAttribute("item", itemInventory1);
        model.addAttribute("categoryList",category);
        model.addAttribute("content_page_url", "item/indexItem.jsp");
        model.addAttribute("page_title", "Items");
        return "home";
    }

    @RequestMapping(value = "/saveItem", method = RequestMethod.POST)
    public String saveItem(
            @ModelAttribute("item") ItemInventory itemInventory,
            @RequestParam(required= false, value = "varId") int[] ids,
            @RequestParam(required = false, value = "varName") int[] names,
            @RequestParam(required = false, value = "sku") int[] skus,
            @RequestParam(required = false, value = "inStock") int[] inStocks,
            @RequestParam(required = false, value = "alertAt") int[] alertAt){
//        itemInventory.setAlertAtQty(2);
//        itemInventory.setBeginning(5);
//        itemInventory.setEndingQty(7);
        itemInventory.getMstItemVariant().getMstItem().setActive(true);
        itemInventory.getMstItemVariant().setActive(true);
//        itemInventory.getMstItemVariant().setName("coba");
//        itemInventory.getMstItemVariant().setPrice(7893.949);
//        itemInventory.getMstItemVariant().setSku("yagsh");

        itemInventory.setMstOutlet(new MstOutlet());
        itemInventory.getMstOutlet().setId(1);
//        itemInventory.getMstItemVariant().getMstItem().getMstCategory().setName("Data Coba Static");

        //save item, set id item di variant, save variant, buat outlet set id,
        mstItemService.save(itemInventory.getMstItemVariant().getMstItem());
//        itemInventory.getMstItemVariant().setMstItem();
        System.out.println("AIDINYA:" + itemInventory.getMstItemVariant().getMstItem().getId());
        mstItemVariantService.save(itemInventory.getMstItemVariant());

//        itemInventory.setMstItemVariant(new MstItemVariant());
        itemInventoryService.save(itemInventory);
        return "redirect:/item";
    }


}
