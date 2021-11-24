package com.example.ecommerce_a.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecommerce_a.domain.User;
import com.example.ecommerce_a.form.LoginForm;
import com.example.ecommerce_a.service.LoginService;

@Controller
@RequestMapping("/login.html")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private HttpSession session;
	
	@ModelAttribute
	public LoginForm setUpForm() {
		return new LoginForm();
	}
	
	///////////////////////////////////////////////////
	//          　　　  ログイン設定　　　　　　　　　　　　//
	///////////////////////////////////////////////////
	
	/**
	 * ログイン画面を表示するメソッド
	 * return login.html
	 */
	@RequestMapping("")
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping("/result")
	public String login(LoginForm form,  Model model) {
		User user = loginService.login(form.getEmail(), form.getPassword());
		
		if (user == null) {
			model.addAttribute("errorMessage", "メールアドレスまたはパスワードが不正です。");
			return toLogin();
		}
		
		model.addAttribute("user", user);
		
		return "item_list";
	}
	
	///////////////////////////////////////////////////
	//          　　　  ログアウト設定　　　　　　　　　　　//
	///////////////////////////////////////////////////
	
	/**
	 * ログアウト用のメソッドを定義
	 * @return
	 */
	@RequestMapping("/item_list")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
	
}
