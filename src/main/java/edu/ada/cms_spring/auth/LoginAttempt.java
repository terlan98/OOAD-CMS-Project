package edu.ada.cms_spring.auth;

import edu.ada.utils.Location;

import java.util.Date;

public class LoginAttempt
{
	private String id;
	private Location location;
	private final Date createdTime;
	private PrivilegeLevel level;
	private UserAuth auth;
	
	public LoginAttempt(String id, Location location, PrivilegeLevel level, UserAuth auth)
	{
		this.id = id;
		this.location = location;
		this.level = level;
		this.auth = auth;
		this.createdTime = new Date();
	}
	
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public Location getLocation()
	{
		return location;
	}
	
	public void setLocation(Location location)
	{
		this.location = location;
	}
	
	public Date getCreatedTime()
	{
		return createdTime;
	}
	
	public PrivilegeLevel getLevel()
	{
		return level;
	}
	
	public void setLevel(PrivilegeLevel level)
	{
		this.level = level;
	}
	
	public UserAuth getAuth()
	{
		return auth;
	}
	
	public void setAuth(UserAuth auth)
	{
		this.auth = auth;
	}
}
