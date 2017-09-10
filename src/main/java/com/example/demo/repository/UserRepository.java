package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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
		user.setIncome(rs.getInt("income"));
		return user;
	};

	/**
	 * 全件検索を行う.
	 * 
	 * @return
	 */
	public List<User> findAll() {
		String sql = "SELECT id,name,password,income FROM users ORDER BY id";
		List<User> userList = template.query(sql, USER_ROWMAPPER);
		return userList;
	}

	/**
	 * idから検索を行う.
	 * 
	 * @param id
	 *            主キー
	 * @return userList
	 */
	public List<User> load(Integer id) {
		String sql = "SELECT id,name,password,income FROM users WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		List<User> userList = template.query(sql, param, USER_ROWMAPPER);
		return userList;
	}

	/**
	 * ユーザーログイン用のユーザー検索メソッド.
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	public List<User> findByNameAndPassword(String name, String password) {
		String sql = "SELECT id,name,password,income FROM users WHERE name = :name AND password=:password";
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", name).addValue("password", password);
		List<User> userList = template.query(sql, param, USER_ROWMAPPER);
		return userList;
	}

	/**
	 * ユーザの登録、更新を行う.
	 * 
	 * @param user
	 */
	public void saveUser(User user) {
		if (user.getId() == null) {
			String sql = "INSERT INTO users (name,password) VALUES (:name,:password)";
			SqlParameterSource param = new BeanPropertySqlParameterSource(user);
			template.update(sql, param);
		} else {
			String sql = "UPDATE users SET name=:name, password=:password WHERE id = :id";
			SqlParameterSource param = new BeanPropertySqlParameterSource(user);
			template.update(sql, param);
		}
	}

	/**
	 * 収入を登録
	 */
	public void saveIncome(User user) {
		String sql = "UPDATE users SET income=:income WHERE id = :id";
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		template.update(sql, param);
	}

}
