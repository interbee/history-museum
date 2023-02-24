package com.atguigu.ssm.service;

import com.atguigu.ssm.pojo.User;
import com.github.pagehelper.PageInfo;

public interface UserService {
    PageInfo<User> getUserPage(Integer pageNum);

    User checkLogin(String username, String password);

    void addUser(User user);

    int getUserByUname(String username);
}
