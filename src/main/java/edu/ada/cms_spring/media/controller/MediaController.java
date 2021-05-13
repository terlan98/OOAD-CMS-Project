package edu.ada.cms_spring.media.controller;

import edu.ada.cms_spring.auth.model.User;
import edu.ada.cms_spring.auth.model.dto.LoginModel;
import edu.ada.cms_spring.media.Media;
import edu.ada.cms_spring.media.SMedia;
import edu.ada.cms_spring.media.SpecialPermission;
import edu.ada.cms_spring.media.service.IMediaService;
import edu.ada.cms_spring.media.service.MediaService;
import edu.ada.cms_spring.media.service.VideoStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;

@Controller
@RequestMapping("/media")
public class MediaController {

	private final MediaService mediaService;
	private final VideoStreamService videoStreamService;

	public MediaController() {
		this.mediaService = new MediaService();
		this.videoStreamService = new VideoStreamService();
	}

	@GetMapping
	String showAll(Model model) {
		var mediaList = mediaService.findAll();
		model.addAttribute("media", mediaList);

		return "media";
	}

	@GetMapping("/playback/{fileType}/{fileName}")
	public Mono<ResponseEntity<byte[]>> streamVideo(@RequestHeader(value = "Range", required = false) String httpRangeList,
													@PathVariable("fileType") String fileType,
													@PathVariable("fileName") String fileName) {

		return Mono.just(videoStreamService.prepareContent(fileName, fileType, httpRangeList));
	}
}