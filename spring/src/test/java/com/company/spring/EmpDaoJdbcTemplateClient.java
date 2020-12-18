package com.company.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.spring.config.DBConfiguration;
import com.company.spring.dao.Emp;
import com.company.spring.dao.EmpDAOJdbcTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DBConfiguration.class } )
public class EmpDaoJdbcTemplateClient {

	@Autowired EmpDAOJdbcTemplate empDAO; //등록된 빈을 가져옴
	@Test
	public void test() {
		System.out.println(empDAO.getListMap());
	}
	@Test
	public void insert() {
		Emp emp = new Emp();
		emp.setEmployeeId("5151");
		emp.setLastName("AAAA");
		emp.setEmail("df@vc.com");
		empDAO.insert(emp);
		
	}
}
