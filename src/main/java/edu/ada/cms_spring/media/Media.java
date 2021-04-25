package edu.ada.cms_spring.media;

import edu.ada.auth.User;
import edu.ada.comment.Comment;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Media
{
	private int size;
	
	private String name;
	private URI path; //TODO Should we create a Path class?
	private Date updateTime;
	private User owner;
	private List<SpecialPermission> permissions;
	
	private final List<Comment> comments = new ArrayList<>(1);
	private final Date createdTime;
	
	public Media(int size, String name, URI path, User owner, List<SpecialPermission> permissions)
	{
		this.size = size;
		this.name = name;
		this.path = path;
		this.owner = owner;
		this.createdTime = new Date();
		this.updateTime = new Date();
		this.permissions = permissions;
	}
	
	public List<Byte> read()
	{
		//TODO
		return null;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public void setSize(int size)
	{
		this.size = size;
		this.updateTime = new Date();
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
		this.updateTime = new Date();
	}
	
	public URI getPath()
	{
		return path;
	}
	
	public void setPath(URI path)
	{
		this.path = path;
		this.updateTime = new Date();
	}
	
	public Date getCreatedTime()
	{
		return createdTime;
	}
	
	public Date getUpdateTime()
	{
		return updateTime;
	}
	
	public User getOwner()
	{
		return owner;
	}
	
	public void setOwner(User owner)
	{
		this.owner = owner;
		this.updateTime = new Date();
	}
	
	public List<SpecialPermission> getPermissions()
	{
		return permissions;
	}
	
	public void setPermissions(List<SpecialPermission> permissions)
	{
		this.permissions = permissions;
		this.updateTime = new Date();
	}
	
	public List<Comment> getComments()
	{
		return comments;
	}
}
