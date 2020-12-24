package com.company.spring.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.company.spring.dao.Emp;

public class EmpValidator implements Validator{
	final static String emailRegExp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
	private Pattern pattern;
	
	public EmpValidator() {
		pattern = Pattern.compile(emailRegExp);
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return Emp.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {//target==검사할대상
		Emp emp = (Emp)target;
		if(emp.getLastName() ==null || emp.getLastName().trim().isEmpty()) {
			errors.rejectValue("lastName", "required", new Object[] {"lastName"},"");//검사대상,에러코드,에러메세지
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobId", "required", new Object[] {"jobId"},"");
		//이메일형식(@.)
		if(emp.getEmail()==null||emp.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required", new Object[] {"email"},"");//검사대상,에러코드,에러메세지
		}else {
			Matcher matcher = pattern.matcher(emp.getEmail());
			if(! matcher.matches()) {
				errors.rejectValue("email", "bad");//검사대상,에러코드,에러메세지
			}
		}
	}

}
