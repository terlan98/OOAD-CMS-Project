package edu.ada.cms_spring.media.controller;

import edu.ada.cms_spring.auth.service.AuthService;
import edu.ada.cms_spring.media.service.MediaService;
import edu.ada.cms_spring.media.service.VideoStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/media")
public class MediaController
{
	private final MediaService mediaService;
	private final VideoStreamService videoStreamService;
	
	@Autowired
	private AuthService authService;
	
	public MediaController()
	{
		this.mediaService = new MediaService();
		this.videoStreamService = new VideoStreamService();
	}
	
	@GetMapping
	String showAll(Model model)
	{
		if (authService.isSessionExpired()) return "redirect:/"; //TODO UNCOMMENT
		
		var mediaList = mediaService.findAll();
		model.addAttribute("media", mediaList);
		
		return "media";
	}
	
	@GetMapping("/playback/{fileType}/{fileName}")
	public Mono<ResponseEntity<byte[]>> streamVideo(@RequestHeader(value = "Range", required = false) String httpRangeList,
	                                                @PathVariable("fileType") String fileType,
	                                                @PathVariable("fileName") String fileName)
	{
		
		return Mono.just(videoStreamService.prepareContent(fileName, fileType, httpRangeList));
	}
}