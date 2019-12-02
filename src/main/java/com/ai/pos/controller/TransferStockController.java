package com.ai.pos.controller;

import com.ai.pos.model.MstItem;
import com.ai.pos.model.MstOutlet;
import com.ai.pos.model.MstUser;
import com.ai.pos.model.TTransferStock;
import com.ai.pos.service.MstItemService;
import com.ai.pos.service.Outlet_Service;
import com.ai.pos.service.TransferStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Resource
@Controller
public class TransferStockController {

    @Autowired
    private TransferStockService transferStockService;

    @Autowired
    private Outlet_Service outlet_service;

    @Autowired
    private MstItemService mstItemService;

    @RequestMapping(value = "/transfer_stock")
    public String index(HttpSession session,
                        Model m){
        //ADD THE TRANSFER STOCK DATA
        MstOutlet outlet = (MstOutlet) session.getAttribute("outlet");
        List<TTransferStock> transferStockList = this.transferStockService.getByFromOutletId(outlet.getId());

        //GET ALL OUTLET DATA
        List<MstOutlet> outlets = this.outlet_service.listMstOutlet();

        m.addAttribute("all_outlets", outlets);
        m.addAttribute("transfer_stock_list", transferStockList);
        m.addAttribute("content_page_url", "transfer_stock_index.jsp");
        m.addAttribute("page_title", "Transfer Stock");
        return "home";
    }

    @RequestMapping(value = "/transfer_stock_detail/{id}", method = RequestMethod.GET)
    public String transferStockDetail(@PathVariable int id,
                                      Model m){
        TTransferStock transferStock = this.transferStockService.get(id);
        m.addAttribute("transfer_stock", transferStock);
        m.addAttribute("content_page_url", "transfer_stock_detail.jsp");
        m.addAttribute("page_title", "Transfer Stock");
        return "home";
    }

    @RequestMapping(value = "/transfer_stock_detail_handle_action", method = RequestMethod.POST)
    public String transferStockDetailHandleAction(
                                    @ModelAttribute("id") int id,
                                    @ModelAttribute("status") int status,
                                    Model m){
        return "redirect:/transfer_stock";
    }

    @RequestMapping(value = "/search_transfer_item", method = RequestMethod.GET)
    public @ResponseBody
    List<MstItem> searchTransferItem(
            @RequestParam("term") String name){
        System.out.println(name);
        List<MstItem> lit = mstItemService.getByItemVariantName(name);
        return this.mstItemService.getByItemVariantName(name);
    }
}
