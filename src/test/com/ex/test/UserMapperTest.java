package com.ex.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserMapperTest extends BaseJunit4Test {
    @Autowired
    UserMapper userMapper;


    @Test
    public void testSelectUserByEmail(){
        List<User> userList = userMapper.selectUserByEmail("@");
        for (User u : userList
             ) {
            System.out.println(u);
        }
    }

    @Test
    public void testtt(String str){
        if(str == null){
            System.out.println("111");
        }

    }

}
