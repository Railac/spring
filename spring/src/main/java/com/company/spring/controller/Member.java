package com.company.spring.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder //안쓰고 그냥 생성자쓰는거처럼쓰면됨
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	String id;
	String pw;
	String name;
}
