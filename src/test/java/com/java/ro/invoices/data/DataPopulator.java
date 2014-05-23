package com.java.ro.invoices.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import org.apache.commons.lang.time.DateUtils;

public class DataPopulator {

	public static void main(String[] args) {
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");	
		DateFormat df2 = new SimpleDateFormat("yyyy");
		Random r = new Random();
//		String insert = "INSERT INTO \"Invoices\".invoice( id, dateofissue, maturity, \"number\", totalamount) VALUES (10000, '1994-11-29', '1994-11-29', 'FV-2001-1', 2312.32);";
		String insert = "INSERT INTO \"Invoices\".invoice( id, dateofissue, maturity, \"number\", totalamount) VALUES (%s, '%s', '%s', '%s', %.2f);";
		DateUtils.addDays(new Date(), -1 * r.nextInt(10000));
		for (int i = 0; i < 1000; i++) {
			Date dateOfIssue = DateUtils.addDays(new Date(), -1 * r.nextInt(2000));
			Date dateOfMaturity = DateUtils.round(dateOfIssue, Calendar.MONTH);
			System.out.println(String.format(Locale.ENGLISH, insert, 100000 + i, df.format(dateOfIssue)
					, df.format(dateOfMaturity), "FK-"+df2.format(dateOfIssue)+"-"+i, (r.nextInt(10000) + r.nextFloat())));
		}
	}
}
