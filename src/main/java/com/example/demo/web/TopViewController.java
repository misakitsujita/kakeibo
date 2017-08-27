package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.UserRepository;

@Controller
@Transactional
@RequestMapping("/top")
public class TopViewController {
	
	@Autowired
	UserRepository repository;
	
	@RequestMapping("/index")
	public String index(){
		System.out.println("aaa");
		return "topView";
	}

}
