package edu.ada.cms_spring.auth.service.impl;

import edu.ada.cms_spring.auth.model.Token;
import edu.ada.cms_spring.auth.model.User;
import edu.ada.cms_spring.auth.service.TokenService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class TokenServiceImpl implements TokenService
{
	@Override
	public Token generate(User user)
	{
		return new Token(user, 3600);
	}
	
	@Override
	public boolean isValid(Token token)
	{
		return new Date().after(token.getDateExpires());
	}
}
