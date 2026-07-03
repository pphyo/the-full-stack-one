package com.codoverse.cors.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codoverse.cors.entity.Player;
import com.codoverse.cors.repository.PlayerRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PlayerService {
	
	private final PlayerRepository repository;

	public int createPlayer(Player player) {
		return repository.create(player);
	}
	
	public void updatePlayer(Player player) {
		repository.update(player);
	}
	
	public void delete(Integer id) {
		repository.delete(id);
	}
	
	public Player findById(Integer id) {
		return repository.findById(id);
	}
	
	public List<Player> search(String name, Double wage) {
		return repository.search(name, wage);
	}
	
}
