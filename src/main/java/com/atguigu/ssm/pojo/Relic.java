package com.atguigu.ssm.pojo;

import com.alibaba.excel.annotation.ExcelProperty;

public class Relic {
    @ExcelProperty("序号")
    private Integer id;
    @ExcelProperty("名称")
    private String relName;
    @ExcelProperty("图片")
    private String photo;
    @ExcelProperty("文物级别")
    private String level;
    @ExcelProperty("时期")
    private String time;
    @ExcelProperty("出土地点")
    private String location;
    @ExcelProperty("尺寸")
    private String size;
    @ExcelProperty("材质")
    private String material;
    @ExcelProperty("状态")
    private Integer status;

    public Relic() {
    }

    public Relic(Integer id, String relName, String photo, String time, String level, String location, String size, String material, Integer status) {
        this.id = id;
        this.relName = relName;
        this.photo = photo;
        this.level = level;
        this.time = time;
        this.location = location;
        this.size = size;
        this.material = material;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRelName() {
        return relName;
    }

    public void setRelName(String relName) {
        this.relName = relName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Relic{" +
                "id=" + id +
                ", relName='" + relName + '\'' +
                ", photo='" + photo + '\'' +
                ", level='" + level + '\'' +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", size='" + size + '\'' +
                ", material='" + material + '\'' +
                ", status=" + status +
                '}';
    }
}
