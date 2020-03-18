package com.ex.dao;

import com.ex.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    List<Product> findAllProduct();

    List<Product> findProductByType(Integer keword);

    List<Product> findProductsByName(String keyword);

    Product findProductById(Integer product_id);

    int addProduct(Product product);

    int delProduct(Integer product_id);

    int updProductById(Product product);

}