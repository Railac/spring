package com.dbal.app.emp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dbal.app.emp.UsersVO;
import com.dbal.app.emp.mapper.EmpMapper;

@Service("authService")
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	EmpMapper dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsersVO vo = new UsersVO();
		vo.setLoginId(username);
		vo = dao.getUser(vo); // 사용자가 존재하지 않는 경우
		
		if (vo == null) {
			throw new UsernameNotFoundException("no user");
		}
		
		//권한 지정
		List<GrantedAuthority> auth = new ArrayList<>();
		List<String> roles = dao.getAuth(vo);
		auth.add(new SimpleGrantedAuthority(roles.get(0)));
		vo.setAuthlist(auth);
		
		//User 객체 return
		return vo;
	}
}
