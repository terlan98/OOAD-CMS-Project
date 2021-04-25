package edu.ada.cms_spring.log;

import edu.ada.cms_spring.auth.model.LoginAttempt;

public class LoginLog extends Log
{
	private final LoginAttempt attempt;
	
	public LoginLog(String id, String message, LoginAttempt attempt)
	{
		super(id, message);
		this.attempt = attempt;
	}
	
	public LoginAttempt getAttempt()
	{
		return attempt;
	}
}
