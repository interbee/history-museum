package com.atguigu.ssm.pojo;

public class Show {
    private Integer id;
    private String showName;
    private String photo;
    private String time;
    private String location;

    public Show() {
    }

    public Show(Integer id, String showName, String photo, String time, String location) {
        this.id = id;
        this.showName = showName;
        this.photo=photo;
        this.time = time;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", showName='" + showName + '\'' +
                ", photo='" + photo + '\'' +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
