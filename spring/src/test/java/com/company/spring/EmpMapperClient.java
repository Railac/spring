package com.company.spring;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.spring.config.DBConfiguration;
import com.company.spring.config.MybatisConfiguration;
import com.company.spring.dao.Emp;
import com.company.spring.dao.EmpMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DBConfiguration.class, MybatisConfiguration.class } )
public class EmpMapperClient {

	@Autowired EmpMapper empDAO;
	@Test
	public void getStat() {
		List<Map<String, Object>> list = empDAO.getStatDept();
		System.out.println(list.get(0));
	}
	@Test
	public void selectRecordTest() {
		int count = empDAO.getCount();
		System.out.println(count);
	}
//	@Test
//	public void deleteMultiTest() {
//		EmpSearch emp = new EmpSearch();
//		emp.setList(new String[] {"1000","1001"});
//		empDAO.deleteMultiEmp(emp);
//	}
//	@Test
//	public void insertTest() {
//		Emp emp = new Emp();
////		emp.setEmployeeId("1005");
//		emp.setFirstName("1006bun");
//		emp.setLastName("1006bun");
//		emp.setJobId("IT_PROG");
//		emp.setEmail("1006@na.com");
//		emp.setHireDate(new Date(System.currentTimeMillis()));
//		empDAO.insertEmp(emp);
//		System.out.println(emp.getEmployeeId());
//	}
//	@Test
//	public void insertTest() {
//		Emp emp = new Emp();
//		emp.setLastName("1010bun");
//		emp.setJobId("IT_PROG");
//		emp.setEmail("1010@na.com");
//		empDAO.insertEmpProc(emp);
//		System.out.println(emp.getEmployeeId()+":"+emp.getMsg());
//	}
//	@Test
//	public void testup() {
//		Emp empvo = new Emp();
//		empvo.setEmployeeId("333");
//		empvo.setFirstName("test1218");
//		int a = empDAO.updateEmp(empvo);
//		System.out.println("===성공==="+a);
//	}
//	@Test
//	public void testlist() {
//		Emp empvo = new Emp();
//		empvo.setEmployeeId("333");
//		Emp list = empDAO.getEmp(empvo);
//		System.out.println(list.getFirstName()+":"+list.getLastName());
//	}
	
	
//	@Test
//	public void test() {
//		EmpSearch empvo = new EmpSearch();
//		empvo.setFirstName("e");
////		empvo.setDepartmentId("90");
////		empvo.setSalary(10000);
//		empvo.setMinSalary(5000);
//		empvo.setMaxSalary(10000);
//		List<Emp> list = empDAO.getEmpList(empvo);
//		int sum =0;
//		for(Emp emp : list) {
//			sum++;
//			System.out.println(sum+":"+emp.getEmployeeId()+":"+emp.getFirstName()+":"+emp.getDepartmentId()+":"+emp.getJobId()+":"+emp.getSalary());
//		}
//	}
}
