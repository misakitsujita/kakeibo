package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

/**
 * 日付取得クラス.
 * 
 * @author tsujitamisaki
 *
 */
@Service
public class GetNow {
	
	/**
	 * 現在の年月取得.
	 * @return　yearAndMonth
	 */
	public String yearAndMonth() {
		LocalDate date = LocalDate.now();
		int y = date.getYear();
		String year = String.valueOf(y);
		int m = date.getMonthValue();
		String month = String.valueOf(m);
		String yearAndMonth = year + month;
		return yearAndMonth;
	}
	
	/**
	 * 現在の年取得.
	 * @return year
	 */
	public String getYear() {
		LocalDate date = LocalDate.now();
		int y = date.getYear();
		String year = String.valueOf(y);
		return year;
	}

}
