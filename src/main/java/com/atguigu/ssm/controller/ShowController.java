package com.atguigu.ssm.controller;

import com.atguigu.ssm.pojo.Show;
import com.atguigu.ssm.service.ShowService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ShowController {

    @Autowired
    private ShowService showService;

    @RequestMapping(value = "/to/show/{pageNum}")
    public String getShowByUser(@PathVariable Integer pageNum,Model model){
        PageInfo<Show> page=showService.getShowByUser(pageNum);
        model.addAttribute("page",page);
        return "show_lib";
    }

    @RequestMapping(value = "/show/{id}",method = RequestMethod.DELETE)
    public String deleteShow(@PathVariable Integer id){
        showService.deleteShow(id);
        return "redirect:/show/page/1";
    }

    @RequestMapping(value = "/show",method = RequestMethod.PUT)
    public String updateShow(Show show){
        showService.updateShow(show);
        return "redirect:/show/page/1";
    }

    @RequestMapping(value = "/show/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable Integer id, Model model){
        Show show=showService.getShowById(id);
        model.addAttribute("show",show);
        return "show_update";
    }

    @RequestMapping(value = "/show",method = RequestMethod.POST)
    public String addShow(String showName,String time,String location,MultipartFile photo,HttpSession session) throws IOException {
        String fileName = showService.upPhoto(photo, session);
        Map map=new HashMap<>();
        map.put("showName",showName);
        map.put("photo",fileName);
        map.put("time",time);
        map.put("location",location);
        showService.addShow(map);
        return "redirect:/show/page/1";
    }

    @RequestMapping(value = "/showphoto/{id}")
    public String upPhoto(@PathVariable Integer id, MultipartFile photo, HttpSession session) throws IOException {
        String fileName = showService.upPhoto(photo, session);
        Map map=new HashMap<>();
        map.put("id",id);
        map.put("photo",fileName);
        showService.updatePhoto(map);
        return "redirect:/show/page/1";
    }

    @RequestMapping(value = "/show/page/{pageNum}",method = RequestMethod.GET)
    public String getAllShow(@PathVariable Integer pageNum, Model model){
        PageInfo<Show> page=showService.getAllShow(pageNum);
        model.addAttribute("page",page);
        return "show_list";
    }


}
