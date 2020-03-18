package com.ex.service.impl;

import com.ex.dao.UserMapper;
import com.ex.model.User;
import com.ex.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;


    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public User selectByUserId(Integer userId) {
        return null;
    }
    @Override
    public int deleteByUserId(Integer userId) {
        return userMapper.deleteByUserId(userId);
    }

    @Override
    public List<User> selectUserByEmail(String keyword) {
        return userMapper.selectUserByEmail(keyword);
    }


    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }
}
