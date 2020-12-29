package com.company.spring.emp.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.spring.dao.Departments;
import com.company.spring.dao.Emp;
import com.company.spring.dao.EmpMapper;
import com.company.spring.dao.EmpSearch;
import com.company.spring.dao.Jobs;
import com.company.spring.emp.service.EmpService;

@Service //1
public class EmpServiceImpl implements EmpService{

	@Autowired //2
	EmpMapper dao;
	
	@Override
	public List<Emp> getEmpList(EmpSearch emp) {
		return dao.getEmpList(emp);
	}

	@Override
	public int updateEmp(Emp emp) {
		return dao.updateEmp(emp);
	}

	@Override
	public Emp getEmp(Emp emp) {
		return dao.getEmp(emp);
	}

	@Override
	public int insertEmp(Emp emp) {
		return dao.insertEmp(emp);
	}

	@Override
	public int insertEmpProc(Emp emp) {
		return dao.insertEmpProc(emp);
	}

	@Override
	public int deleteEmp(Emp emp) {
		return dao.deleteEmp(emp);
	}

	@Override
	public int deleteMultiEmp(EmpSearch emp) {
		return dao.deleteMultiEmp(emp);
	}

	@Override
	public int getCount() {
		return dao.getCount();
	}

	@Override
	public List<Map<String, Object>> getStatDept() {
		return dao.getStatDept();
	}

	@Override
	public List<Jobs> jobSelect() {
		return dao.jobSelect();
	}

	@Override
	public List<Departments> deptSelect() {
		return dao.deptSelect();
	}

}
