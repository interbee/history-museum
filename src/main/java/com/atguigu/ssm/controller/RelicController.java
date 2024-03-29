package com.atguigu.ssm.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.ssm.listener.ExcelListener;
import com.atguigu.ssm.pojo.Relic;
import com.atguigu.ssm.service.RelicService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Controller
public class RelicController {

    @Autowired
    private RelicService relicService;

    @RequestMapping(value = "/relic/deleteAllRelic", method = RequestMethod.DELETE)
    public String deleteAllRelic() {
        relicService.deleteAllRelic();
        return "redirect:/relic/page/1";
    }

    @RequestMapping(value = "/relic/import", method = RequestMethod.POST)
    public String importRelicInfo(MultipartFile file) throws IOException {
        ExcelListener excelListener = new ExcelListener();
        EasyExcel.read(file.getInputStream(), Relic.class, excelListener).sheet().doRead();
        List<Relic> list = excelListener.getDataList();
        relicService.addRelicByList(list);
        return "redirect:/relic/page/1";
    }

    @RequestMapping(value = "/relic/export", method = RequestMethod.GET)
    public void exportRelicInfo() {
        relicService.exportExcel();
    }

    @RequestMapping(value = "/search/{pageNum}", method = RequestMethod.GET)
    public String getRelicBySearch(String relName,String time,String material,Model model,@PathVariable Integer pageNum){
        Map map=new HashMap<>();
        map.put("relName",relName);
        map.put("time",time);
        map.put("material",material);
        PageInfo page=relicService.getRelicBySearch(map,pageNum);
        model.addAttribute("page",page);
        return "relic_lib";
    }

    @RequestMapping(value="/to/relic/{pageNum}",method = RequestMethod.GET)
    public String getRelicPageByUser(@PathVariable Integer pageNum,Model model){
        PageInfo<Relic> page=relicService.getRelicPageByUser(pageNum);
        model.addAttribute("page",page);
        return "relic_lib";
    }

    @RequestMapping(value = "/photo/{id}",method = RequestMethod.POST)
    public String updatePhoto(@PathVariable Integer id,MultipartFile photo,HttpSession session) throws IOException {
        String fileName=relicService.upPhoto(photo,session);
        Map map=new HashMap<>();
        map.put("id",id);
        map.put("photo",fileName);
        relicService.updatePhoto(map);
        return "redirect:/relic/page/1";
    }

    @RequestMapping(value = "/relic",method = RequestMethod.PUT)
    public String updateRelic(Relic relic){
        relicService.updateRelic(relic);
        return "redirect:/relic/page/1";
    }

    /**
     * @Desription 根据ID查询藏品信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/relic/{id}",method = RequestMethod.GET)
    public Relic getRelicById(@PathVariable Integer id){
        return relicService.getRelicById(id);
    }

    @RequestMapping(value = "/relic/{id}",method = RequestMethod.DELETE)
    public String deleteRelic(@PathVariable Integer id){
        relicService.deleteRelic(id);
        return "redirect:/relic/page/1";
    }

    @RequestMapping(value = "/relic",method = RequestMethod.POST)
    public String addRelic(String relName,String time,String level,String location,String size,String material,Integer status,
                           MultipartFile photo, HttpSession session) throws IOException {

        String fileName=relicService.upPhoto(photo,session);
        Relic relic=new Relic(null,relName,fileName,time,level,location,size,material,status);
        relicService.addRelic(relic);
        return "redirect:/relic/page/1";
    }

    @RequestMapping(value = "/relic/page/{pageNum}",method = RequestMethod.GET)
    public String getRelicPage(@PathVariable Integer pageNum,Model model){
        PageInfo<Relic> page=relicService.getRelicPage(pageNum);
        model.addAttribute("page",page);
        return "relic_list";
    }
}
