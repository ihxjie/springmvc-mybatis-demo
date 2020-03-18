package com.ex.service.impl;

import com.ex.dao.OrderBasisMapper;
import com.ex.model.OrderBasis;
import com.ex.service.OrderBasisService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderBasisServiceImpl implements OrderBasisService {

    @Resource
    OrderBasisMapper orderBasisMapper;

    @Override
    public int deleteByPrimaryKey(Integer orderId) {
        return orderBasisMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int insertSelective(OrderBasis record) {
        return orderBasisMapper.insertSelective(record);
    }

    @Override
    public OrderBasis selectByOrderId(Integer orderId) {
        return null;
    }

    @Override
    public List<OrderBasis> selectAllOrderBasis() {
        return null;
    }

    @Override
    public List<OrderBasis> selectByUserIdOrderBasis(Integer uid) {
        return orderBasisMapper.selectByUserIdOrderBasis(uid);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderBasis record) {
        return orderBasisMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderBasis record) {
        return 0;
    }

    @Override
    public int insert(OrderBasis record) {
        return orderBasisMapper.insert(record);
    }


    @Override
    public List<OrderBasis> selectOrderBasisByNames(String keyword) {
        return orderBasisMapper.selectOrderBasisByNames(keyword);

    }
}
