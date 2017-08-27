package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domein.Category;

@Repository
public class CategoryRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Category> CATEGORY_ROWMAPPER = (rs, i) -> {
		Category category = new Category();
		category.setId(rs.getInt("id"));
		category.setCategory(rs.getString("category"));
		return category;
	};
	
	/**
	 * 主キー検索.
	 * @param id
	 * @return
	 */
	public List<Category> load(Integer id){
		String sql ="SELECT id,category FROM categories WHERE id=:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		List<Category> categoryList = template.query(sql, param,CATEGORY_ROWMAPPER);
		return categoryList;
	}

	/**
	 * 全件検索.
	 * @return
	 */
	public List<Category> findAll(){
		String sql ="SELECT id,category FROM categories";
		List<Category> categoryList = template.query(sql, CATEGORY_ROWMAPPER);
		return categoryList;
	}
	/**
	 * カテゴリー名から検索する.
	 * @param category
	 * @return
	 */
	public List<Category> findByCategory(String category) {
		String sql = "SELECT id,category FROM categories WHERE category=:category";
		SqlParameterSource param = new MapSqlParameterSource().addValue("category", category);
		List<Category> categoryList = template.query(sql, param, CATEGORY_ROWMAPPER);
		return categoryList;
	}

}
