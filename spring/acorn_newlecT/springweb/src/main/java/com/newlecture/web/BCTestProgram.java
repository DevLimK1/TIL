package com.newlecture.web;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCTestProgram {
	public static void main(String[] args) {
	
		String pwdString="111";
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		
		for(int i=0;i<5;i++) {
			String encoded=encoder.encode(pwdString);
			System.out.println(encoded);
			boolean result=encoder.matches(pwdString, encoded);
			
			System.out.println(result);
		}
	}
}
