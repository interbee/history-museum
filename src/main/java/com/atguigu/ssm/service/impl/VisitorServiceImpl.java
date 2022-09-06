package com.atguigu.ssm.service.impl;

import com.atguigu.ssm.mapper.VisitorMapper;
import com.atguigu.ssm.pojo.Visitor;
import com.atguigu.ssm.service.VisitorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisitorMapper visitorMapper;

    @Override
    public PageInfo<Visitor> getVisitorPage(Integer pageNum) {
        //开启分页功能
        PageHelper.startPage(pageNum,4);
        //查询所有的游客信息
        List<Visitor> list=visitorMapper.getAllVisitor();
        //获取分页相关数据
        PageInfo<Visitor> page=new PageInfo<>(list,4);
        return page;
    }

    @Override
    public void addVisitor(Visitor visitor) {
        visitorMapper.addVisitor(visitor);
    }

    @Override
    public Visitor getVisitorById(Integer id) {
        return visitorMapper.getVisitorById(id);
    }

    @Override
    public void updateVisitor(Visitor visitor) {
        visitorMapper.updateVisitor(visitor);
    }

    @Override
    public void deleteVisitor(Integer id) {
        visitorMapper.deleteVisitor(id);
    }
}
