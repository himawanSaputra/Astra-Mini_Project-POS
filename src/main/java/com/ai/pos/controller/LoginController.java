package com.ai.pos.controller;

import com.ai.pos.model.MstUser;
import com.ai.pos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Resource
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/login_page")
    public String login_page(){
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session,
            Model m){
        MstUser user = this.userService.getByUsernamePassword(username, password);
        if(user != null){
            session.setAttribute("username", username);
            return "redirect:/home";
        }
        return "login";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(HttpSession session,
                       Model m){
        m.addAttribute("message", session.getAttribute("username"));
        return "home";
    }
}
