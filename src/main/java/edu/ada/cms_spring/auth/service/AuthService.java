package edu.ada.cms_spring.auth.service;

import edu.ada.cms_spring.auth.exception.UserAlreadyRegisteredException;
import edu.ada.cms_spring.auth.exception.UserNotFoundException;
import edu.ada.cms_spring.auth.model.Token;
import edu.ada.cms_spring.auth.model.User;
import edu.ada.cms_spring.auth.model.dto.RegistrationModel;

public interface AuthService
{
	User registerUser(RegistrationModel registrationModel) throws UserAlreadyRegisteredException;
	User login(String email, String password) throws UserNotFoundException;
	User logout();
	User getUserByEmailAndPassword(String email, String password);
	void setCurrentToken(Token currentToken);
	void setCurrentUser(User user);
	User getCurrentUser();
	boolean isSessionExpired();
}
