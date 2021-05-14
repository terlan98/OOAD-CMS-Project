package edu.ada.cms_spring.auth.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationModel implements Serializable
{
	private String name;
	private String email;
	private String password;
}
