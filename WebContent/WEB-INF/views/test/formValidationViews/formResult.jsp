<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<spring:url value="/resources/test-main.css" var="testMainCSS"/>
	<link href="${testMainCSS}" rel="stylesheet" />
<title>Form validation test result</title>
</head>
<body>
	<h1 class="ch1">Congratiulations. You are now a registered	representative of your organization!</h1>
	<h2 class="ch2">Details are below ..</h2>
	<hr>
	<div align="center">
		<h3>Name: <b class="cb">${orgrep.firstName}</b></h3>
		<h3>Last Name: <b class="cb">${orgrep.lastName}</b></h3>
		<h3>Age: <b class="cb">${orgrep.age}</b></h3>
		<h3>Zip Code: <b class="cb">${orgrep.zipCode}</b></h3>	
		<h3>Email: <b class="cb">${orgrep.email}</b></h3>	
		<h3>Password: <b class="cb">${orgrep.password}</b></h3>							
	</div>
	
	<hr>
	<div align="center">
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<a href="${contextPath}/formValidationDemo/home" style="font-size: 17px">Click here to go back to home page</a>
	</div>
</body>
</html>