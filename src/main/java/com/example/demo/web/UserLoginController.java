package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domein.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.web.form.userLoginForm;

/**
 * ユーザのログイン用コントローラ.
 * 
 * @author tujitamisaki
 *
 */
@Controller
@RequestMapping("userLogin")
public class UserLoginController {

	@Autowired
	private UserRepository userRepository;

	/**
	 * フォーム初期化.
	 * 
	 * @return ログインフォーム
	 */
	@ModelAttribute
	public userLoginForm setUpForm() {
		return new userLoginForm();
	}

	@RequestMapping("/")
	public String index() {
		return "userLogin";
	}

	@RequestMapping("/login")
	public String index(@Validated userLoginForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return index();
		} else {
			String name = form.getName();
			String password = form.getPassword();
			List<User> userList = userRepository.findByNameAndPassword(name, password);
			if (userList.get(0).getName() == name && userList.get(0).getPassword() == password) {
				model.addAttribute("userList", userList);
				return "/topView";
			}
		}
		return "/topView";
	}
}
