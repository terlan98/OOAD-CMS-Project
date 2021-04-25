package edu.ada.cms_spring.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity @Data
@NoArgsConstructor
public class Location
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Double xCoordinate;
	private Double yCoordinate;
	
	public Location(Double xCoordinate, Double yCoordinate)
	{
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
}
