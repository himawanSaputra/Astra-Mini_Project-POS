package com.ai.pos.controller;

import com.ai.pos.model.MstDistrict;
import com.ai.pos.model.MstProvince;
import com.ai.pos.model.MstRegion;
import com.ai.pos.model.MstSupplier;
import com.ai.pos.model.test.User;
import com.ai.pos.service.*;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RestSupplierController {

    @Autowired
    private Service<MstSupplier> supplierService;

    @Autowired
    private Service<MstProvince> provinceService;

    @Autowired
    private Service<MstRegion> regionService;

    @Autowired
    private Service<MstDistrict> districtService;

    @Autowired
    private IRegionService iRegionService;

    @Autowired
    private IDistrictService iDistrictService;


    @GetMapping("/rest/supplier/get/{id}")
    public MstSupplier getSupplierById(@PathVariable("id") int id, Model theModel) {
        MstSupplier theSupplier;
        if (id > 0) {
            theSupplier = supplierService.get(id);
            System.out.println(theSupplier.toString());
//            System.out.println(theSupplier.getMstProvince().toString());
            theModel.addAttribute("supplierForm", theSupplier);
        } else {

            theSupplier = new MstSupplier();
        }
        return theSupplier;
    }

    @GetMapping("/rest/region/getFromProvince/{id}")
    public List<MstRegion> getRegion(@PathVariable("id") int id){
        List<MstRegion> regions = iRegionService.getByProvince(id);
        return regions;
    }

    @GetMapping("/rest/district/getFromRegion/{id}")
    public List<MstDistrict> getDistrict(@PathVariable("id") int id){
        List<MstDistrict> districts = iDistrictService.getByRegion(id);
        return districts;
    }

    public List<MstSupplier> getSuppliers() {
        return supplierService.getAll();
    }
}
