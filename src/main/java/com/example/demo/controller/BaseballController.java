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

@Controller
public class BaseballController {
	
	  @Autowired private ProductRepository proR;
	  
	  @Autowired public UserRepository userR;
	  
//	  @GetMapping("/") public String index(HttpSession session, Model model) {
//	  List<Product> products = new ArrayList<>();
//	  
//	  String loggedInUserId = (String) session.getAttribute("loggedInUserId"); User
//	  user = userR.findById1(loggedInUserId);
//	  
//	  Product product1 = new Product(); product1.setName("모자1");
//	  product1.setDescription("나이키"); product1.setPrice(28000);
//	  product1.setPhotopath("/img/git merge 충돌.PNG"); products.add(product1);
//	  proR.save(product1);
//	  
//	  Product product2 = new Product(); product2.setName("모자2");
//	  product2.setDescription("아디다스"); product2.setPrice(28000);
//	  products.add(product2); proR.save(product2);
//	  
//	  Product product3 = new Product(); product3.setName("모자3");
//	  product3.setDescription("mlb"); product3.setPrice(28000);
//	  products.add(product3); proR.save(product3); // model.addAllAttribute();
//	  
//	  return "index";
//	  
//	  }
	  
	  @GetMapping("/buckethat") public String buckethat() {
	  
	  return "buckethat"; }
	  
	  @GetMapping("/vigny") public String vigny() {
	  
	  return "vigny"; }
	  
	  @GetMapping("/headband") public String headband() {
	  
	  return "headband"; }
	 
	  @GetMapping("/view/{productId}")
	    public String viewProduct(@PathVariable int productId, Model model) {
	        // Product ID를 사용하여 해당 제품을 데이터베이스에서 가져옴
	        List<Product> product = proR.findById(productId);
	      
	        
	        if (product != null) {
	        	
	            // 제품이 존재하는 경우에만 뷰 페이지로 전달
	        
	            model.addAttribute("product", product);
	            
	        } else {
	            // 해당 ID의 제품이 없으면 에러 처리 또는 다른 작업 수행
	            model.addAttribute("errorMessage", "해당 제품을 찾을 수 없습니다.");
	        }

	        return "view";
	    }

}
