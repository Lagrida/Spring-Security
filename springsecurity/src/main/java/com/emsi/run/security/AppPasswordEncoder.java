package com.emsi.run.security;

import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.password.PasswordEncoder;

public class AppPasswordEncoder implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		String msgHashed="";
		try {
			msgHashed = MD5Encoder.encode(rawPassword.toString());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return msgHashed;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return (encode(rawPassword).equals(encodedPassword) ? true : false);
	}

}
