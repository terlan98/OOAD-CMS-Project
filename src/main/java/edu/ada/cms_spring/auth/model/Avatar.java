package edu.ada.cms_spring.auth.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.net.URL;
import java.util.Date;

@Entity
@Data
public class Avatar
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private URL url;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;
	
	public Avatar(String id, URL url)
	{
		this.id = id;
		this.url = url;
	}
	
	public Avatar()
	{
		this.createdTime = new Date();
	}
}
