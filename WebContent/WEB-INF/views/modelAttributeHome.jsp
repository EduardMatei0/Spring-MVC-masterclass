<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>@Model Attribute Test</title>
	<style>
		input[type=text] {
			padding: 10px;
			margin: 10px;
			font-size: 20px
		}
		
		input[type=submit] {
			border: none;
			background-color: #4CAF50;
			color: white;
			padding: 16px;
			margin: 16px;
			cursor: pointer;
			font-size: 20px
		}
		
		h1, h2 {
			color: #08298A;
			text-align: center
		}
	</style>
</head>
<body>
	<div align="left">
		<h1>${testdata1A }</h1>
		<div align="center" >
			<b>Corporate office: ${testdata3.city} ${testdata3.zipCode}</b>
			<b>, Registerd office: ${address.city} ${address.zipCode}</b>
		</div>
		<hr>
		
		${testdata1B} 
		<br>
		 ${testdata2}
		<hr>
		
		<form:form action="test5" modelAttribute="anAddress">
			<table>
				<tr>
					<td><form:label path="city">City Name</form:label></td>
					<td><form:input path="city"/></td>
				</tr>
				<tr>
					<td><form:label path="zipCode">Postal Code</form:label></td>
					<td><form:input path="zipCode"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Display Address"/></td>
				</tr>
			</table>		
		</form:form>
		<br></br>
		<form:form action="modelAttributeTest">
			<h3>Test 6: Testing @ModelAttribute with no explicit logical view name</h3> 
				<table>
					<tr>
						<td><input type="submit" value="Relocate" /></td>
					</tr>
				</table>
		</form:form>
	</div>
</body>
</html>