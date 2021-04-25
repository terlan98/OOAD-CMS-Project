package edu.ada.cms_spring.log;

import edu.ada.cms_spring.auth.model.User;

public class AccessLog extends Log
{
	private User user;
	private boolean state; // false if access is denied
	
	public AccessLog(String id, String message, User user)
	{
		super(id, message);
		this.user = user;
		this.state = false;
	}
	
	public User getUser()
	{
		return user;
	}
	
	public void setUser(User user)
	{
		this.user = user;
	}
	
	public boolean isState()
	{
		return state;
	}
	
	public void setState(boolean state)
	{
		this.state = state;
	}
}
