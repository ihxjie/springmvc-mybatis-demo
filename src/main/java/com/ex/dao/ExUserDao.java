package com.ex.dao;

import com.ex.model.ExUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExUserDao {

    List<ExUser> findAll();

    ExUser findUserById(String id);

    int deleteUserById(int id);
}
