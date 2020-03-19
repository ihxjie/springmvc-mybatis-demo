package com.ex.service;

import java.util.List;

public interface ProductService {
    Product findProductById(Integer product_id);
    List<Product> findProductByType(Integer keword);
    List<Product> findProductByName(String keyword);
    List<Product> findAllProduct();
    int addProduct(Product product);
    int delProduct(Integer product_id);
    int updProduct(Product product);

}
