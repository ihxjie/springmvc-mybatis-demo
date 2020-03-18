package com.ex.service;

import com.ex.model.Follow;
import com.ex.model.FollowList;

import java.util.List;

public interface FollowService {

    int deleteByPrimaryKey(Integer followId);

    int insert(Follow record);

    int insertSelective(Follow record);

    Follow selectByPrimaryKey(Integer followId);

    int updateByPrimaryKeySelective(Follow record);

    int updateByPrimaryKey(Follow record);

    List<FollowList> selectfollowListByUserId(Integer uid);
}
