package com.ex.dao;

import com.ex.model.ProductType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductTypeMapper {
    int addProductType(ProductType productType);
    
    int delProductType(Integer type_id);
    
    List<ProductType> findAllType();

    List<ProductType> findTypeByNames(String keyword);
}