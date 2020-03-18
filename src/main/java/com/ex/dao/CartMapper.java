package com.ex.dao;

import com.ex.model.Cart;
import com.ex.model.CartList;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer cartId);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer cartId);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    List<Cart> selectByPrimaryUid(Integer uid);

    List<CartList> selectCartListByUserId(Integer uid);


}