package edu.ada.cms_spring.media;

import edu.ada.auth.User;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MediaDir
{
	private String name;
	private URI path;
	private Date updateTime;
	private User owner;
	private MediaType type;
	private List<Media> media = new ArrayList<>(1);
	
	private final List<Permission> permissions;
	private final Date createdTime;
	
	public MediaDir(String name, URI path, User owner, MediaType type, List<Permission> permissions)
	{
		this.name = name;
		this.path = path;
		this.owner = owner;
		this.type = type;
		this.permissions = permissions;
		
		this.createdTime = new Date();
		this.updateTime = new Date();
	}
	
	//TODO change in CD
	public void deleteMedia(Media media)
	{
		this.media.remove(media);
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
	
	public MediaType getType()
	{
		return type;
	}
	
	public void setType(MediaType type)
	{
		this.type = type;
		this.updateTime = new Date();
	}
	
	public List<Permission> getPermissions()
	{
		return permissions;
	}
	
	public List<Media> getMedia()
	{
		return media;
	}
	
	public void setMedia(List<Media> media)
	{
		this.media = media;
		this.updateTime = new Date();
	}
	
	public Date getCreatedTime()
	{
		return createdTime;
	}
}
