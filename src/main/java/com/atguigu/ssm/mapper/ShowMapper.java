package com.atguigu.ssm.mapper;

import com.atguigu.ssm.pojo.Show;

import java.util.List;
import java.util.Map;

public interface ShowMapper {

    List<Show> getAllShow();

    void upPhoto(Map map);

    void addShow(Map map);

    Show getShowById(Integer id);

    void updateShow(Show show);

    void deleteShow(Integer id);

}
