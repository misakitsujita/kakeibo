package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class GetNow {
	
	public String yearAndMonth() {
		LocalDate date = LocalDate.now();
		int y = date.getYear();
		String year = String.valueOf(y);
		int m = date.getMonthValue();
		String month = String.valueOf(m);
		String yearAndMonth = year + month;
		return yearAndMonth;
	}

}
