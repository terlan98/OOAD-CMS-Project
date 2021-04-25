package edu.ada.cms_spring.auth;

import java.net.URL;
import java.util.Date;

public class Avatar
{
	private String id;
	private URL url;
	private final Date createdTime;
	
	public Avatar(String id, URL url)
	{
		this.id = id;
		this.url = url;
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
	
	public URL getUrl()
	{
		return url;
	}
	
	public void setUrl(URL url)
	{
		this.url = url;
	}
	
	public Date getCreatedTime()
	{
		return createdTime;
	}
}
