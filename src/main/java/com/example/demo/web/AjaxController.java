package com.example.demo.web;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domein.Payment;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AjaxService;

@Controller
@Transactional
@RequestMapping("/ajax")
public class AjaxController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private AjaxService service;

	/**
	 * JsonでUserを受け取り収入を登録する.
	 * 
	 * @param jsonUser
	 */
	@RequestMapping("/insertIncome")
	@ResponseBody
	public void userInsert(String jsonUser) {
		userRepository.saveIncome(service.jsonToUser(jsonUser));
	}

	/**
	 * JsonでPaymentを受け取り支出を登録する.
	 * 
	 * @param jsonPayment
	 */
	@RequestMapping("/insertPayment")
	@ResponseBody
	public String paymentInsert(String jsonPayment) {
		System.out.println("jsonPayment : " + jsonPayment);
		Payment payment = service.jsonToPayment(jsonPayment);
//		Date date = payment.getDate();
//		payment.setDate(date);
		System.out.println(payment);
		paymentRepository.savePayment(payment);
		return jsonPayment;
	}

	/**
	 * 支出一覧リストをJson型で返す.
	 * 
	 * @return
	 */
	@RequestMapping("/paymentFindAll")
	@ResponseBody
	public String paymentFindAll(Integer userId) {
		System.out.println("userId : " + userId);
		return service.paymenrToJson(paymentRepository.findByUserId(userId));
	}

	/**
	 * カテゴリー別支出合計リストをJson型で返す.
	 * 
	 * @param userId
	 * @return
	 */
	// @RequestMapping("/categoryGraph")
	// @ResponseBody
	// public String showCategoryGraph(Integer userId) {
	// return
	// service.paymenrToJson(paymentRepository.findBySumAndCategory(userId));
	// }

}
