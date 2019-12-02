package com.ai.pos.controller;

import com.ai.pos.model.MstEmployee;
import com.ai.pos.model.MstOutlet;
import com.ai.pos.model.MstRole;
import com.ai.pos.model.MstUser;
import com.ai.pos.service.Employee_Service;
import com.ai.pos.service.Outlet_Service;
import com.ai.pos.service.Role_Service;
import com.ai.pos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Employee_Controller {

    @Autowired
    Employee_Service employee_service;

    @Autowired
    Outlet_Service outlet_service;

    @Autowired
    Role_Service role_service;

    @Autowired
    UserService userService;

    //get all data
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String listMstEmployee(@ModelAttribute MstRole mstRole, Model model) {

        //view list employee
        List<MstEmployee> list = employee_service.listMstEmployes();
        model.addAttribute("employees", list );

        //view list role
        List<MstRole> roleList = role_service.listMstRole();
        Map<Integer, String> role = new HashMap<>();
        for (MstRole curRole : roleList){
            role.put(curRole.getId(), curRole.getName());
        }

        //view list outlet
        List<MstOutlet> outletList = outlet_service.listMstOutlet();
        Map<Integer, String> outlet = new HashMap<>();
        for (MstOutlet curOutlet : outletList){
            outlet.put(curOutlet.getId(), curOutlet.getName());
        }

        model.addAttribute("roleList", role);
        model.addAttribute("outletList", outlet);
        model.addAttribute("employee",  new MstEmployee());

        model.addAttribute("content_page_url", "new.jsp");
        model.addAttribute("page_title", "Employee");
        return "home";
    }

    //employee
    @RequestMapping(value= "/add_employee", method = RequestMethod.POST)
    public String add(@ModelAttribute("add_employee") MstEmployee mstEmployee){
        mstEmployee.setActive(true);
        this.employee_service.addEmployee(mstEmployee);
//        this.userService.insert(mstUser);
        return "redirect:/employee";


    }
}
