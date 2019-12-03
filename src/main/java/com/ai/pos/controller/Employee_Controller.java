package com.ai.pos.controller;

import com.ai.pos.model.*;
import com.ai.pos.service.*;
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

    @Autowired
    EmployeeOutlet_Service employeeOutlet_service;

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
        model.addAttribute("all_outlets", outletList);
        model.addAttribute("employee",  new MstEmployee());

        model.addAttribute("content_page_url", "new.jsp");
        model.addAttribute("page_title", "Employee");
        return "home";
    }

    @RequestMapping(value= "/add_employee", method = RequestMethod.POST)
    public String add(
            @ModelAttribute("employee") MstEmployee mstEmployee,
            @RequestParam(required = false, value = "selected_outlet") int[] outletIds){
        /**
         * SAVE THE EMPLOYEE FIRST, THEN THE ID OF THIS EMPLOYEE ARE GENERATED
         */
        mstEmployee.setActive(true);
        this.employee_service.addEmployee(mstEmployee);

        //IF EMPLOYEE IS CREATED ALONG THE USER
        if(mstEmployee.getMstUser() != null) {
            /**
             * SET THE NECESSARY FIELDS OF USER (INCLUDING THE EMPLOYEE ITSELF) THEN SAVE THE USER
             */
            mstEmployee.getMstUser().setActive(true);
            mstEmployee.getMstUser().setMstEmployee(mstEmployee);
            this.userService.insert(mstEmployee.getMstUser());
        }

        //IF THE EMPLOYEE IS ASSIGNED TO OUTLET(s)
        if(outletIds != null && outletIds.length != 0){
            /**
             * SAVE THE OUTLET EMPLOYEE
             */
            for(int i = 0; i < outletIds.length; i++){
                MstOutlet curAssignedOutlet = this.outlet_service.getMstOutlet(outletIds[i]);
                EmployeeOutlet newEmployeeOutlet = new EmployeeOutlet();
                newEmployeeOutlet.setMstEmployee(mstEmployee);
                newEmployeeOutlet.setMstOutlet(curAssignedOutlet);
                this.employeeOutlet_service.addEmployeeOutlet(newEmployeeOutlet);
            }
        }
        return "redirect:/employee";
    }

    @RequestMapping(value= "/remove_employee/{id}", method = RequestMethod.POST)
    public String remove(
            @PathVariable("id") int id){
        MstEmployee employee = this.employee_service.getMstEmployeeById(id);
        this.employee_service.deleteEmployee(employee);
        return "redirect:/employee";
    }


}
