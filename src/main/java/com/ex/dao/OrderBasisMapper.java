package com.ex.dao;

import com.ex.model.OrderBasis;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderBasisMapper {
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