package com.ai.pos.controller;

import com.ai.pos.model.MstOutlet;
import com.ai.pos.model.MstUser;
import com.ai.pos.model.TTransferStock;
import com.ai.pos.service.TransferStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Resource
@Controller
public class TransferStockController {

    @Autowired
    private TransferStockService transferStockService;

    @RequestMapping(value = "/transfer_stock")
    public String index(HttpSession session,
                        Model m){
        //ADD THE TRANSFER STOCK DATA
        MstOutlet outlet = (MstOutlet) session.getAttribute("outlet");
        List<TTransferStock> transferStockList = this.transferStockService.getByFromOutletId(outlet.getId());

        m.addAttribute("transfer_stock_list", transferStockList);
        m.addAttribute("content_page_url", "transfer_stock_index.jsp");
        return "home";
    }

    @RequestMapping(value = "/transfer_stock_detail/{id}", method = RequestMethod.GET)
    public String transferStockDetail(@PathVariable int id,
                                      Model m){
        TTransferStock transferStock = this.transferStockService.get(id);
        m.addAttribute("transfer_stock", transferStock);
        m.addAttribute("content_page_url", "transfer_stock_detail.jsp");
        return "home";
    }

    @RequestMapping(value = "/transfer_stock_detail_handle_action", method = RequestMethod.POST)
    public String transferStockDetailHandleAction(
                                    @ModelAttribute("id") int id,
                                    @ModelAttribute("status") int status,
                                    Model m){
        return "redirect:/transfer_stock";
    }
}
