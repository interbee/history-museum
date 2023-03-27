package com.atguigu.ssm.service;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.ssm.pojo.Relic;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface RelicService {


    PageInfo<Relic> getRelicPage(Integer pageNum);

    void addRelic(Relic relic);

    void deleteRelic(Integer id);

    void updateRelic(Relic relic);

    Relic getRelicById(Integer id);

    void updatePhoto(Map map);

    PageInfo<Relic> getRelicPageByUser(Integer pageNum);

    PageInfo<Relic> getRelicBySearch(Map map,Integer pageNum);

    String upPhoto(MultipartFile photo, HttpSession session) throws IOException;

    void exportExcel();

    void addRelicByList(List<Relic> list);

    void deleteAllRelic();
}
