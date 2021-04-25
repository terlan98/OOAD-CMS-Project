package edu.ada.cms_spring.media;


import edu.ada.cms_spring.auth.model.User;

import java.util.Date;

public class SpecialPermission
{
	private Permission permission;
	private User target;
	private Date dateUpdated;
	
	private final Date dateCreated;
	
	public SpecialPermission(Permission permission, User target)
	{
		this.permission = permission;
		this.target = target;
		this.dateCreated = new Date();
	}
	
	public Permission getPermission()
	{
		return permission;
	}
	
	public void setPermission(Permission permission)
	{
		this.permission = permission;
		this.dateUpdated = new Date();
	}
	
	public User getTarget()
	{
		return target;
	}
	
	public void setTarget(User target)
	{
		this.target = target;
		this.dateUpdated = new Date();
	}
	
	public Date getDateUpdated()
	{
		return dateUpdated;
	}
	
	public Date getDateCreated()
	{
		return dateCreated;
	}
}
