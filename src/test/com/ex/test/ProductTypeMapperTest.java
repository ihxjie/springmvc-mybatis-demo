package com.ex.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductTypeMapperTest extends BaseJunit4Test {

    @Autowired
    ProductTypeMapper productTypeMapper;

    @Test
    public void testAddProductType(){
        ProductType productType = new ProductType();
        productType.setTypeName("电子产品");
        productTypeMapper.addProductType(productType);

    }

    @Test
    public void testDelProductType(){
        productTypeMapper.delProductType(3);
    }

    @Test
    public void testFindAllType(){
        List<ProductType> productTypeList = productTypeMapper.findAllType();
    }
}
