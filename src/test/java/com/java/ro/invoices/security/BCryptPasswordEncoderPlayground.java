package com.java.ro.invoices.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderPlayground {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encode = encoder.encode("321");
		System.out.println(encode);
		
		System.out.println(encoder.matches("321", encode));
	}
}
