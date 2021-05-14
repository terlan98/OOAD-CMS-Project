package edu.ada.cms_spring.auth.service.impl;

import edu.ada.cms_spring.auth.service.HashService;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class HashServiceImpl implements HashService
{
	private MessageDigest md;
	
	public HashServiceImpl()
	{
		try
		{
			md = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the hashed version of the provided string. Uses SHA-512.
	 *
	 * @param string
	 * @return hashed string
	 */
	public String hash(String string)
	{
		byte[] hashedPassword = md.digest(string.getBytes(StandardCharsets.UTF_8));
		StringBuffer hashedString = new StringBuffer();
		
		for (int i = 0; i < hashedPassword.length; i++)
			hashedString.append(Integer.toString((hashedPassword[i] & 0xff) + 0x100, 16).substring(1));
		
		return hashedString.toString();
	}
}
