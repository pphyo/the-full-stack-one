package com.codoverse.cors.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codoverse.cors.entity.Player;
import com.codoverse.cors.service.PlayerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/players")
public class PlayerController {
	
	private final PlayerService service;

	@PostMapping
	public ResponseEntity<String> handleCreate(@RequestBody Player player) {
		
		String response = """
				{
					"message": "Player created",
					"createdId": %d
				}
				""".formatted(service.createPlayer(player));
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.contentType(MediaType.APPLICATION_JSON)
				.body(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Player> handleFindById(@PathVariable Integer id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Player>> handleSearch(@RequestParam(required = false) String name, @RequestParam(required = false) Double wage) {
		return ResponseEntity.ok(service.search(name, wage));
	}
	
}
