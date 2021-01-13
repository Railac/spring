package com.company.spring.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.company.spring.dao.EmpMapper;

@Controller
public class ExcelPdfController {

	@Autowired
	EmpMapper dao;
	
	// 엑셀출력
	@RequestMapping("/deptExcelView.do")
	public ModelAndView excelView(HttpServletResponse response) throws IOException {
		List<Map<String, Object>> list = dao.getStatDept();
		HashMap<String, Object> map = new HashMap<String, Object>();
		String[] header = { "dept_id","dept_name", "CNT" };
		map.put("headers", header);
		map.put("filename", "excel_dept");
		map.put("datas", list);
		return new ModelAndView("commonExcelView", map); //commonExcelView --> view 클래스명 맨앞에 글자 소문자
	}
}
