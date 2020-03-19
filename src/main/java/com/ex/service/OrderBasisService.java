package com.ex.service;

import java.util.List;

public interface OrderBasisService {
    int deleteByPrimaryKey(Integer orderId);

    int insertSelective(OrderBasis record);

    OrderBasis selectByOrderId(Integer orderId);

    List<OrderBasis> selectAllOrderBasis();

    List<OrderBasis> selectByUserIdOrderBasis(Integer uid);

    int updateByPrimaryKeySelective(OrderBasis record);

    int updateByPrimaryKey(OrderBasis record);

    int insert(OrderBasis record);

    List<OrderBasis> selectOrderBasisByNames(String keyword);
}
