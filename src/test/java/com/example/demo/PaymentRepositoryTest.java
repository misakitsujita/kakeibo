package com.example.demo;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domein.Payment;
import com.example.demo.repository.PaymentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentRepositoryTest {
	@Autowired
	PaymentRepository paymentRepository;

//	@Test
//	public void insertTest() {
//		Payment payment = new Payment();
//		payment.setUserId(1);
//		payment.setCategoryId(1);
//		payment.setPayment(1000);
//		Date date = new Date();
//		payment.setDate(date);
//		paymentRepository.save(payment);
//	}
//
//	@Test
//	public void updateTest() {
//		Payment payment = new Payment();
//		payment.setId(1);
//		payment.setUserId(2);
//		payment.setCategoryId(2);
//		payment.setPayment(2000);
//		Date date = new Date();
//		payment.setDate(date);
//		paymentRepository.save(payment);
//	}

	@Test
	public void loadTest() {
		System.out.println(paymentRepository.load(1));
	}

	@Test
	public void findAllTest() {
		System.out.println(paymentRepository.findAll());
	}

	@Test
	public void findByUserIdTest() {
		System.out.println(paymentRepository.findByUserId(1));
	}

	@Test
	public void findByCategoryIdTest() {
		System.out.println(paymentRepository.findByCategoryId(1));
	}
}
