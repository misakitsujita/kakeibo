package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domein.AdminUser;

@Repository
public class AdminUserRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private final static RowMapper<AdminUser> ADMIN_USER_ROWMAPPER = (rs, i) -> {
		AdminUser adminUser = new AdminUser();
		adminUser.setId(rs.getInt("id"));
		adminUser.setName(rs.getString("name"));
		adminUser.setPassword(rs.getString("password"));
		return adminUser;
	};
	
	/**
	 * 主キー検索.
	 * @param id　主キー
	 * @return　検索結果１件
	 */
	public List<AdminUser> load(Integer id){
		String sql="SELECT id,name,password FROM admin_users WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		List<AdminUser> userList = template.query(sql, param,ADMIN_USER_ROWMAPPER);
		return userList;
	}
	
	/**
	 * 全件検索.
	 * @return　検索結果
	 */
	public List<AdminUser> findAll(){
		String sql="SELECT id,name,password FROM admin_users";
		List<AdminUser> userList = template.query(sql,ADMIN_USER_ROWMAPPER);
		return userList;
	}
	
	/**
	 * ユーザログイン時用、ユーザ名検索.
	 * @param name　ユーザ名
	 * @return　検索結果
	 */
	public List<AdminUser> findByName(String name){
		String sql="SELECT id,name,password FROM admin_users WHERE name = :name";
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", name);
		List<AdminUser> userList = template.query(sql, param,ADMIN_USER_ROWMAPPER);
		return userList;
	}
	
	/**
	 *	管理者登録用.
	 * @param adminUser　登録する管理者　
	 */
	public void save(AdminUser adminUser){
		SqlParameterSource param = new BeanPropertySqlParameterSource(adminUser);
		
		if(adminUser.getId()==null){
			String insert = "INSERT INTO admin_users(name,password) VALUES(:name,:password)";
			template.update(insert,param);
		}else{
			String update = "UPDATE admin_users SET name=:name,password=:password";
			template.update(update,param);
		}
	}
}
