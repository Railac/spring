<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 톱 페이지입니다.</h1>
	<ul>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		 <li>어서오세요 관리자님</li>
	</sec:authorize>
	<sec:authorize access="isAnonymous()"> <!-- 로그인전에 보여라, 로그인후에 안보임 -->
		 <li><a href="user/user.jsp">일반 사용자용 페이지로</a></li>
	</sec:authorize>
	 <li><a href="admin/admin.jsp">관리자 전용 페이지로</a></li>
	</ul>
	<form action="logout" method="post">
	<sec:authorize access="isAuthenticated()">
	 <button>로그아웃</button>	
	</sec:authorize>
	</form>	
</body>
</html>