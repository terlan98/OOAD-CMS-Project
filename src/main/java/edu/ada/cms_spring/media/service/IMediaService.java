package edu.ada.cms_spring.media.service;

import edu.ada.cms_spring.media.DTO.MediaListDTO;
import edu.ada.cms_spring.media.SMedia;

import java.util.List;

public interface IMediaService {
	
	/**
	 * Returns all media that is available for the user
	 */
	List<MediaListDTO> findAll();

}
