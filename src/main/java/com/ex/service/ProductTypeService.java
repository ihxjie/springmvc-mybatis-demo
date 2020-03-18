package com.ex.service;

import com.ex.model.ProductType;

import java.util.List;

public interface ProductTypeService {
    int addProductType(ProductType productType);

    int delProductType(Integer type_id);

    List<ProductType> findTypeByNames(String keyword);
}
