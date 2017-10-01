package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domein.Payment;
import com.example.demo.domein.User;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.repository.UserRepository;

@Controller
@Transactional
@RequestMapping("/top")
public class TopViewController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@RequestMapping("/index")
	public String index(@RequestParam Integer userId, Model model){
		System.out.println("userId : " + userId);
		List<User> userList = userRepository.load(userId);
		model.addAttribute("userList",userList);
		return "topView";
	}
		
	@RequestMapping("/viewGraph")
	public String insertIncome(Model model,Integer userId){
		List<Payment> paymentList = paymentRepository.findBySumAndCategory(userId);
		model.addAttribute("paymentList",paymentList);
		
		List<User> userList = userRepository.load(userId);
		model.addAttribute("userList",userList);
		return "categoryGraph";
	}

}
