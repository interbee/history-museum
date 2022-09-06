package com.atguigu.ssm.service.impl;

import com.atguigu.ssm.mapper.UserMapper;
import com.atguigu.ssm.pojo.User;
import com.atguigu.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User checkLogin(String username,String password) {
        User user = userMapper.checkLogin(username, password);
        if ((user!=null&&user.getUsername().equals(username)&&user.getPassword().equals(password))) {
            return user;
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User ckUname(String username) {
        return userMapper.getUser(username);
    }
}
