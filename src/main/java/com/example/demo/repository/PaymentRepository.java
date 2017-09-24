package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domein.Payment;

@Repository
public class PaymentRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	private final static RowMapper<Payment> PAYMENT_ROWMAPPER = (rs, i) -> {
		Payment payment = new Payment();
		payment.setId(rs.getInt("id"));
		payment.setUserId(rs.getInt("user_id"));
		payment.setCategoryId(rs.getInt("category_id"));
		payment.setPayment(rs.getInt("payment"));
		payment.setDate(rs.getString("date")); //TODO:date型で管理できるように
		return payment;
	};
	
	/**
	 * 支出一覧表示（join）用
	 */
	private final static RowMapper<Payment> PAYMENTLIST_ROWMAPPER = (rs, i) -> {
		Payment payment = new Payment();
		payment.setPayment(rs.getInt("payment"));
		payment.setDate(rs.getString("date")); //TODO:date型で管理できるように
		payment.setCategory(rs.getString("category"));
		return payment;

	};

	/**
	 * 主キー検索.
	 * 
	 * @param id
	 *            主キー
	 * @return 検索結果１件
	 */
	public List<Payment> load(Integer id) {
		String sql = "SELECT id,user_id,category_id,payment,date FROM payments WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		List<Payment> paymentList = template.query(sql, param, PAYMENT_ROWMAPPER);
		return paymentList;
	}

	/**
	 * 全件検索.
	 * 
	 * @return 検索結果
	 */
	public List<Payment> findAll() {
		String sql = "SELECT id,user_id,category_id,payment,date FROM payments";
		List<Payment> paymentList = template.query(sql, PAYMENT_ROWMAPPER);
		return paymentList;
	}

	/**
	 * ユーザ別検索.
	 * 
	 * @param userId
	 *            ユーザID
	 * @return 検索結果 複数件
	 */
	public List<Payment> findByUserId(Integer userId) {
		String sql = "SELECT date,category,payment from payments INNER JOIN categories ON payments.category_id=categories.id WHERE user_id = :userId ORDER BY date DESC";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId", userId);
		List<Payment> paymentList = template.query(sql, param, PAYMENTLIST_ROWMAPPER);
		return paymentList;
	}
//	public List<Payment> findByUserId(Integer userId) {
//		String sql = "SELECT id,user_id,category_id,payment,date FROM payments WHERE user_id = :userId";
//		SqlParameterSource param = new MapSqlParameterSource().addValue("userId", userId);
//		List<Payment> paymentList = template.query(sql, param, PAYMENT_ROWMAPPER);
//		return paymentList;
//	}
	
	

	/**
	 * カテゴリ別検索.
	 * 
	 * @param categoryId
	 *            カテゴリID
	 * @return 検索結果 複数件
	 */
	public List<Payment> findByCategoryId(Integer categoryId) {
		String sql = "SELECT id,user_id,category_id,payment,date FROM payments WHERE category_id = :categoryId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("categoryId", categoryId);
		List<Payment> paymentList = template.query(sql, param, PAYMENT_ROWMAPPER);
		return paymentList;
	}

	/**
	 * 支出登録.
	 * 
	 * @param payment
	 */
	public void savePayment(Payment payment) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(payment);
		// if(payment.getId()==null){
		String insert = "INSERT INTO payments(user_id,category_id,payment,date) VALUES(:userId,:categoryId,:payment,:date)";
		template.update(insert, param);
		// }else{
		// String update = "UPDATE payments SET
		// user_id=:userId,category_id=:categoryId,payment=:payment,date=:date
		// WHERE id=:id";
		// template.update(update,param);
		// }
	}
}
