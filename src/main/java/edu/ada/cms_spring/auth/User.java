package edu.ada.cms_spring.auth;

import java.net.URL;
import java.util.Date;

public class User
{
	private String id;
	private String name;
	private final Date createdTime;
	private PrivilegeLevel level;
	private UserAuth auth;
	private Avatar avatar;
	
	public User(String id, String name, PrivilegeLevel level, UserAuth auth, Avatar avatar)
	{
		this.id = id;
		this.name = name;
		this.createdTime = new Date();
		this.level = level;
		this.auth = auth;
		this.avatar = avatar;
	}
	
	public User changeAvatar(URL url)
	{
		//TODO: fill
		return this;
	}
	
	public User setName(String name)
	{
		this.name = name;
		return this;
	}
	
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
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
	
	public Avatar getAvatar()
	{
		return avatar;
	}
	
	public void setAvatar(Avatar avatar)
	{
		this.avatar = avatar;
	}
}
