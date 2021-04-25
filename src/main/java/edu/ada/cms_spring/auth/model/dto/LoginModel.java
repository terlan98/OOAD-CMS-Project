package edu.ada.cms_spring.auth.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class LoginModel implements Serializable
{
	private String email;
	private String password;
}
