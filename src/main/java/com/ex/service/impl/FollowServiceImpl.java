package com.ex.service.impl;

import com.ex.dao.FollowMapper;
import com.ex.model.Follow;
import com.ex.model.FollowList;
import com.ex.service.FollowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {

    @Resource
    FollowMapper followMapper;

    @Override
    public int deleteByPrimaryKey(Integer followId) {
        return followMapper.deleteByPrimaryKey(followId);
    }

    @Override
    public int insert(Follow record) {
        return followMapper.insert(record);
    }

    @Override
    public int insertSelective(Follow record) {
        return 0;
    }

    @Override
    public Follow selectByPrimaryKey(Integer followId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Follow record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Follow record) {
        return 0;
    }

    @Override
    public List<FollowList> selectfollowListByUserId(Integer uid) {
        return followMapper.selectfollowListByUserId(uid);
    }
}
