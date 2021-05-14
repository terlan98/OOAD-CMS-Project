package edu.ada.cms_spring.auth.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.net.URL;
import java.util.Date;

@Entity @Data
@NoArgsConstructor
@Table(name = "users")
public class User
{
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	private String name;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	private PrivilegeLevel level;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;
	
//	@OneToOne
//	private Avatar avatar;
	
	public User(String name, String email, String password, PrivilegeLevel level)
	{
		this.name = name;
		this.email = email;
		this.password = password;
		this.level = level;
	}
	
	public User changeAvatar(URL url)
	{
		//TODO: fill
		return this;
	}
	
	public User setName(String name)
	{
		this.name = name;
		return this;
	}
}
