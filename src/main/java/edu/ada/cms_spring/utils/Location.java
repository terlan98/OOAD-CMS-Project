package edu.ada.cms_spring.utils;

//TODO add to CD
public class Location
{
	private Long xCoordinate;
	private Long yCoordinate;
	
	public Location(Long xCoordinate, Long yCoordinate)
	{
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	
	public Long getxCoordinate()
	{
		return xCoordinate;
	}
	
	public void setxCoordinate(Long xCoordinate)
	{
		this.xCoordinate = xCoordinate;
	}
	
	public Long getyCoordinate()
	{
		return yCoordinate;
	}
	
	public void setyCoordinate(Long yCoordinate)
	{
		this.yCoordinate = yCoordinate;
	}
}
