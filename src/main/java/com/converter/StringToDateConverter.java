package com.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * @author 作者：roll27
 * @version 创建时间：2017年11月7日下午3:41:56 类说明
 */

public class StringToDateConverter implements Converter<String, Date> {

	private String datePattern;

	public StringToDateConverter(String datePattern) {
		this.datePattern = datePattern;
		System.out.println("instantiating....converter with pattern：*" + datePattern);
	}

	@Override
	public Date convert(String s) {
		// TODO Auto-generated method stub
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
			dateFormat.setLenient(false);
			return dateFormat.parse(s);
		} catch (ParseException e) {
			// TODO: handle exception
			throw new IllegalArgumentException("invalid date format. Please use this pattern\"" + datePattern + "\"");
		}
	}

}
