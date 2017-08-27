package com.example.demo.domein;

import java.util.Date;

public class Payment {
	
	private Integer id;
	
	private Integer userId;
	
	private Integer categoryId;
	
	private Integer payment;
	
	private Date date;

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
