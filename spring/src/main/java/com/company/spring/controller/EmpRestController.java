package com.company.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.spring.dao.Emp;
import com.company.spring.dao.EmpMapper;
import com.company.spring.dao.EmpSearch;

@RestController //모든 요청이 json or xml, Controller + ResponseBody 
public class EmpRestController {
	@Autowired EmpMapper dao;
	
	
	@RequestMapping("/ajax/empSelect")
	public List<Emp> empSelect(EmpSearch emp){
		return dao.getEmpList(emp);
	}
}
