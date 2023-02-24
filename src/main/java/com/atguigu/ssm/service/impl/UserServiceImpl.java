package com.atguigu.ssm.service.impl;

import com.atguigu.ssm.mapper.UserMapper;
import com.atguigu.ssm.pojo.User;
import com.atguigu.ssm.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> getUserPage(Integer pageNum) {
        //开启分页功能
        PageHelper.startPage(pageNum, 4);
        List<User> list = userMapper.getAllUser();
        PageInfo<User> pageInfo = new PageInfo<>(list, 4);
        return pageInfo;
    }

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
    public int getUserByUname(String username) {
        return userMapper.getUserByUname(username);
    }
}
