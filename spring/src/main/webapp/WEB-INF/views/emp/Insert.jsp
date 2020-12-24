<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
.error{
	color:red;
}
	
</style>
</head>
<body>
	<h1>사원등록</h1>
	<form:form action="empInsert" method="post" modelAttribute="emp">
	<c:if test="${not empty emp.employeeId }">
		<form:input path="employeeId" readonly="true"/><br>
	</c:if>
	<spring:message code="emp.firstName"/>
		<form:input path="firstName" placeholder="firstName" /><br>
	<spring:message code="emp.lastName"/>	
		<form:input path="lastName" placeholder="lastName" />
		<form:errors path="lastName" cssClass="error" htmlEscape="false"/><br>
		
	<spring:message code="emp.email"/>	
		<form:input path="email" placeholder="email" />
		<form:errors path="email" cssClass="error" htmlEscape="false"/><br>
		<%-- <form:select path="jobId" items="${jobs}" itemLabel="jobTitle" itemValue="jobId" /><br> --%>
		<form:select path="jobId" cssClass="springFormCheck">
			<form:option value="">job 선택</form:option>
			<form:options items="${jobs }" itemLabel="jobTitle" itemValue="jobId" />
		</form:select>
		<form:errors path="jobId" cssClass="error" htmlEscape="false"/><br>
		<%-- cssClass를 통해서 css적용 가능 --%>
		<form:select path="departmentId" items="${depts}" itemLabel="departmentName" itemValue="departmentId" /><br>
		<form:input path="hireDate" placeholder="hireDate" /><br>
		<form:input path="salary" placeholder="salary" /><br>
		<form:button>등록</form:button>
	</form:form>
</body>
</html>