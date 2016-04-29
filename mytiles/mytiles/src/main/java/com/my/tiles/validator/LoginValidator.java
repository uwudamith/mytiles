package com.my.tiles.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.my.tiles.forms.LoginForm;

public class LoginValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		 return LoginForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LoginForm loginForm = (LoginForm) target;
		
		if(loginForm.getEmail() == null || loginForm.getEmail().isEmpty()) {
	          errors.rejectValue("email", "email_error","email.error");
	      }
		
		if(loginForm.getPassword() == null || loginForm.getPassword().isEmpty()) {
	          errors.rejectValue("password", "password_error","password.error");
	      }
	}

}
