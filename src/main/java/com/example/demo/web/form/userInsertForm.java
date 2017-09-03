package com.example.demo.web.form;

import org.hibernate.validator.constraints.NotBlank;

public class userInsertForm {
	@NotBlank(message="名前を入力してください")
	private String name;
	@NotBlank(message="パスワードを入力してください")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
