package com.ex.service.impl;

import com.ex.dao.ReasonMapper;
import com.ex.model.Reason;
import com.ex.service.ReasonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReasonServiceImpl implements ReasonService {
    @Resource
    private ReasonMapper reasonMapper;

    @Override
    public boolean insert(Reason record) {
        boolean flag = false;
        if(reasonMapper.insert(record) > 0)
            flag = true;
        return flag;
    }
}
