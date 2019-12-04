package com.ai.pos.controller;

import com.ai.pos.model.MstDistrict;
import com.ai.pos.model.MstOutlet;
import com.ai.pos.model.MstProvince;
import com.ai.pos.model.MstRegion;
import com.ai.pos.service.Customer_Service;
import com.ai.pos.service.Location_Service;
import com.ai.pos.service.Outlet_Service;
import com.ai.pos.service.Outlet_ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Autowired
    Location_Service location_service;

    @RequestMapping(value = "/outlet",  method = RequestMethod.GET)
    public String getAllCategory(@ModelAttribute MstOutlet mstOutlet, Model model){
        List<MstOutlet> list = outlet_service.listMstOutlet();
        model.addAttribute("outlets", list );

        //view list Province
        List<MstProvince> provinceList = location_service.getAllProvince() ;
        Map<Integer, String> provinces = new HashMap<>();
        for (MstProvince curProvince : provinceList){
            provinces.put(curProvince.getId(), curProvince.getName());
        }

        //view list Region
        List<MstRegion> regionList = location_service.getAllRegion() ;
        Map<Integer, String> regions = new HashMap<>();
        for (MstRegion curRegion : regionList){
            regions.put(curRegion.getId(), curRegion.getName());
        }

        //view list Disctrict
        List<MstDistrict> districtList = location_service.getAllDistrict() ;
        Map<Integer, String> disctricts = new HashMap<>();
        for (MstDistrict curDisctrict : districtList){
            disctricts.put(curDisctrict.getId(), curDisctrict.getName());
        }

        model.addAttribute("outlet",new MstOutlet());
        model.addAttribute("provinceList",provinces);
        model.addAttribute("regionList",regions);
        model.addAttribute("districtList",disctricts);

        model.addAttribute("content_page_url", "outlet.jsp");
        model.addAttribute("page_title", "Outlet");
        return "home";
    }

    // save outlet
    @RequestMapping(value= "/outlet", method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.OK)
    public String addOutlet(@ModelAttribute("add_outlet") MstOutlet mstOutlet){
        mstOutlet.setActive(true);
        this.outlet_service.saveOrUpdateOutlet(mstOutlet);
        return "redirect:/outlet";


    }

//
//    @RequestMapping(value = "/saveOutlet", method = RequestMethod.POST)
//    public String saveOutlet (@ModelAttribute("outlet") MstOutlet mstOutlet){
//        mstOutlet.setActive(true);
//        outlet_service.addOutlet(mstOutlet);
//        return "redirect:/outlet";
//    }
}
