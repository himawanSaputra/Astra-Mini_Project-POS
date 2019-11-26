package com.ai.pos.controller;

import com.ai.pos.model.EmployeeOutlet;
import com.ai.pos.model.MstOutlet;
import com.ai.pos.model.MstUser;
import com.ai.pos.service.EmployeeOutlet_Service;
import com.ai.pos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Resource
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    EmployeeOutlet_Service employeeOutlet_service;

    @RequestMapping(value = "/")
    public String index(HttpSession session, Model m){
        if(session.getAttribute("message") != null) {
            m.addAttribute("message", session.getAttribute("message"));
            session.removeAttribute("message");
        }
        if(session.getAttribute("error") != null) {
            m.addAttribute("error", session.getAttribute("error"));
            session.removeAttribute("error");
        }
        return "index";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session,
            Model m){
        MstUser user = this.userService.getByUsernamePassword(username, password);
        if(user != null){
            session.setAttribute("user", user);
            return "redirect:/login_outlet";
        }
        //IF NO USER FOUND
        session.setAttribute("error", "Wrong Username or Password");
        return "redirect:/";
    }

    @RequestMapping(value="/forgot_password")
    public String forgotPassword(HttpSession session,
                                 Model m){
        if(session.getAttribute("error") != null){
            m.addAttribute("error", session.getAttribute("error"));
            session.removeAttribute("error");
        }
        return "forgot_password";
    }

    @RequestMapping(value="/reset_password", method = RequestMethod.POST)
    public String resetPassword(HttpSession session,
                                @RequestParam("email") String email,
                                @RequestParam("password") String password,
                                @RequestParam("repassword") String repassword,
                                Model m){
        if(!password.equals(repassword)){
            session.setAttribute("error", "Password Do Not Match");
            return "redirect:/forgot_password";
        }

        boolean status = this.userService.resetPassword(email, password);
        if(!status){
            session.setAttribute("error", "No User Found For Email " + email);
            return "redirect:/forgot_password";
        }

        session.setAttribute("message", "Reset Password Success");
        return "redirect:/";
    }

    @RequestMapping(value = "/login_outlet", method = RequestMethod.GET)
    public String loginOutlet(HttpSession session,
                       Model m){
        //IF THE USER IS AN ADMIN
//        if(session.getAttribute("user") != null){
//            MstUser user = (MstUser) session.getAttribute("user");
//            if(user.get)
//        }
        List<EmployeeOutlet> employeeOutlets = this.employeeOutlet_service.listEmployeeOutlet();
        //TRANSLATE TO HASHMAP
        Map<Integer, String> outletMap = new HashMap<>();
        for(EmployeeOutlet curEmpOut : employeeOutlets){
            outletMap.put(curEmpOut.getMstOutlet().getId(),
                    curEmpOut.getMstOutlet().getName());
        }
        m.addAttribute("outlet", new MstOutlet());
        m.addAttribute("outlet_map", outletMap);
        return "choose_outlet";
    }

    @RequestMapping(value = "/login_choose_outlet", method = RequestMethod.POST)
    public String chooseOutlet(HttpSession session,
                               @ModelAttribute("outlet") MstOutlet mstOutlet,
                               Model m){
        //SAVE IN SESSION THE CHOSEN OUTLET
        session.setAttribute("outlet", mstOutlet);
        System.out.println(mstOutlet.getId());
        return "home";
    }

//    @RequestMapping(value = "/home", method = RequestMethod.GET)
//    public String home(HttpSession session,
//                       Model m){
//        MstUser user = (MstUser) session.getAttribute("user");
//        m.addAttribute("message", user.getUsername());
//        return "home";
//    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session,
                         Model m){
        session.invalidate();
        m.addAttribute("message", "Logout Succesful");
        return "index";
    }

}
