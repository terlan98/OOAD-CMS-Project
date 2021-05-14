package edu.ada.cms_spring.utils;

import edu.ada.cms_spring.auth.model.dto.RegistrationModel;
import edu.ada.cms_spring.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * This class is for automatically adding some dummy data to the database.
 */
@Component
public class AppRunner implements ApplicationRunner
{
	@Autowired
	private AuthService authService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception
	{
//		System.out.println("APP Runner is up");
//		RegistrationModel model1 = new RegistrationModel("Tarlan", "tarlan@mail.com", "123");
//
//		if(authService.getUserByEmailAndPassword(model1.getEmail(), model1.getPassword()) == null)
//		{
//			authService.registerUser(model1);
//		}
	}
}