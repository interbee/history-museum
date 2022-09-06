package com.atguigu.ssm.controller;

import com.atguigu.ssm.pojo.User;
import com.atguigu.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String ckUname(String username){
        User user = userService.ckUname(username);
        if (user!=null){
            return "register";
        }
        return "forward:/adduser";
    }

    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    public String addUser(User user,Model model){
        userService.addUser(user);
        model.addAttribute("user",user);
        return "index";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String checkLogin(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.checkLogin(username,password);
        request.setAttribute("user",user);
        if (user!=null) {
            if(user.getUsername().equals("admin")==true){
                return "admin";
            }
            return "index";
        }
        return "login";
    }
}
