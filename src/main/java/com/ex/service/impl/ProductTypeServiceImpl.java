package com.ex.service.impl;

import com.ex.service.ProductTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Resource
    ProductTypeMapper productTypeMapper;
    @Override
    public int addProductType(ProductType productType) {
        return productTypeMapper.addProductType(productType);
    }

    @Override
    public int delProductType(Integer type_id) {
        return productTypeMapper.delProductType(type_id);
    }

    @Override
    public List<ProductType> findTypeByNames(String keyword) {
        return productTypeMapper.findTypeByNames(keyword);
    }
}
