package com.ai.pos.controller;


import com.ai.pos.model.MstDistrict;
import com.ai.pos.model.MstProvince;
import com.ai.pos.model.MstRegion;
import com.ai.pos.model.MstSupplier;
import com.ai.pos.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private Service<MstSupplier> supplierService;

    @Autowired
    private Service<MstProvince> provinceService;

    @Autowired
    private Service<MstDistrict> districtService;

    @Autowired
    private Service<MstRegion> regionService;

    @GetMapping("/list")
    public String listSuppliers(Model theModel){

        List<MstSupplier> suppliers = supplierService.getAll();
        theModel.addAttribute("supplierForm", new MstSupplier());
        theModel.addAttribute("suppliers", suppliers);

        List<MstProvince> provinces = provinceService.getAll();
//        Map<Integer, String> putList = new HashMap<>();
//        for(MstProvince province:provinces){
//            putList.put(province.getId(), province.getName());
//        }
//        provinces.stream().forEach(province -> System.out.println(province.getName()));
        theModel.addAttribute("provinces", provinces);

//        List<MstDistrict> districts = districtService.getAll();
//        theModel.addAttribute("districts", districts);
//
//        List<MstRegion> regions = regionService.getAll();
//        theModel.addAttribute("regions", regions);


        return "list-suppliers";
    }

    @GetMapping("/supplierForm")
    public String supplierForm(Model theModel){
        MstSupplier theSupplier = new MstSupplier();
        theModel.addAttribute("theSupplier", theSupplier);
        return "supplier-form";
    }

    @PostMapping("/saveSupplier")
    public String saveSupplier(@ModelAttribute("supplierForm") MstSupplier theSupplier, Model theModel){
        System.out.println("here");
        if(theSupplier ==null){
            System.out.println(theSupplier);
            theModel.addAttribute(new MstSupplier());
        }

        System.out.println(theSupplier.toString());
        // save supplier
        supplierService.insert(theSupplier);
        return "redirect:/supplier/list";
    }

    @GetMapping("/updateSupplier")
    public String updateSupplier(@RequestParam(value = "supplierId")int id, Model theModel){


        MstSupplier theSupplier = supplierService.get(id);

        theModel.addAttribute("supplierForm", theSupplier);

        return "list-suppliers";
    }

    @GetMapping("/theUpdateSupplier")
    public String supplier(@RequestParam(value = "supplierId")int id, Model theModel){
        MstSupplier theSupplier = supplierService.get(id);
        theModel.addAttribute("theSupplier", theSupplier);
        return "list-suppliers";

    }


    @RequestMapping("/list")
    @ResponseBody
    public String check(@RequestParam(value = "supplierId") int id, HttpServletRequest request, HttpServletResponse response, Model model) {

        MstSupplier theSupplier = supplierService.get(id);
        model.addAttribute("theSupplier", theSupplier);
        return "list-suppliers";
//        boolean a = true;

//        if (id > -1) {
//            model.addAttribute("setId", id);
//            return "list-suppliers";
//        } else {
//            model.addAttribute("setId", id);
//            return "list-suppliers";
//        }
    }

    @GetMapping("/deleteSupplier")
    public String deleteSupplier(@RequestParam("supplierId")Integer id, Model theModel){


        MstSupplier theSupplier = supplierService.get(id);
        supplierService.delete(theSupplier);
        return "redirect:/supplier/list";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam("theSearchName") String theSearchName, Model theModel){

        List<MstSupplier> suppliers = supplierService.searchSuppliers(theSearchName);
        theModel.addAttribute("supplierForm", new MstSupplier());
        theModel.addAttribute("suppliers", suppliers);

        List<MstProvince> provinces = provinceService.getAll();
        theModel.addAttribute("provinces", provinces);
        return "list-suppliers";
    }




}
