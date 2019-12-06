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
import javax.servlet.http.HttpSession;
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
    public String listMstEmployee(@ModelAttribute MstRole mstRole,
                                  Model model,
                                  HttpSession session) {
        if(session.getAttribute("error") != null){
            model.addAttribute("error", session.getAttribute("error"));
            session.removeAttribute("error");
        }
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

        model.addAttribute("content_page_url", "employee.jsp");
        model.addAttribute("page_title", "Employee");
        return "home";
    }

    @RequestMapping(value= "/add_employee", method = RequestMethod.POST)
    public String add(
            @ModelAttribute("employee") MstEmployee mstEmployee,
            @RequestParam(required = false, value = "selected_outlet") int[] outletIds,
            HttpSession session){
        //CHECK IF EMAIL IS ALREADY EXIST
        MstEmployee tempMstEmployee = this.employee_service.getEmloyeeByEmail(mstEmployee.getEmail());
        if(tempMstEmployee != null){
            session.setAttribute("error", "Email is already registered!");
            return "redirect:/employee";
        }

        /**
         * SAVE THE EMPLOYEE FIRST, THEN THE ID OF THIS EMPLOYEE ARE GENERATED
         */
        mstEmployee.setActive(true);
        this.employee_service.addEmployee(mstEmployee);

        //IF EMPLOYEE IS CREATED ALONG THE USER
        if(mstEmployee.getHaveAccount() == true) {
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

    @RequestMapping(value = "/edit_employee/{id}", method = RequestMethod.GET)
    public String editPage(
            @PathVariable("id") int id,
            HttpSession session,
            Model m){
        if(session.getAttribute("error") != null){
            m.addAttribute("error", session.getAttribute("error"));
            session.removeAttribute("error");
        }
        MstEmployee employee = this.employee_service.getMstEmployeeById(id);
        m.addAttribute("employee", employee);

        List<EmployeeOutlet> employeeOutletList = this.employeeOutlet_service.getEmployeeOutletByEmployeeId(id);
        m.addAttribute("employee_outlet_list", employeeOutletList);

        List<MstRole> mstRoleList = this.role_service.listMstRole();
        Map<Integer, String> role = new HashMap<>();
        for (MstRole curRole : mstRoleList){
            role.put(curRole.getId(), curRole.getName());
        }
        m.addAttribute("roles_map", role);

        List<MstOutlet> mstOutletList = this.outlet_service.listMstOutlet();
        m.addAttribute("outlets_list", mstOutletList);

        m.addAttribute("content_page_url", "employee_edit.jsp");
        m.addAttribute("page_title", "Employee");
        return "home";
    }

    @RequestMapping(params = "cancel", value = "/edit_employee", method = RequestMethod.POST)
    public String cancelEdit(){
        return "redirect:/employee";
    }

    @RequestMapping(params = "save", value = "/edit_employee", method = RequestMethod.POST)
    public String edit(
            @ModelAttribute("employee") MstEmployee mstEmployee,
            @RequestParam(required = false, value = "selected_outlet") int[] outletIds,
            HttpSession session){
        MstEmployee tempMstEmployee = this.employee_service.getEmloyeeByEmail(mstEmployee.getEmail());
        if(tempMstEmployee != null && tempMstEmployee.getId() != mstEmployee.getId()){
            session.setAttribute("error", "Email is already registered!");
            return "redirect:/edit_employee/" + mstEmployee.getId();
        }

        //UPDATE THE EMPLOYEE
        this.employee_service.updateEmployee(mstEmployee);

        //CHECK IF THE USER FOR THIS EPLOYEE HAS ACCOUNT
        if(mstEmployee.getHaveAccount()){
            //CHECK IF THE USER IS CREATED OR UPDATED
            if(mstEmployee.getMstUser().getId() == 0){
                mstEmployee.getMstUser().setActive(true);
                mstEmployee.getMstUser().setMstEmployee(mstEmployee);
                this.userService.insert(mstEmployee.getMstUser());
            }
            else {
                //UPDATE THE USER
                mstEmployee.getMstUser().setActive(true);
                mstEmployee.getMstUser().setMstEmployee(mstEmployee);
                this.userService.update(mstEmployee.getMstUser());
            }
        }
        else{
            //ACCOUNT EITHER ERASED OR HAVEN'T CREATED FROM THE START
            if(mstEmployee.getMstUser().getId() != 0){
                mstEmployee.getMstUser().setActive(true);
                mstEmployee.getMstUser().setMstEmployee(mstEmployee)    ;
                this.userService.delete(mstEmployee.getMstUser());
                mstEmployee.setMstUser(new MstUser());
            }
        }

        //UPDATE THE EMPLOYEE OUTLET
        //TAKE ALL THE CURRENT EMPLOYEE OUTLET
        List<EmployeeOutlet> employeeOutletList =
                this.employeeOutlet_service.getEmployeeOutletByEmployeeId(mstEmployee.getId());
        for(EmployeeOutlet curEmpOut : employeeOutletList){
            this.employeeOutlet_service.deleteEmployee(curEmpOut);
        }

        if(outletIds != null) {
            for (int i = 0; i < outletIds.length; i++) {
                MstOutlet curAssignedOutlet = this.outlet_service.getMstOutlet(outletIds[i]);
                EmployeeOutlet newEmployeeOutlet = new EmployeeOutlet();
                newEmployeeOutlet.setMstEmployee(mstEmployee);
                newEmployeeOutlet.setMstOutlet(curAssignedOutlet);
                this.employeeOutlet_service.addEmployeeOutlet(newEmployeeOutlet);
            }
        }

        return "redirect:/employee";
    }

    @RequestMapping(value = "/remove_employee/{id}", method = RequestMethod.GET)
    public String remove(
            @PathVariable("id") int id){
        MstEmployee employee = this.employee_service.getMstEmployeeById(id);
        employee.setActive(false);
        this.employee_service.updateEmployee(employee);
        return "redirect:/employee";
    }
}
