package com.ex.test;

import com.ex.dao.ProductMapper;
import com.ex.model.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductMapperTest extends BaseJunit4Test {
    @Autowired
    ProductMapper productMapper;

    @Test
    public void testFindAllProduct(){
        List<Product> productList = productMapper.findAllProduct();
    }

    @Test
    public void testFindProductsByName(){
        List<Product> productList = productMapper.findProductsByName("小");
    }

    @Test
    public void testAddProduct(){

    }

    @Test
    public void testDelProduct(){

    }

    @Test
    public void testUpdProductById(){
        Product product = new Product();
        product.setProductId(1);
        product.setProductStock(4);
        productMapper.updProductById(product);
    }
}
