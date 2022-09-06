package com.atguigu.ssm.service.impl;

import com.atguigu.ssm.mapper.ShowMapper;
import com.atguigu.ssm.pojo.Show;
import com.atguigu.ssm.service.ShowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowMapper showMapper;

    @Override
    public PageInfo<Show> getAllShow(Integer pageNum) {
        PageHelper.startPage(pageNum,4);
        List<Show> list=showMapper.getAllShow();
        PageInfo<Show> page=new PageInfo<>(list,4);
        return page;
    }

    @Override
    public void updatePhoto(Map map) {
        showMapper.upPhoto(map);
    }

    @Override
    public void addShow(Map map) {
        showMapper.addShow(map);
    }

    @Override
    public Show getShowById(Integer id) {
        return showMapper.getShowById(id);
    }

    @Override
    public void updateShow(Show show) {
        showMapper.updateShow(show);
    }

    @Override
    public void deleteShow(Integer id) {
        showMapper.deleteShow(id);
    }

    @Override
    public PageInfo<Show> getShowByUser(Integer pageNum) {
        PageHelper.startPage(pageNum,4);
        List<Show> list=showMapper.getAllShow();
        PageInfo page=new PageInfo<>(list,4);
        return page;
    }

    @Override
    public String upPhoto(MultipartFile photo, HttpSession session) throws IOException {
        String fileName=photo.getOriginalFilename();
        String suffixName=fileName.substring(fileName.lastIndexOf("."));
        String uuid= UUID.randomUUID().toString().replace("-","");
        fileName=uuid+suffixName;
        ServletContext servletContext=session.getServletContext();
        String photoPath=servletContext.getRealPath("shows");
        File file=new File(photoPath);
        if (!file.exists()){
            file.mkdir();
        }
        String filePath=photoPath+File.separator+fileName;
        photo.transferTo(new File(filePath));
        return fileName;
    }
}
