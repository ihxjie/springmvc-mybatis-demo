package com.ex.dao;

import com.ex.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByUserId(Integer userId);

    User selectByUserId(Integer userId);

    List<User> selectUserByEmail(String keyword);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int insertUser(User user);
}