package com.ai.pos.controller;

import com.ai.pos.model.TPo;
import com.ai.pos.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestPOController {

    @Autowired
    private Service<TPo> poService;

    @GetMapping("/rest/po/{id}")
    public TPo getPOFromId(@PathVariable("id") int id, Model theModel){
        theModel.addAttribute("poForm", poService.get(id));
        return poService.get(id);
    }
}
