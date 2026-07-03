package com.codoverse.cors.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.codoverse.cors.entity.Player;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PlayerRepository {
	
	private final JdbcTemplate jdbc;
	
	@SuppressWarnings("unused")
	private final RowMapper<Player> rowMapper = (rs, rowNum) -> {
		Player player = new Player();
		player.setId(rs.getInt("id"));
		player.setName(rs.getString("name"));
		player.setDob(rs.getDate("dob").toLocalDate());
		player.setWage(rs.getDouble("wage"));
		player.setHeight(rs.getDouble("height"));
		player.setShirt(rs.getInt("shirt"));
		return player;
	};
	
	public int create(Player player) {
		final String INSERT = "insert into players(name, dob, wage, height, shirt) values (?, ?, ?, ?, ?)";
		return jdbc.update(INSERT, player.getName(), player.getDob(), player.getWage(), player.getHeight(), player.getShirt());
	}
	
	public void update(Player player) {
		jdbc.update("UPDATE players set name = ?, dob = ?, wage = ?, height = ?, shirt = ? where id = ?", player.getName(), player.getDob(), player.getWage(), player.getHeight(), player.getShirt(), player.getId());
	}
	
	public void delete(Integer id) {
		jdbc.update("DELETE FROM players WHERE id = ?");
	}
	
	public Player findById(Integer id) {
		var list = jdbc.query("SELECT * FROM players WHERE id = ?", rowMapper, id);
		return list.isEmpty() ? null : list.get(0);
	}
	
	public List<Player> search(String name, Double wage) {
		StringBuilder sql = new StringBuilder("SELECT * FROM players WHERE 1 = 1");
		List<Object> params = new ArrayList<>();
		
		if(name != null && !name.trim().isBlank()) {
			sql.append(" AND name LIKE ?");
			params.add("%" + name + "%");
		}
		if(wage != null) {
			sql.append(" AND wage >= ?");
			params.add(wage);
		}
		
		return jdbc.query(sql.toString(), rowMapper, params.toArray());
	}
	
}
