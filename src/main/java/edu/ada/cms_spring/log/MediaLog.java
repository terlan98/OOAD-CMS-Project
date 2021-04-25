package edu.ada.cms_spring.log;

import edu.ada.cms_spring.media.Media;

public class MediaLog extends Log
{
	private Media media;
	
	public MediaLog(String id, String message, Media media)
	{
		super(id, message);
		this.media = media;
	}
	
	public Media getMedia()
	{
		return media;
	}
	
	public void setMedia(Media media)
	{
		this.media = media;
	}
}
