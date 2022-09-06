package com.atguigu.ssm.service;

import com.atguigu.ssm.pojo.User;

public interface UserService {
    User checkLogin(String username,String password);

    void addUser(User user);

    User ckUname(String username);
}
