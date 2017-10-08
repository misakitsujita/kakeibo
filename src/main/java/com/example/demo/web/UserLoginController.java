package com.example.demo.web;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domein.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.web.form.userInsertForm;
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

	/**
	 * フォーム初期化.
	 * 
	 * @return ログインフォーム
	 */

	@ModelAttribute
	public userInsertForm setUpForm2() {
		return new userInsertForm();
	}

	@RequestMapping("/")
	public String index() {
		return "userLogin";
	}

	@RequestMapping("/login")
	public String userLogin(@Validated userLoginForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return index();
		}
		//TODO:クソ実装
		try {
			String name = form.getName();
			String password = form.getPassword();
			List<User> userList = userRepository.findByNameAndPassword(name, password);

			if (!(userList.get(0).getName().equals(name))) {
				result.rejectValue("name", null, "名前またはパスワードが一致していません");
				return index();
			} else if (!(userList.get(0).getPassword().equals(password))) {
				result.rejectValue("password", null, "名前またはパスワードが一致していません");
				return index();
			} else {
				model.addAttribute("userList", userList);
				System.out.println(userList + "ログイン");
				return "/topView";
			}
		} catch (Exception e) {
			result.rejectValue("name", null, "名前またはパスワードが一致していません");
			result.rejectValue("password", null, "名前またはパスワードが一致していません");
			return index();
		}
	}

	@RequestMapping("/insert")
	public String userInsert(@Validated userInsertForm form, BindingResult result, Model model,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return index();
		}
		User user = new User();
		user.setName(form.getName());
		user.setPassword(form.getPassword());
		// TODO:すでに登録済みのユーザかチェック
		// List<User> userList =
		// userRepository.findByNameAndPassword(form.getName(),
		// form.getPassword());
		// user.setId(userList.get(0).getId());
		userRepository.saveUser(user);
		model.addAttribute("message", "登録が完了しました");
		// redirect.addFlashAttribute("message", "登録が完了しました");
		// return "redirect:index";
		return index();
	}

	@RequestMapping("/update")
	public String userUpdate() {
		return "userUpdate";
	}
}
