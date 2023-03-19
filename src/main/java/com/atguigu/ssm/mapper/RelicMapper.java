package com.atguigu.ssm.mapper;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.ssm.pojo.Relic;

import java.util.List;
import java.util.Map;

public interface RelicMapper {
    List<Relic> getAllRelic();

    void addRelic(Relic relic);

    void deleteRelic(Integer id);

    void updateRelic(Relic relic);

    Relic getRelicById(Integer id);

    void updatePhoto(Map map);

    List<Relic> getRelicBySearch(Map map);

    void addRelicByList(List<Relic> list);
}
