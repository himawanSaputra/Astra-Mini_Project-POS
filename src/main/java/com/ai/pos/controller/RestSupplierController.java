package com.ai.pos.controller;

import com.ai.pos.model.MstSupplier;
import com.ai.pos.model.test.User;
import com.ai.pos.service.Service;
import com.ai.pos.service.SupplierService;
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

    @GetMapping("/rest/supplier/get/{id}")
    public MstSupplier getSupplierById(@PathVariable("id") int id, Model theModel) {
        MstSupplier theSupplier;
        if (id > 0) {
            theSupplier = supplierService.get(id);
            theModel.addAttribute("supplierForm", theSupplier);
        } else {

            theSupplier = new MstSupplier();
        }
        return theSupplier;
    }

    public List<MstSupplier> getSuppliers() {
        return supplierService.getAll();
    }
}
