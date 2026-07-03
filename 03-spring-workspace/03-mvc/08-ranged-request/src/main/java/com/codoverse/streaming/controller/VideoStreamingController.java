package com.codoverse.streaming.controller;

import java.io.File;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VideoStreamingController {
	
	@GetMapping("/youtube")
	public String handleshowPlayer() {
		return "video-player";
	}
	
	@GetMapping(value = "/api/video", produces = "video/mp4")
	@ResponseBody
	public ResponseEntity<Resource> handleStreamVideo(@RequestHeader(value = HttpHeaders.RANGE, required = false) String rangedHeader) {
		IO.println(rangedHeader);
		File videoFile = new File("/Users/macbookprom2/Downloads/Aandhadhum.mp4");
		Resource resource = new FileSystemResource(videoFile);
		return ResponseEntity.ok(resource);
	}

}
