package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("userLogin")
public class UserLoginController {

	@RequestMapping("/")
	public String index() {
		System.out.println("hghg");
		return "/userLogin";
	}
}
