package edu.ada.cms_spring.auth.controller;

import edu.ada.cms_spring.auth.exception.UserAlreadyRegisteredException;
import edu.ada.cms_spring.auth.exception.UserNotFoundException;
import edu.ada.cms_spring.auth.model.User;
import edu.ada.cms_spring.auth.model.dto.LoginModel;
import edu.ada.cms_spring.auth.model.dto.RegistrationModel;
import edu.ada.cms_spring.auth.service.AuthService;
import edu.ada.cms_spring.auth.service.HashService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
/**
 * Handles the login and registration related requests. Logs all interactions.
 */
public class AuthController
{
	private Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	private String currentError = null;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private HashService hashService;
	
	@GetMapping
	String getLoginPage(Model model) // model is to attach stuff that can be used in the template
	{
		if (authService.getCurrentUser() == null) // No user logged in. Show login view
		{
			LoginModel loginModel = new LoginModel();
			model.addAttribute("loginModel", loginModel);
			model.addAttribute("error", currentError);
			currentError = null; // reset error message
			return "login";
		}
		
		return "redirect:/media";
	}
	
	@GetMapping("/register")
	String getRegistrationPage(Model model)
	{
		RegistrationModel registrationModel = new RegistrationModel();
		model.addAttribute("registrationModel", registrationModel);
		model.addAttribute("error", currentError);
		currentError = null; // reset error message
		return "register";
	}
	
	@PostMapping("/submit-login")
	public String submitLogin(@ModelAttribute LoginModel loginModel)
	{
		logger.info("Login :: Email: {}", loginModel.getEmail());
		logger.info("Login :: Password: {}", loginModel.getPassword());
		
		loginModel.setPassword(hashService.hash(loginModel.getPassword()));
		
		try
		{
			User user = authService.login(loginModel.getEmail(), loginModel.getPassword());
			
			logger.info("Login :: Successful. Redirecting to home...");
			authService.setCurrentUser(user);
			
		} catch (UserNotFoundException e)
		{
			logger.info("Login :: Failed");
			currentError = "User not found";
		}
		
		return "redirect:/";
	}
	
	@PostMapping("/submit-registration")
	public String submitRegistration(@ModelAttribute RegistrationModel registrationModel)
	{
		logger.info("Registration :: Email: {}", registrationModel.getEmail());
		logger.info("Registration :: Password: {}", registrationModel.getPassword());
		
		registrationModel.setPassword(hashService.hash(registrationModel.getPassword()));
		
		try
		{
			User user = authService.registerUser(registrationModel);
			authService.setCurrentUser(user);
			logger.info("Registration :: Successful");
			return "redirect:/";
			
		} catch (UserAlreadyRegisteredException e)
		{
			logger.error("Registration :: The user is already registered");
			currentError = "User already exists";
			return "redirect:/register";
		}
	}
	
	@GetMapping("/logout")
	String logOut(Model model)
	{
		authService.logout();
		return "redirect:/";
	}
}
