package com.atguigu.ssm.service;

import com.atguigu.ssm.pojo.Show;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public interface ShowService {

    PageInfo<Show> getAllShow(Integer pageNum);

    void updatePhoto(Map map);

    void addShow(Map map);

    Show getShowById(Integer id);

    void updateShow(Show show);

    void deleteShow(Integer id);

    PageInfo<Show> getShowByUser(Integer pageNum);

    String upPhoto(MultipartFile photo, HttpSession session) throws IOException;
}
