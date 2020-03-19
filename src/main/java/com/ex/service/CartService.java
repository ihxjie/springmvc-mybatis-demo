package com.ex.service;

import java.util.List;

public interface CartService {
    int deleteByPrimaryKey(Integer cartId);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer cartId);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    List<Cart> selectByPrimaryUid(Integer uid);

    List<CartList> selectCartListByUserId(Integer uid);
}
