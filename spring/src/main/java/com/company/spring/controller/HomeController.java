package com.company.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.company.spring.dao.Emp;
import com.company.spring.dao.EmpMapper;
import com.company.spring.dao.EmpSearch;

@Controller
public class HomeController {
	@Autowired EmpMapper empMapper;
	
	@RequestMapping("/empListajax")
	@ResponseBody
	List<Emp> empListajax(EmpSearch emp){
		return empMapper.getEmpList(emp);
	}
	
	@RequestMapping("/empList")
	public String empList(Model model, EmpSearch emp) {//model --담는공간인
		model.addAttribute("list", empMapper.getEmpList(emp));
		return "emp/empList";
	}
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/adminmain")
	public String adminmain() {
		return "admin/main";
	}
}
