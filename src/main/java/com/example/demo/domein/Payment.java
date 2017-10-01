package com.example.demo.domein;

import java.sql.Date;

public class Payment {
	
	private Integer id;
	
	private Integer userId;
	
	private Integer categoryId;
	
	private Integer payment;
	
	private Date date;
	
	private String category;
	
	private Integer sum;

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
				+ ", date=" + date + "]";
	}
	
	
	
	

}
