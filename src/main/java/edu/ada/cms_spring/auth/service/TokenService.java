package edu.ada.cms_spring.auth.service;

import edu.ada.cms_spring.auth.model.Token;
import edu.ada.cms_spring.auth.model.User;

/**
 * Interface to be implemented by classes offering token services.
 */
public interface TokenService
{
	/**
	 * Generates a new token
	 */
	Token generate(User user);
	
	/**
	 * Checks the validitythe given token
	 */
	boolean isValid(Token token);
}
