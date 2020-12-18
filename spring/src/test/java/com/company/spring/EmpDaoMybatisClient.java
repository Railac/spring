package com.company.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.spring.config.DBConfiguration;
import com.company.spring.config.MybatisConfiguration;
import com.company.spring.dao.EmpDAOMybatis;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DBConfiguration.class, MybatisConfiguration.class } )
public class EmpDaoMybatisClient {
	@Autowired EmpDAOMybatis empDAO;
	
	@Test
	public void test() {
		System.out.println(empDAO.getEmpList());
	}
}
