package com.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

/**
 * @author 作者：roll27
 * @version 创建时间：2017年11月8日上午11:36:32
 * 类说明
 */
public class DateFormatter implements Formatter<Date>{
	
	private String datePattern;
	private SimpleDateFormat dateFormat;
	
	public DateFormatter(String datePattern) {
		// TODO Auto-generated constructor stub
		this.datePattern = datePattern;
		this.dateFormat = new SimpleDateFormat(datePattern);
		dateFormat.setLenient(false);
	}
	
	@Override
	public String print(Date date, Locale locale) {
		// TODO Auto-generated method stub
		return dateFormat.format(date);
	}

	@Override
	public Date parse(String s, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		try {
			return dateFormat.parse(s);
		} catch (ParseException e) {
			// TODO: handle exception
			throw new IllegalArgumentException("invalid date format1. Please use this pattern\"" + datePattern + "\"");
		}
	}
	
}
