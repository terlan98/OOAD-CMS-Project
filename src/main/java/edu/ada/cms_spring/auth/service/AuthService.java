package edu.ada.cms_spring.auth.service;

import edu.ada.cms_spring.auth.exception.UserAlreadyRegisteredException;
import edu.ada.cms_spring.auth.exception.UserNotFoundException;
import edu.ada.cms_spring.auth.model.Token;
import edu.ada.cms_spring.auth.model.User;
import edu.ada.cms_spring.auth.model.dto.RegistrationModel;

public interface AuthService
{
	/**
	 * Registers a new user based on the provided RegistrationModel
	 * @param registrationModel the model based on which a new user entity will be created
	 * @return the created user
	 * @throws UserAlreadyRegisteredException if the user is already registered
	 */
	User registerUser(RegistrationModel registrationModel) throws UserAlreadyRegisteredException;
	
	/**
	 * Attempts to log in the user with the given credentials
	 * @param email email of the user
	 * @param password hashed version of the password
	 * @return the User entity that logged in
	 * @throws UserNotFoundException if the user can't be found in the database
	 */
	User login(String email, String password) throws UserNotFoundException;
	
	/**
	 * Logs the current user out
	 * @return the User entity that logged out
	 */
	User logout();
	
	/**
	 * Gets the user based on its email and password. Returns null if not found.
	 */
	User getUserByEmailAndPassword(String email, String password);
	
	
	void setCurrentToken(Token currentToken);
	
	void setCurrentUser(User user);
	
	User getCurrentUser();
	
	/**
	 * Indicates whether the session (token) of the current user is expired.
	 * Also returns false if login has not occurred before calling this method.
	 */
	boolean isSessionExpired();
}
