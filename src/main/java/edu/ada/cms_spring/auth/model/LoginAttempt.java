package edu.ada.cms_spring.auth.model;


import edu.ada.cms_spring.auth.PrivilegeLevel;
import edu.ada.cms_spring.utils.Location;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity @Data
@NoArgsConstructor
public class LoginAttempt
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@ManyToOne
	private Location location;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;
	
	@Enumerated(EnumType.STRING)
	private PrivilegeLevel level;
	
	@OneToOne
	private UserAuth auth;
	
	public LoginAttempt(String id, Location location, PrivilegeLevel level, UserAuth auth)
	{
		this.id = id;
		this.location = location;
		this.level = level;
		this.auth = auth;
		this.createdTime = new Date();
	}
}
