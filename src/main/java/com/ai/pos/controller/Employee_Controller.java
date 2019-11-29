package com.ai.pos.controller;

import com.ai.pos.model.MstEmployee;
import com.ai.pos.service.Employee_Service;
import com.ai.pos.service.Outlet_Service;
import com.ai.pos.service.Role_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class Employee_Controller {

    @Autowired
    Employee_Service employee_service;

    @Autowired
    Outlet_Service outlet_service;

    @Autowired
    Role_Service role_service;

    //get all data
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView listMstEmployee(ModelMap model) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("listEmployee", employee_service.listMstEmployes());
        mv.setViewName("new");
        return mv;
    }

    //add
//    @RequestMapping(value = "/add_employee", method = RequestMethod.POST)
//    public String addEmployee(@ModelAttribute("employee")MstEmployee mstEmployee){
//       employee_service.addEmployee(mstEmployee);
//       return "redirect:/employee";
//    }
//
//    //update
//    @RequestMapping(value = "/edit_employee/{id}")
//    public ModelAndView updateEmployee(@PathVariable int id){
//        MstEmployee mstEmployee = employee_service.getMstEmployeeById(id);
//        return new ModelAndView("","employee",mstEmployee);
//    }

    //delete
//    @RequestMapping(value="/deactivate/{id}", method = RequestMethod.GET)
////    public String deactivateCategory(@PathVariable int id){
////        MstEmployee mstEmployee = Employee_Service.get;
////        mstOutlet.setActive(false);
////        mstOutletService.update(mstOutlet);
////        return "redirect:/outlet";

}
