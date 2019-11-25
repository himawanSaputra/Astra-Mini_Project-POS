package com.ai.pos.controller;

import com.ai.pos.model.MstUser;
import com.ai.pos.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.security.pkcs11.wrapper.Constants;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Resource
@Controller
public class LoginController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping(value="/")
    public String login_page(){
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session,
            Model m){
        MstUser user = this.userServiceImpl.getByUsernamePassword(username, password);
        if(user != null){
            session.setAttribute("user", user);
            return "redirect:/home";
        }
        //IF NO USER FOUND
        m.addAttribute("error", "Wrong Username or Password");
        return "login";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(HttpSession session,
                       Model m){
        MstUser user = (MstUser) session.getAttribute("user");
        m.addAttribute("message", user.getUsername());
        return "home";
    }
}
