package com.example.demo.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domein.User;

@Repository
public class UserRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private final static RowMapper<User> USER_ROWMAPPER = (rs, i) -> {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		return user;
	};
	
	/**
	 * idから検索を行う.
	 * @param id　主キー
	 * @return　userList
	 */
	public List<User> load(Integer id) {
		String sql = "SELECT id,name,password FROM users WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		List<User> userList = template.query(sql, param,USER_ROWMAPPER);
		return userList;
		
	}
	
	/**
	 * ユーザーログイン用のユーザー検索メソッド.
	 * @param name
	 * @param password
	 * @return
	 */
	public List<User> findByNameAndPassword(String name) {
		String sql = "SELECT id,name,password FROM users WHERE name = :name";
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", name);
		List<User> userList = template.query(sql, param,USER_ROWMAPPER);
		return userList;
	}

}
