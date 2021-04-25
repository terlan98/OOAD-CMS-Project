package edu.ada.cms_spring.auth;

import edu.ada.cms_spring.auth.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity @Data
@NoArgsConstructor
public class Token
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private User user;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	@Temporal(TemporalType.TIME)
	private Date dateExpires;
	
	@ElementCollection
	private final List<String> asks = new ArrayList<>(1);
	
	public Token(User user, Date dateCreated, Date dateExpires)
	{
		this.user = user;
		this.dateCreated = dateCreated;
		this.dateExpires = dateExpires;
	}
}
