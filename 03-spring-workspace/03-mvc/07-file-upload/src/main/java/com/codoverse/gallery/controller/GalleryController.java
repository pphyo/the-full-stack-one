package com.codoverse.gallery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.codoverse.gallery.service.GalleryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class GalleryController {
	
	private final GalleryService service;
	
	@GetMapping
	public String handleShowGallery(Model model) {
		model.addAttribute("images", service.getAllImages());
		return "gallery";
	}
	
	@PostMapping("/upload")
	public String handleUploadImage(MultipartFile file) {

		if(!file.isEmpty()) {
			service.uploadImage(file);
		}

		return "redirect:/";
	}

}
