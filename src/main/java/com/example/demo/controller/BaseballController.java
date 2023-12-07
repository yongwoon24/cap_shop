package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class BaseballController {
@Autowired
private ProductRepository proR;
	
//	
//    @GetMapping("/")
//    public String index(Model model) {
//        List<Product> products = new ArrayList<>();
//					Product product1 = new Product();
//					product1.setName("모자1");
//					product1.setDescription("스포츠 테마의 모자");
//					product1.setPrice(28000);
//					product1.setPhotopath("/img/git merge 충돌.PNG");
//					products.add(product1);
//					proR.save(product1);
//					
//					
//					Product product2 = new Product();
//					product2.setName("모자1");
//					product2.setDescription("스포츠 테마의 모자");
//					product2.setPrice(28000);
//					products.add(product2);
//					proR.save(product2);
//					
//					
//					Product product3 = new Product();
//					product3.setName("모자1");
//					product3.setDescription("스포츠 테마의 모자");
//					product3.setPrice(28000);
//					products.add(product3);
//					proR.save(product3);
//					
//					
////        		Arrays.asList(
////                new Product("모자 1", "스포츠 테마의 모자", 25000),
////                new Product("모자 2", "캐주얼한 디자인의 모자", 30000),
////                new Product("모자 3", "야구 팬을 위한 모자", 28000)
////        );
//        model.addAttribute("products", products);
//        return "index";
//    }

//    private static class Product {
//        private final String name;
//        private final String description;
//        private final int price;
//
//        public Product(String name, String description, int price) {
//            this.name = name;
//            this.description = description;
//            this.price = price;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public String getDescription() {
//            return description;
//        }
//
//        public int getPrice() {
//            return price;
//        }
//    }
}
