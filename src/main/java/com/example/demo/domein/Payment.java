package com.example.demo.domein;

import java.sql.Date;
import java.sql.Timestamp;

public class Payment {
	
	private Integer id;
	
	private Integer userId;
	
	private Integer categoryId;
	
	/** 支出 */
	private Integer payment;
	
	/** 日付 */
	private Date date;
	
	private Integer month;
	private Integer day;
	
	/** カテゴリー */
	private String category;
	
	/** 支出合計 */
	private Integer sum;
	
	/** 収入 */
	private Integer income;
	
	
	
	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getIncome() {
		return income;
	}

	public void setIncome(Integer income) {
		this.income = income;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getPayment() {
		return payment;
	}

	public void setPayment(Integer payment) {
		this.payment = payment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", userId=" + userId + ", categoryId=" + categoryId + ", payment=" + payment
				+ ", date=" + date + ", category=" + category + ", sum=" + sum + ", income=" + income + "]";
	}	

}
