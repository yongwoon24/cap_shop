package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class BaseballController {

	@Autowired
	private ProductRepository proR;

	@GetMapping("/")
	public String index(Model model) {
		List<Product> products = proR.findByType("cap");
		model.addAttribute("products", products);
		return "index";
	}

	@GetMapping("/buckethat")
	public String buckethat(Model model) {
		List<Product> products = proR.findByType("buckethat");
		model.addAttribute("products", products);
		return "buckethat";
	}

	@GetMapping("/vigny")
	public String vigny(Model model) {
		List<Product> products = proR.findByType("vigny");
		model.addAttribute("products", products);
		return "vigny";
	}

	@GetMapping("/headband")
	public String headband(Model model) {
		List<Product> products = proR.findByType("headband");
		model.addAttribute("products", products);
		return "headband";
	}
	@GetMapping("/nike")
	public String nike(Model model) {
		List<Product> products = proR.findByBrand("nike");
		model.addAttribute("products", products);
		return "nike";
	}
	@GetMapping("/adidas")
	public String adidas(Model model) {
		List<Product> products = proR.findByBrand("adidas");
		model.addAttribute("products", products);
		return "adidas";
	}
	@GetMapping("/mlb")
	public String mlb(Model model) {
		List<Product> products = proR.findByBrand("mlb");
		model.addAttribute("products", products);
		return "mlb";
	}
	
	@GetMapping("/product/{productId}")
    public String getProductDetail(@PathVariable int productId, Model model) {
        Product product = proR.findById(productId).orElse(null);

        if (product != null) {
            model.addAttribute("product", product);
            return "productDetail";
        } else {
            return "redirect:/";
        }
    }

}
