package com.ai.pos.controller;

import com.ai.pos.model.MstOutlet;
import com.ai.pos.service.Customer_Service;
import com.ai.pos.service.Outlet_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("Outlet")
public class OutletController {

    @Autowired
    Outlet_Service outlet_service;

    @Autowired
    Customer_Service customer_service;

    @RequestMapping("")
    public ModelAndView getAllCategory(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("outlet");
        List<MstOutlet> list = outlet_service.listMstOutlet();
        mv.addObject("allCategory", list);
        return mv;
    }
}
