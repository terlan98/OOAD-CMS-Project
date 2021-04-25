package edu.ada.cms_spring.comment;

import edu.ada.auth.User;

import java.util.Date;

public class Comment
{
	private Date dateUpdated;
	private String message;
	private User editedBy;
	
	private final User user;
	private final Date dateCreated;
	
	public Comment(User user, String message)
	{
		this.user = user;
		this.message = message;
		this.dateCreated = new Date();
		this.dateUpdated = new Date();
		this.editedBy = user;
	}
	
	//TODO Why should it return a Comment object?
	//TODO I added a User parameter
	public void edit(String message, User user)
	{
		this.message = message;
		this.editedBy = user;
		this.dateUpdated = new Date();
	}
	
	//TODO Why should it return a Comment object?
	public void delete()
	{
		//TODO delete from DB
	}
	
	public User getUser()
	{
		return user;
	}
	
	public Date getDateCreated()
	{
		return dateCreated;
	}
	
	public Date getDateUpdated()
	{
		return dateUpdated;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public User getEditedBy()
	{
		return editedBy;
	}
}
