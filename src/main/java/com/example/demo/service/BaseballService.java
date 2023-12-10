package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface BaseballService {
	List<Product> getProductsByType(String type);

    List<Product> getProductsByBrand(String brand);

    Product getProductById(int productId);
}
