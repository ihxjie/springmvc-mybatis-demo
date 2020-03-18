package com.ex.service;

import com.ex.model.User;

import java.util.List;

public interface UserService {
    int deleteByUserId(Integer userId);

    User selectByUserId(Integer userId);

    List<User> selectUserByEmail(String keyword);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int insertUser(User user);


}
