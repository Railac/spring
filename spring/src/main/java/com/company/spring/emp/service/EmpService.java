package com.company.spring.emp.service;

import java.util.List;
import java.util.Map;

import com.company.spring.dao.Departments;
import com.company.spring.dao.Emp;
import com.company.spring.dao.EmpSearch;
import com.company.spring.dao.Jobs;

public interface EmpService {
	public List<Emp> getEmpList(EmpSearch emp);
	public int updateEmp(Emp emp);
	public Emp getEmp(Emp emp);
	public int insertEmp(Emp emp);
	public int insertEmpProc(Emp emp);
	public int deleteEmp(Emp emp);
	public int deleteMultiEmp(EmpSearch emp);
	public int getCount();
	public List<Map<String, Object>> getStatDept();
	public List<Jobs> jobSelect();
	public List<Departments> deptSelect();
}
