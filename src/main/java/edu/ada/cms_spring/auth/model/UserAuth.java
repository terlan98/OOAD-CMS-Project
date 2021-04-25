package edu.ada.cms_spring.auth.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity @Data
@NoArgsConstructor
public class UserAuth
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long userId;
	private String primaryEmail;
	private String password;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;
	
	@ElementCollection
	private final List<String> emails = new ArrayList<>(1);
	
	@OneToMany
	private final List<LoginAttempt> logins = new ArrayList<>(1);
	
	public UserAuth(Long id, Long userId, String primaryEmail, String password)
	{
		this.id = id;
		this.userId = userId;
		this.createdTime = new Date();
		this.primaryEmail = primaryEmail;
		this.password = password;
	}
}
