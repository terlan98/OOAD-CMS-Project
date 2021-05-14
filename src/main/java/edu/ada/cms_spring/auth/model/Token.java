package edu.ada.cms_spring.auth.model;

import edu.ada.cms_spring.auth.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity @Data
@NoArgsConstructor
public class Token
{
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	
	@OneToOne
	private User user;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	@Temporal(TemporalType.TIME)
	private Date dateExpires;
	
//	@ElementCollection
//	private final List<String> asks = new ArrayList<>(1);
	
	/**
	 * Creates a new Token
	 * @param user the user for which the token is being created
	 * @param lifeTime the lifetime, in seconds, of the created token
	 */
	public Token(User user, int lifeTime)
	{
		this.user = user;
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.SECOND, lifeTime);
		Date expDate =  cal.getTime();
		
		this.dateCreated = new Date();
		this.dateExpires = expDate;
	}
}
