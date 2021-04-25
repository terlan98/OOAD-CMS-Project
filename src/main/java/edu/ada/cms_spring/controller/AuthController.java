package edu.ada.cms_spring.controller;

import edu.ada.cms_spring.model.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController
{
	@GetMapping
	String getSomething(Model model) // model is to attach stuff that can be used in the template
	{
		LoginModel loginModel = new LoginModel();
		model.addAttribute("loginModel", loginModel);
		return "auth";
	}
	
	@PostMapping("/submit")
	public String submitLogin(@ModelAttribute LoginModel loginModel) {
		System.out.println(loginModel.getEmail());
		System.out.println(loginModel.getPassword());
		return "home";
	}
}
