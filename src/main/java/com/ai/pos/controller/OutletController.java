package com.ai.pos.controller;

import com.ai.pos.model.MstOutlet;
import com.ai.pos.service.Outlet_Service;
import com.ai.pos.service.Outlet_ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Resource
public class OutletController {

//    @Autowired
//    Outlet_Service outlet_service;
//
//    @Autowired
//    Customer_Service customer_service;

    @Autowired
    Outlet_Service outlet_service;

//    @RequestMapping(value = "/outlet")
//    public String getAllOutlet(ModelMap mv){
//        List<MstOutlet> list = Outlet_Service.listMstOutlet();
//        mv.addAttribute("allOutlet", list);
//        mv.addAttribute("outlet", new MstOutlet());
//        return "outlet/indexOutlet";
//    }

    @RequestMapping("/outlet")
    public ModelAndView getAllCategory(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("outlet/outlet");
        List<MstOutlet> list = outlet_service.listMstOutlet();
        mv.addObject("allCategory", list);
        return mv;
    }


    @RequestMapping(value = "/saveOutlet", method = RequestMethod.POST)
    public String saveOutlet (@ModelAttribute("outlet") MstOutlet mstOutlet){
        mstOutlet.setActive(true);
        outlet_service.addOutlet(mstOutlet);
        return "redirect:/outlet";
    }
}
