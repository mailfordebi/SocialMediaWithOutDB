package com.sm.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class DateComarator implements Comparator<ArrayList<String>> {
	public int compare(ArrayList<String> list1, ArrayList<String> list2) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		Date date1 = null;
		Date date2 = null;
		try {
			date1 = formatter.parse(list1.get(3));
			date2 = formatter.parse(list2.get(3));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date1.compareTo(date2);
	}

}