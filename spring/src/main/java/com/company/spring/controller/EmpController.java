package com.company.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.company.spring.dao.Emp;
import com.company.spring.dao.EmpMapper;
import com.company.spring.dao.EmpSearch;
import com.company.spring.dao.Jobs;

@Controller
public class EmpController {
	@Autowired
	EmpMapper dao;
//	//get ,post상관없이 요청처리
//	@RequestMapping(value = "/empSelect",method = RequestMethod.GET) 
//	public String select(Model model, EmpSearch emp) {
//		//조회
//		model.addAttribute("list", dao.getEmpList(emp));
//		return "emp/select"; //view 페이지를 넘겨줌
//	}
	@RequestMapping("/ajax/jobSelect")
	@ResponseBody //java를 json 구조로 변경
	public List<Jobs> jobSelect(){
		return dao.jobSelect();
	}
	
		//ModelAndView 실습예제
		@RequestMapping(value = "/empSelect",method = RequestMethod.GET) 
		public ModelAndView select(EmpSearch emp) {
			//조회
			ModelAndView mav = new ModelAndView();
			mav.addObject("list", dao.getEmpList(emp)); //넘길객체 
			mav.setViewName("emp/select"); // view페이지
			return mav; //model과 view 페이지를 같이 넘겨줌
		}
	
	@GetMapping("/empinsertForm") //request, response 를 쓰지않고 그냥 통일해서 model로 쓰는듯
	public String insertForm(Model model, Emp emp) { //커멘드객체 (Emp emp)  -vo값을 받을때
		model.addAttribute("jobs",dao.jobSelect()); //넘길값을 model에 담는다.
		model.addAttribute("depts", dao.deptSelect());
		return "emp/Insert"; //model값을 담아서 emp/Insert 페이지 리턴, 컨트롤러 읽는곳은 MvcContifuration
	}
	@GetMapping("/empUpdateForm")
	public String updateForm(Model model, Emp emp) {
		model.addAttribute("emp",dao.getEmp(emp));
		model.addAttribute("jobs",dao.jobSelect());
		model.addAttribute("depts", dao.deptSelect());
		return "emp/Insert";
	}
	
	@PostMapping("/empInsert") //등록수정같이
	public String insert(@ModelAttribute("employee") Emp emp) {
		if(emp.getEmployeeId()==null)
			dao.insertEmp(emp);
		else
			dao.updateEmp(emp);
		//request.setAttribute("emp",emp); //커멘드객체는 자동으로속성으로 저장됨
		return "emp/insertOutput";
	}
	/*
	 * @PostMapping("/empInsert") 
	 * public String insert(HttpServletRequest request,
	 * 
	 * @RequestParam(value="lastName", required = false, defaultValue = "noname" )
	 * String lName,
	 * 
	 * @RequestParam(value="salary", required = false) int sal,
	 * 
	 * Emp emp) { //책 275,280참조 //파라미터 String firstName =
	 * request.getParameter("firstName");
	 * System.out.println(lName+":"+firstName+":"+sal);
	 * System.out.println("emp\n"+emp); //등록처리 //redirect return
	 * "redirect:/empSelect"; }
	 */
}
