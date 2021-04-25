package edu.ada.cms_spring.log;

import java.util.Date;

public class Log
{
	private String id;
	private String message;
	
	private final Date dateCreated;
	
	public Log(String id, String message)
	{
		this.id = id;
		this.dateCreated = new Date();
		this.message = message;
	}
	
	// create() function is omitted since it refers to the constructor
	
	public Log parse(String s)
	{
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
	
	public Date getDateCreated()
	{
		return dateCreated;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}
}
