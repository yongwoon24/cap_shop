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
import com.example.demo.service.BaseballService;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class BaseballController {

	@Autowired
	private ProductRepository proR;
	
	@Autowired
	private BaseballService baseS;

	@GetMapping("/")
	public String index(Model model) {
		 List<Product> products = baseS.getProductsByType("cap");
	        model.addAttribute("products", products);
	        return "index";
	}

	@GetMapping("/buckethat")
	public String buckethat(Model model) {
		 List<Product> products = baseS.getProductsByType("buckethat");
	        model.addAttribute("products", products);
	        return "buckethat";
	}

	@GetMapping("/vigny")
	public String vigny(Model model) {
		  List<Product> products = baseS.getProductsByType("vigny");
	        model.addAttribute("products", products);
	        return "vigny";
	}

	@GetMapping("/headband")
	public String headband(Model model) {
		List<Product> products = baseS.getProductsByType("headband");
        model.addAttribute("products", products);
        return "headband";
	}
	@GetMapping("/nike")
	public String nike(Model model) {
		 List<Product> products = baseS.getProductsByBrand("nike");
	        model.addAttribute("products", products);
	        return "nike";
	}
	@GetMapping("/adidas")
	public String adidas(Model model) {
		  List<Product> products = baseS.getProductsByBrand("adidas");
	        model.addAttribute("products", products);
	        return "adidas";
	}
	@GetMapping("/mlb")
	public String mlb(Model model) {
		 List<Product> products = baseS.getProductsByBrand("mlb");
	        model.addAttribute("products", products);
	        return "mlb";
	}
	
	@GetMapping("/product/{productId}")
    public String getProductDetail(@PathVariable int productId, Model model) {
		Product product = baseS.getProductById(productId);

        if (product != null) {
            model.addAttribute("product", product);
            return "productDetail";
        } else {
            return "redirect:/";
        }
    }

}
