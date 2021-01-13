package com.company.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SlipController {

	/*@RequestMapping("/slip")
	@ResponseBody
	public Map<String, Object> slip(@RequestBody List<SlipVO> list, HttpServletResponse response) {
		System.out.println(list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("process", true);
		map.put("tcount", list.size());
		map.put("pcount", list.size());
		return map;
	}*/
	
	@RequestMapping("/slip")
	public ResponseEntity slip(@RequestBody List<SlipVO> list) {
		if(list.size()<1) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}else {
			System.out.println(list);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("process", true);
			map.put("tcount", list.size());
			map.put("pcount", list.size());
			return ResponseEntity.status(HttpStatus.OK).body(map);
		}
	}
	
	@RequestMapping("/slip3")
	public void slip3() {
		
	}
}
