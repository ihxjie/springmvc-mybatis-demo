package com.ex.service.impl;

import com.ex.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductMapper productMapper;

    @Override
    public Product findProductById(Integer id) {
        return productMapper.findProductById(id);
    }

    @Override
    public List<Product> findProductByType(Integer keword) {
        return productMapper.findProductByType(keword);
    }

    @Override
    public List<Product> findProductByName(String keyword) {
        return productMapper.findProductsByName(keyword);
    }

    @Override
    public List<Product> findAllProduct() {
        return productMapper.findAllProduct();
    }

    @Override
    public int addProduct(Product product) {
        return productMapper.addProduct(product);
    }

    @Override
    public int delProduct(Integer product_id) {
        return productMapper.delProduct(product_id);
    }

    @Override
    public int updProduct(Product product) {
        return productMapper.updProductById(product);
    }

}
