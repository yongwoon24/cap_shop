package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	@Autowired
	private ProductRepository proR;

	@Autowired
	public UserRepository userR;

	@GetMapping("/")
	public String index(HttpSession session, Model model) {
		List<Product> products = new ArrayList<>();

		String loggedInUserId = (String) session.getAttribute("loggedInUserId");
		User user = userR.findById1(loggedInUserId);

		Product product1 = new Product();
		product1.setName("모자1");
		product1.setDescription("스포츠 테마의 모자");
		product1.setPrice(28000);
		product1.setPhotopath("/img/git merge 충돌.PNG");
		products.add(product1);
		proR.save(product1);

		Product product2 = new Product();
		product2.setName("모자1");
		product2.setDescription("스포츠 테마의 모자");
		product2.setPrice(28000);
		products.add(product2);
		proR.save(product2);

		Product product3 = new Product();
		product3.setName("모자1");
		product3.setDescription("스포츠 테마의 모자");
		product3.setPrice(28000);
		products.add(product3);
		proR.save(product3);
		// model.addAllAttribute();

		return "index";

	}
	
	@GetMapping("/buckethat")
	public String buckethat() {
		
		return "buckethat";
	}
	
	@GetMapping("/vigny")
	public String vigny() {
		
		return "vigny";
	}
	
	@GetMapping("/headband")
	public String headband() {
		
		return "headband";
	}

}
