package edu.ada.cms_spring.auth.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginModel implements Serializable
{
	private String email;
	private String password;
}
