package edu.ada.cms_spring.auth.model;

import edu.ada.cms_spring.auth.PrivilegeLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.net.URL;
import java.util.Date;

@Entity @Data
@NoArgsConstructor
@Table(name = "users")
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String name;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;
	
	private PrivilegeLevel level;
	
	@ManyToOne
	private UserAuth auth;
	
	@OneToOne
	private Avatar avatar;
	
	public User(String id, String name, PrivilegeLevel level, UserAuth auth, Avatar avatar)
	{
		this.id = id;
		this.name = name;
		this.level = level;
		this.auth = auth;
		this.avatar = avatar;
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
