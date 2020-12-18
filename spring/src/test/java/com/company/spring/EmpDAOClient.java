package com.company.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.spring.config.DBConfiguration;
import com.company.spring.dao.EmpDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DBConfiguration.class } )
public class EmpDAOClient {
	
	@Autowired EmpDAO empDAO; //등록된 빈을 가져옴
	@Test
	public void test() {
		System.out.println(empDAO.getList());
	}
}
