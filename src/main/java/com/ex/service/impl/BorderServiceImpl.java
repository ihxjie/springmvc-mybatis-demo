package com.ex.service.impl;

import com.ex.service.BorderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BorderServiceImpl implements BorderService {
    @Resource
    BorderMapper borderMapper;
    @Override
    public int addBorder(Border border) {
        return borderMapper.addBorder(border);
    }

    @Override
    public int delBorder(int border_id) {
        return borderMapper.delBorder(border_id);
    }

    @Override
    public List<Border> getAllBorder() {
        return borderMapper.getAllBorder();
    }

    @Override
    public List<Border> findBorderByNames(String keyword) {
        return borderMapper.findBorderByNames(keyword);
    }
}
