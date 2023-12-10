package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.DeliveryInfo;
import com.example.demo.entity.Product;
import com.example.demo.repository.DeliveryinfoRepository;
import com.example.demo.repository.ProductRepository;

@Controller
public class OrderController {
	@Autowired
	private ProductRepository productRepository;
	private DeliveryinfoRepository deliveryinfoRepository;
	
	@GetMapping("/order/{productId}")
	public String productDetail(@PathVariable int productId, Model model) {
	    Optional<Product> product = productRepository.findById(productId);

	    if (product.isPresent()) {
	        model.addAttribute("product", product.get());
	        // 추가: 선택한 size와 quantity를 모델에 추가
	        model.addAttribute("size", "");
	        model.addAttribute("quantity", 1);
	        return "order";
	    } else {
	        // 상품이 없을 경우 처리
	        return "redirect:/"; // 또는 에러 페이지로 리다이렉트
	    }
	}
	@PostMapping("/order")
    public String processOrder(@ModelAttribute("deliveryInfo") DeliveryInfo deliveryInfo,
                               @RequestParam Integer productId) {
        // 여기서 주문 정보를 처리하고, 필요에 따라 데이터베이스에 저장합니다.
        // productId를 DeliveryInfo에 설정
        deliveryInfo.setId(productId);

        // 적절한 비즈니스 로직을 구현하세요.

        // DeliveryInfo 엔티티를 저장
        deliveryinfoRepository.save(deliveryInfo);

        // 주문이 완료된 후에는 다른 페이지로 리다이렉트할 수 있습니다.
        return "redirect:/thank-you";
    }
}
