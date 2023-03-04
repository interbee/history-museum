package com.atguigu.ssm.controller;

import com.atguigu.ssm.pojo.User;
import com.atguigu.ssm.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @Desription 根据用户ID查找用户信息
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/user/page/1";
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    public String deleteUserById(@PathVariable Integer userId) {
        userService.deleteUserById(userId);
        return "redirect:/user/page/1";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String ckUname(String username) {
        int rel = userService.getUserByUname(username);
        if (rel == 0){
            return "forward:/adduser";
        }else {
            return "redirect:/user/page/1";
        }
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String addUser(User user, Model model) {
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/user/page/1";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userLogin(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.checkLogin(username, password);
        if (userService.getUserByUname(username) == 0) {
            request.setAttribute("msg1", "账号不存在");
        } else {
            if (user != null) {
                request.setAttribute("msg2", "登录成功");
                request.setAttribute("user", user);
                return "admin";
            } else {
                request.setAttribute("msg2", "密码错误");
            }
        }
        return "login";
//        if (user!=null) {
//            if(user.getUsername().equals("admin")==true){
//                return "admin";
//            }
//            return "index";
//            return "admin";
//        }
//        return "login";
    }


    @RequestMapping(value = "/user/page/{pageNum}", method = RequestMethod.GET)
    public String getUserPage(@PathVariable Integer pageNum, Model model) {
        PageInfo<User> pageInfo = userService.getUserPage(pageNum);
        //将分页数据共享到请求域中
        model.addAttribute("page", pageInfo);
        return "user_list";
    }

    @RequestMapping(value = "/ckUname", method = RequestMethod.GET)
    public void checkUserName(String username, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String message = "";
        boolean flag = false;

        int rel = userService.getUserByUname(username);
        if (rel == 1) {
            flag = true;
            message = " ";
        } else {
            message = "账号不存在";
        }

        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<response>");
        out.println("<passed>" + Boolean.toString(flag) + "</passed>");
        out.println("<message>" + message + "</message>");
        out.println("</response>");
    }
}
