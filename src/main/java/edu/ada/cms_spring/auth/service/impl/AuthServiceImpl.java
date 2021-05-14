package edu.ada.cms_spring.auth.service.impl;

import edu.ada.cms_spring.auth.exception.UserAlreadyRegisteredException;
import edu.ada.cms_spring.auth.exception.UserNotFoundException;
import edu.ada.cms_spring.auth.model.Token;
import edu.ada.cms_spring.auth.model.User;
import edu.ada.cms_spring.auth.model.dto.RegistrationModel;
import edu.ada.cms_spring.auth.repository.TokenRepo;
import edu.ada.cms_spring.auth.repository.UserRepo;
import edu.ada.cms_spring.auth.service.AuthService;
import edu.ada.cms_spring.auth.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService
{
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private TokenRepo tokenRepo;
	
	@Autowired
	private TokenService tokenService;
	
	private User currentUser;
	
	private Token currentToken;
	
	@Override
	public User registerUser(RegistrationModel registrationModel) throws UserAlreadyRegisteredException
	{
		if (userRepo.findByEmail(registrationModel.getEmail()) != null) throw new UserAlreadyRegisteredException();
		
		User user = new User();
		user.setName(registrationModel.getName());
		user.setEmail(registrationModel.getEmail());
		user.setPassword(registrationModel.getPassword());
		userRepo.save(user);
		
		setCurrentToken(tokenService.generate(user));
		
		return user;
	}
	
	@Override
	public User login(String email, String password) throws UserNotFoundException
	{
		User user = getUserByEmailAndPassword(email, password);
		if (user == null) throw new UserNotFoundException();
		setCurrentToken(tokenService.generate(user));
		return user;
	}
	
	@Override
	public User logout()
	{
		User user = currentUser;
		setCurrentToken(null);
		setCurrentUser(null);
		return user;
	}
	
	@Override
	public User getUserByEmailAndPassword(String email, String password)
	{
		return userRepo.findByEmailAndPassword(email, password);
	}
	
	@Override
	public User getCurrentUser()
	{
		return currentUser;
	}
	
	@Override
	public void setCurrentUser(User currentUser)
	{
		this.currentUser = currentUser;
	}
	
	public void setCurrentToken(Token currentToken)
	{
		this.currentToken = currentToken;
		if(currentToken != null) tokenRepo.save(currentToken);
	}
	
	@Override
	public boolean isSessionExpired()
	{
		return currentToken == null || tokenService.isValid(currentToken);
	}
}
