package com.example.demo.web;


import java.sql.Date;
import java.time.LocalDate;

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
	public String userInsert(String jsonUser) {
		userRepository.saveIncome(service.jsonToUser(jsonUser));
		return jsonUser;
	}

	/**
	 * JsonでPaymentを受け取り支出を登録する.
	 * 
	 * @param jsonPayment
	 */
	@RequestMapping("/insertPayment")
	@ResponseBody
	public String paymentInsert(String jsonPayment) {
		Payment payment = service.jsonToPayment(jsonPayment);
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
		//String json = service.paymenrToJson(paymentRepository.findByUserId(userId));
		//今月分のみ一覧表示
		LocalDate date = LocalDate.now();
		int y = date.getYear();
		String year = String.valueOf(y);
		int m = date.getMonthValue();
		String month = String.valueOf(m);
		String yearAndMonth = year + month;
		System.out.println(yearAndMonth);
		return service.paymenrToJson(paymentRepository.findByUserId(userId,yearAndMonth));
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
