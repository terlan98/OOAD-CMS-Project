package edu.ada.cms_spring.media.service;

import edu.ada.cms_spring.media.DTO.MediaListDTO;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Provides media-related services. Expects all video files to be located under 'resources/video'.
 */
public class MediaService implements IMediaService {
	@Override
	public List<MediaListDTO> findAll() {

		var list = new ArrayList<MediaListDTO>();

		try (var paths = Files.walk(Paths.get(ClassLoader.getSystemResource("video").toURI()))) {
			paths
					.filter(Files::isRegularFile)
					.forEach(p -> {
//						var file = new MediaInfoFile(p.toString());
//
//						if (file.open()) {
//							System.out.println("a");
//						}

						var title = p.getFileName().toString().split("\\.")[0];
//						var duration = file.info("Video;%Duration/String3%").split("\\.")[0];
						var duration = "10:00";
						
						list.add(new MediaListDTO(title, duration, title, title));

//						file.close();
					});
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}

		list.sort(Comparator.comparing(MediaListDTO::title));
		return list;
	}
}