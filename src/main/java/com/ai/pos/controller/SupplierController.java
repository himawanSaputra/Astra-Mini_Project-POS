package com.ai.pos.controller;


import com.ai.pos.model.MstSupplier;
import com.ai.pos.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private Service<MstSupplier> supplierService;

    @GetMapping("/list")
    public String listSuppliers(Model theModel){

        List<MstSupplier> suppliers = supplierService.getAll();
        theModel.addAttribute("suppliers", suppliers);
        return "list-suppliers";
    }

    @GetMapping("/supplierForm")
    public String supplierForm(Model theModel){
        MstSupplier theSupplier = new MstSupplier();
        theModel.addAttribute("theSupplier", theSupplier);
        return "supplier-form";
    }

    @PostMapping("/saveSupplier")
    public String saveSupplier(@ModelAttribute("theSupplier") MstSupplier theSupplier){
        // save supplier
        supplierService.insert(theSupplier);
        return "redirect:/supplier/list";
    }

    @GetMapping("/updateSupplier")
    public String updateSupplier(@RequestParam(value = "supplierId")int id, Model theModel){

        MstSupplier theSupplier = supplierService.get(id);

        theModel.addAttribute("theSupplier", theSupplier);

        return "supplier-form";
    }

    @GetMapping("/deleteSupplier")
    public String deleteSupplier(@RequestParam("supplierId")Integer id, Model theModel){


        MstSupplier theSupplier = supplierService.get(id);
        supplierService.delete(theSupplier);
        return "redirect:/supplier/list";
    }


}
