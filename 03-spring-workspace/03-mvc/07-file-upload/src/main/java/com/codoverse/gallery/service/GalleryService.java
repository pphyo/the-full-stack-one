package com.codoverse.gallery.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;

@Service
public class GalleryService {
	
	private final String UPLOAD_DIR = "./upload";
	
	public void uploadImage(MultipartFile file) {
		
		try {

			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR, file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<String> getAllImages() {
		try {
			return Files.list(Paths.get(UPLOAD_DIR))
					.map(path -> Path.of(UPLOAD_DIR, path.getFileName().toString()).toString())
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	@PostConstruct
	public void init() {
		try {
			Path path = Paths.get(UPLOAD_DIR);
			if(!Files.exists(path)) {
				Files.createDirectory(Paths.get(UPLOAD_DIR));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
