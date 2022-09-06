package com.atguigu.ssm.controller;

import com.atguigu.ssm.pojo.Visitor;
import com.atguigu.ssm.service.VisitorService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 查询所有游客信息-->/visitor/page/1-->get
 * 根据id查询游客信息-->/visitor/1-->get
 * 跳转到添加页面-->/to/add-->get
 * 添加游客信息-->/visitor-->post
 * 修改游客信息-->/visitor-->put
 * 删除游客信息-->/visitor/1-->delete
 */
@Controller
public class VisitorController {
    @Autowired
    private VisitorService visitorService;

    @RequestMapping(value = "/visitor/{id}",method = RequestMethod.DELETE)
    public String deleteVisitor(@PathVariable Integer id){
        //删除员工信息
        visitorService.deleteVisitor(id);
        //重定向到列表功能：/visitor/page/1
        return "redirect:/visitor/page/1";

    }


    @RequestMapping(value = "/visitor",method = RequestMethod.PUT)
    public String updateVisitor(Visitor visitor){
        //修改游客信息
        visitorService.updateVisitor(visitor);
        //重定向到列表功能：/visitor/page/1
        return "redirect:/visitor/page/1";
    }

    @RequestMapping(value = "/visitor/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable Integer id,Model model){
        //根据id查询游客信息
        Visitor visitor=visitorService.getVisitorById(id);
        //将员工信息共享到请求域中
        model.addAttribute("visitor",visitor);
        //跳转到visitor_update.html
        return "visitor_update";
    }

    @RequestMapping(value = "/visitor",method = RequestMethod.POST)
    public String addVisitor(Visitor visitor){
        //保存游客信息
        visitorService.addVisitor(visitor);
        //重定向到列表功能:/visitor/page/1
        return "redirect:/visitor/page/1";
    }

    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public String addVisitorByOrder(Visitor visitor){
        //保存游客信息
        visitorService.addVisitor(visitor);
        //重定向到首页
        return "success";
    }

    @RequestMapping(value = "/visitor/page/{pageNum}",method = RequestMethod.GET)
    public String getVisitorPage(@PathVariable Integer pageNum,Model model){
        //获取游客的分页信息
        PageInfo<Visitor> page=visitorService.getVisitorPage(pageNum);
        //将分页数据共享到请求域中
        model.addAttribute("page",page);
        return "visitor_list";
    }

}
