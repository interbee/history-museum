package com.atguigu.ssm.mapper;

import com.atguigu.ssm.pojo.Visitor;

import java.util.List;

public interface VisitorMapper {
    /**
     * 查询所有的游客信息
     * @return
     */
    List<Visitor> getAllVisitor();

    void addVisitor(Visitor visitor);

    Visitor getVisitorById(Integer id);

    void updateVisitor(Visitor visitor);

    void deleteVisitor(Integer id);
}
