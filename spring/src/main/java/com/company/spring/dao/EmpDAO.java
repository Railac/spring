package com.company.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //빈등록
public class EmpDAO {
	@Autowired DataSource ds;
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	final String SELECT ="select * from employees";
	final String INSERT = " insert into employee( "
			+" EMPLOYEE_ID, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID)"
			+" values(?,?,?,SYSDATE, 'IT_PROG')";
	
	public void insert(Emp emp) {
		try {
			conn=ds.getConnection();
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1,  emp.getEmployeeId());
			pstmt.setString(2, emp.getLastName());
			pstmt.setString(3, emp.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public ArrayList<Emp> getList(){
		ArrayList<Emp> list = new ArrayList<Emp>();
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SELECT);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Emp emp = new Emp();
				emp.setEmployeeId(rs.getString("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				
				list.add(emp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
