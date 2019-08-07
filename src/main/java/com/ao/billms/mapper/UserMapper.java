package com.ao.billms.mapper;

import com.ao.billms.entities.User;


import java.util.List;


//@Mapper 或 @MapperScan("com.mengxuegu.springboot.mapper")
public interface UserMapper {

    User getUserByUsername(String username);

    List<User> getUsers(User user);

    User getUserById(Integer id);

    int addUser(User user);

    int deleteUserById(Integer id);

    int updateUser(User user);

}
