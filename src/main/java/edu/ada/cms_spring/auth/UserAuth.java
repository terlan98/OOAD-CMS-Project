package edu.ada.cms_spring.auth;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserAuth
{
	private final Date createdTime;
	
	private String id;
	private String userId;
	private String primaryEmail;
	private String password;
	
	private final List<String> emails = new ArrayList<>(1);
	private final List<LoginAttempt> logins = new ArrayList<>(1);
	
	public UserAuth(String id, String userId, String primaryEmail, String password)
	{
		this.id = id;
		this.userId = userId;
		this.createdTime = new Date();
		this.primaryEmail = primaryEmail;
		this.password = password;
	}
	
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getUserId()
	{
		return userId;
	}
	
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	
	public Date getCreatedTime()
	{
		return createdTime;
	}
	
	public String getPrimaryEmail()
	{
		return primaryEmail;
	}
	
	public void setPrimaryEmail(String primaryEmail)
	{
		this.primaryEmail = primaryEmail;
	}
	
	public List<String> getEmails()
	{
		return emails;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public List<LoginAttempt> getLogins()
	{
		return logins;
	}
}
