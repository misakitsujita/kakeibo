package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domein.Payment;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.repository.UserRepository;

@Controller
@Transactional
@RequestMapping("/top")
public class TopViewController {
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@RequestMapping("/index")
	public String index(){
		return "topView";
	}
		
	@RequestMapping("/viewGraph")
	public String insertIncome(Model model,Integer userId){
		List<Payment> paymentList = paymentRepository.findBySumAndCategory(userId);
		model.addAttribute("paymentList",paymentList);
		return "categoryGraph";
	}

}
