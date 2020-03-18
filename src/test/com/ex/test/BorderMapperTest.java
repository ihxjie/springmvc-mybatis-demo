package com.ex.test;

import com.alibaba.fastjson.JSON;
import com.ex.dao.BorderMapper;
import com.ex.model.Border;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BorderMapperTest extends BaseJunit4Test {
    @Autowired
    private BorderMapper borderMapper;

    @Test
    public void testInsertBorder(){
        Border border = new Border();
        border.setBorderTitle("Junit Test");
        border.setBorderContent("Test");
        borderMapper.addBorder(border);
    }

    @Test
    public void testDeleteBorder(){
        borderMapper.delBorder(6);
    }

    @Test
    public void testGetAllBorder(){

        PageHelper.startPage(0,2);
        List<Border> borderList = borderMapper.getAllBorder();
        PageInfo pageInfo = new PageInfo(borderList);
        System.out.println(JSON.toJSONString(pageInfo));

    }

}
