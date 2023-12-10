package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class BaseballServiceImpl implements BaseballService{
	@Autowired
    private ProductRepository proR;

    @Override
    public List<Product> getProductsByType(String type) {
        return proR.findByType(type);
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        return proR.findByBrand(brand);
    }

    @Override
    public Product getProductById(int productId) {
        Optional<Product> optionalProduct = proR.findById(productId);
        return optionalProduct.orElse(null);
    }
}
