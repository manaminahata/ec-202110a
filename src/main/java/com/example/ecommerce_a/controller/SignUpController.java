package com.example.ecommerce_a.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecommerce_a.domain.User;
import com.example.ecommerce_a.form.SignUpForm;
import com.example.ecommerce_a.service.SignUpService;

@Controller
@RequestMapping("/user")
public class SignUpController {

	@Autowired
	private SignUpService signUpService;

	@ModelAttribute
	private SignUpForm setUpForm() {
		return new SignUpForm();
	}

	@RequestMapping("/to-signup")
	public String toSignUp() {
		return "signup";
	}

	@RequestMapping("/signup")
	public String signUp(SignUpForm form, Model model) {
		// データベースに入力されたメールアドレスを含むアカウントがいたら、サインアップ画面に戻す
		if (!signUpService.checkEmail(form.getEmail()).isEmpty()) {
			model.addAttribute("message", "このメールアドレスはすでに使用されています。");
			return "sign-up";
		}

		// データベースに入力されたメールアドレスを含むアカウントがなければ、会員登録を実行、ログイン画面にリダイレクト
		User user = new User();
		BeanUtils.copyProperties(form, user);
		System.out.println(form);
		System.out.println(user);
		signUpService.signUp(user);

		model.addAttribute("message", "会員登録に成功しました。");
		return "login";
	}

}
