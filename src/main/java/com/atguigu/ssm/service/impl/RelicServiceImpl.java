package com.atguigu.ssm.service.impl;

import com.atguigu.ssm.mapper.RelicMapper;
import com.atguigu.ssm.pojo.Relic;
import com.atguigu.ssm.service.RelicService;
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
public class RelicServiceImpl implements RelicService {

    @Autowired
    private RelicMapper relicMapper;

    @Override
    public PageInfo<Relic> getRelicPage(Integer pageNum) {
        PageHelper.startPage(pageNum,4);
        List<Relic> list=relicMapper.getAllRelic();
        PageInfo<Relic> page = new PageInfo<>(list,4);
        return page;
    }

    @Override
    public void addRelic(Relic relic) {
        relicMapper.addRelic(relic);
    }

    @Override
    public void deleteRelic(Integer id) {
        relicMapper.deleteRelic(id);
    }

    @Override
    public void updateRelic(Relic relic) {
        relicMapper.updateRelic(relic);
    }

    @Override
    public Relic getRelicById(Integer id) {
        return relicMapper.getRelicById(id);
    }

    @Override
    public void updatePhoto(Map map) {
        relicMapper.updatePhoto(map);
    }

    @Override
    public PageInfo<Relic> getRelicPageByUser(Integer pageNum) {
        PageHelper.startPage(pageNum,6);
        List<Relic> list=relicMapper.getAllRelic();
        PageInfo<Relic> page=new PageInfo<>(list,4);
        return page;
    }

    @Override
    public PageInfo<Relic> getRelicBySearch(Map map, Integer pageNum) {
        PageHelper.startPage(pageNum,6);
        List<Relic> list=relicMapper.getRelicBySearch(map);
        PageInfo<Relic> page=new PageInfo<>(list,4);
        return page;
    }

    /**
     * @Description 上传图片
     * @param photo
     * @param session
     * @return
     * @throws IOException
     */
    @Override
    public String upPhoto(MultipartFile photo, HttpSession session) throws IOException {
        String fileName=photo.getOriginalFilename();
        String suffixName=fileName.substring(fileName.lastIndexOf("."));
        String uuid= UUID.randomUUID().toString().replace("-","");
        fileName=uuid+suffixName;
        ServletContext servletContext=session.getServletContext();
        String photoPath=servletContext.getRealPath("relics");
        File file=new File(photoPath);
        if (!file.exists()){
            file.mkdir();
        }
        String filePath=photoPath+File.separator+fileName;
        photo.transferTo(new File(filePath));
        return fileName;
    }
}
