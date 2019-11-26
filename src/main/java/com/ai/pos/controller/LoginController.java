package com.ai.pos.controller;

import com.ai.pos.model.MstUser;
import com.ai.pos.service.UserService;
import com.ai.pos.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Resource
@Controller
public class LoginController {

    @Autowired
    UserService userService;

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
            return "redirect:/home";
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

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(HttpSession session,
                       Model m){
        MstUser user = (MstUser) session.getAttribute("user");
        m.addAttribute("message", user.getUsername());
        return "home";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session,
                         Model m){
        session.invalidate();
        m.addAttribute("message", "Logout Succesful");
        return "index";
    }

}
