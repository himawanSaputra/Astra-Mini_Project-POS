package com.ai.pos.controller;

import com.ai.pos.model.MstOutlet;
import com.ai.pos.model.MstUser;
import com.ai.pos.model.TTransferStock;
import com.ai.pos.service.TransferStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
