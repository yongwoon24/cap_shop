package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;



@Controller
public class SignupController {
	@Autowired
    private UserRepository userRepository;
	
	 @GetMapping("/signup")
	    public String createUserForm(Model model) {
	        model.addAttribute("user", new User());
	        return "signup";
	    }
	 
	 @PostMapping("/signup")
	    public String createUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
	    	try {
	            // 사용자가 존재하지 않을 때만 토큰 생성 및 저장, 이메일 전송
	           
	            userRepository.save(user);
	            
	            // 인증 링크 생성

	            // 이메일 전송 메소드 호출
	            
	            // 성공 시 메시지 설정
	            redirectAttributes.addFlashAttribute("successMessage", "회원가입이 완료되었습니다!");
	            return "redirect:/login";
	        } catch (Exception e) {
	            throw new RuntimeException("회원가입 중 오류 발생", e);
	        }
	    }
	    
	  @GetMapping("/checkUserIdAvailability")
	    @ResponseBody
	    public boolean checkUserIdAvailability(@RequestParam String id) {
	        // 데이터베이스에서 해당 사용자 이름을 검색하여 결과 확인
	       List<User> existingUser = userRepository.findById(id);
	        
	        // 중복 여부에 따라 결과 반환
	        return existingUser.isEmpty(); // true는 중복이 아님, false는 중복임
	    }
	    
	  
	    @GetMapping("/checkUsernicknameAvailability")
	    @ResponseBody
	    public boolean checkUsernicknameAvailability(@RequestParam String nickname) {
	        // 데이터베이스에서 해당 사용자 이름을 검색하여 결과 확인
	       List<User> existingUser = userRepository.findBynicknameList(nickname);
	        
	        // 중복 여부에 따라 결과 반환
	        return existingUser.isEmpty(); // true는 중복이 아님, false는 중복임
	    }
	 
}
