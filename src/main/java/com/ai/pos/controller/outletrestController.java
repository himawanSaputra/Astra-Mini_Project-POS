package com.ai.pos.controller;

import com.ai.pos.model.MstOutlet;
import com.ai.pos.service.Location_Service;
import com.ai.pos.service.Outlet_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class outletrestController {

    @Autowired
    Outlet_Service outlet_service;

    @Autowired
    Location_Service location_service;

    @GetMapping("/rest/outlet/get/{id}")
    public MstOutlet getOutletById(@PathVariable("id") int id, Model model){
        MstOutlet mstOutlet;
        if(id>0){
            mstOutlet = outlet_service.getMstOutlet(id);

        } else {
            mstOutlet = new MstOutlet();
        }

        return mstOutlet;
    }

}
