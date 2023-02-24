package com.atguigu.ssm.mapper;

import com.atguigu.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper {
    User checkLogin(@Param("username") String username,@Param("password")String password);

    void addUser(User user);

    int getUserByUname(String username);

    List<User> getAllUser();

}
