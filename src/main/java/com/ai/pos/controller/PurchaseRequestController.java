package com.ai.pos.controller;


import com.ai.pos.model.TPr;
import com.ai.pos.model.TPrDetail;
import com.ai.pos.service.TPrDetail_Service;
import com.ai.pos.service.TPr_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PurchaseRequestController {

    @Autowired
    TPr_Service tPr_service;

    @Autowired
    TPrDetail_Service tPrDetail_service;

    @RequestMapping(value = "/purchase_request", method = RequestMethod.GET)
    public String purchaseRequestList(@ModelAttribute TPr tPr,
                                  Model model,
                                  HttpSession session) {

        //get all list from TPr
        List<TPr> tPrList = tPr_service.listTPr();
        model.addAttribute("listTPr", tPrList);

        //get all list from TPrDetail
        List<TPrDetail> tPrDetailsList = tPrDetail_service.listTPrDetail();
        model.addAttribute("listTPrDetail",tPrDetailsList);

        model.addAttribute("content_page_url", "purchase_request.jsp");
        model.addAttribute("page_title", "Purchase Request");
        return "home";
    }
}
