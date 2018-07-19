package com.Secure;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class SetCookie {
	
	public String getCookie() 
	{
		String jwt=null;
		try {
			jwt = Jwts.builder()
					  .setSubject("users/TzMUocMF4p")
					  .setExpiration(new Date(1300819380))
					  .claim("name", "vivek")
					  .claim("scope", "self groups/admins")
					  .signWith(SignatureAlgorithm.HS256,"vivek".getBytes("UTF-8"))
					  .compact();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jwt;
		
	}
}
