package com.ai.pos.controller;

import com.ai.pos.model.MstSupplier;
import com.ai.pos.model.TPo;
import com.ai.pos.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/po")
public class POController {

    @Autowired
    private Service<TPo> poService;

    @Autowired
    private Service<MstSupplier> supplierService;

    @GetMapping("/list")
    public String listPo(Model theModel){
        List<TPo> poList = poService.getAll();
        List<MstSupplier> suppliers = supplierService.getAll();
//        poList.stream().forEach(po -> po.toString() );
        theModel.addAttribute("poForm", new TPo());
        theModel.addAttribute("orderList", poList);
        theModel.addAttribute("supplierList", suppliers);

        theModel.addAttribute("content_page_url", "list-po.jsp");
        theModel.addAttribute("page_title", "Purchase Order");
        return "home";
    }

    @PostMapping("/update")
    public String updatePO(@ModelAttribute("poForm") MstSupplier thePOModel, Model theModel){
        supplierService.insert(thePOModel);
        return "redirect:/po/list";
    }

}
