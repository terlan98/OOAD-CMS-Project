package edu.ada.cms_spring.auth;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Token
{
	private User user;
	private final Date dateCreated;
	private Date dateExpires;
	private final List<String> asks = new ArrayList<>(1);
	
	public Token(User user, Date dateCreated, Date dateExpires)
	{
		this.user = user;
		this.dateCreated = dateCreated;
		this.dateExpires = dateExpires;
	}
	
	public User getUser()
	{
		return user;
	}
	
	public void setUser(User user)
	{
		this.user = user;
	}
	
	public Date getDateCreated()
	{
		return dateCreated;
	}
	
	public Date getDateExpires()
	{
		return dateExpires;
	}
	
	public void setDateExpires(Date dateExpires)
	{
		this.dateExpires = dateExpires;
	}
	
	public List<String> getAsks()
	{
		return asks;
	}
}
