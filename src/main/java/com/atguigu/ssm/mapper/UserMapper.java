package com.atguigu.ssm.mapper;

import com.atguigu.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    User checkLogin(@Param("username") String username,@Param("password")String password);

    void addUser(User user);

    User getUser(String username);
}
