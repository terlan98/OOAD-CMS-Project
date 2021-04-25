package edu.ada.cms_spring.comment;

import edu.ada.cms_spring.auth.model.User;
import lombok.Data;

import java.util.Date;

@Data
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
	
	public Comment edit(String message, User user)
	{
		this.message = message;
		this.editedBy = user;
		this.dateUpdated = new Date();
		return this;
	}
	
	public Comment delete()
	{
		return this;
		//TODO delete from DB
	}
}
