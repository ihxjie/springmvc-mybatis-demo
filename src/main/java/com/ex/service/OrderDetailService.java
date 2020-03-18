package com.ex.service;

import com.ex.model.OrderDetail;
import java.util.List;


public interface OrderDetailService {

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Integer purchaseQuantity);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

    int deleteByPrimaryKey(Integer orderId);

    List<OrderDetail> selectByNames(String keyword);

}
