package com.atguigu.ssm.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.ssm.pojo.Relic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author yehui
 * @date 2023/3/8&14:20
 */

public class ExcelListener extends AnalysisEventListener<Relic> {

    public static final Logger LOGGER = LoggerFactory.getLogger(ExcelListener.class);

    //暂时存储数据
    private List<Relic> list = new ArrayList<Relic>();

    //每一条数据解析都会调用
    @Override
    public void invoke(Relic data, AnalysisContext context) {
        list.add(data);
    }

    //所有数据解析完成后 会来调用
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println(list);
        LOGGER.info("Excel解析完毕");
    }

    public List<Relic> getDataList() {
        return list;
    }
}
