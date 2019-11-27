package com.ai.pos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/po")
public class POController {

    @GetMapping("/list")
    public String listPo(Model theModel){
        return "list-po";
    }

}
