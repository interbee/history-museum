package com.atguigu.ssm.service;

import com.atguigu.ssm.pojo.Visitor;
import com.github.pagehelper.PageInfo;



public interface VisitorService {
    /**
     * 查询所有的游客信息
     * @return
     */
    PageInfo<Visitor> getVisitorPage(Integer pageNum);

    void addVisitor(Visitor visitor);

    Visitor getVisitorById(Integer id);

    void updateVisitor(Visitor visitor);

    void deleteVisitor(Integer id);
}
