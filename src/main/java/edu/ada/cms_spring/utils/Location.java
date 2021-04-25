package edu.ada.cms_spring.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//TODO add to CD
@Entity @Data
@NoArgsConstructor
public class Location
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long xCoordinate;
	private Long yCoordinate;
	
	public Location(Long xCoordinate, Long yCoordinate)
	{
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
}
