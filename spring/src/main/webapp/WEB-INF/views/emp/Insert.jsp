<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>사원등록</h1>
	<form:form action="empInsert" method="post" modelAttribute="emp">
	<c:if test="${not empty emp.employeeId }">
		<form:input path="employeeId" readonly="true"/><br>
	</c:if>
		<form:input path="firstName" placeholder="firstName" /><br>
		<form:input path="lastName" placeholder="lastName" /><br>
		<form:input path="email" placeholder="email" /><br>
		<%-- <form:select path="jobId" items="${jobs}" itemLabel="jobTitle" itemValue="jobId" /><br> --%>
		<form:select path="jobId" cssClass="springFormCheck">
			<form:option value="">job 선택</form:option>
			<form:options items="${jobs }" itemLabel="jobTitle" itemValue="jobId" />
		</form:select><br>
		<%-- cssClass를 통해서 css적용 가능 --%>
		<form:select path="departmentId" items="${depts}" itemLabel="departmentName" itemValue="departmentId" /><br>
		<form:input path="hireDate" placeholder="hireDate" /><br>
		<form:input path="salary" placeholder="salary" /><br>
		<form:button>등록</form:button>
	</form:form>
</body>
</html>