<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:url value="/resources/test-main.css" var="testMainCSS"/>
<link href="${testMainCSS}" rel="stylesheet" />
<title>Test Bed</title>
</head>
<body>

<div align="center">
	<h1>Welcome to the Form Tags Test</h1>
	<hr>
	<h3>Register your Organization with us!</h3>
	<form:form action="registerOrg" modelAttribute="orgRegistration">
		<table>
			<tr>
				<td><form:label path="orgName">Name of Organization</form:label></td>
				<td><form:input path="orgName" placeholder="Enter Organization name"/></td>
			</tr>
			
			<tr>
				<td><form:label path="country">Country</form:label></td>
				<td>
					<form:select path="country">
						<form:option value="NONE">------SELECT-------</form:option>
						<form:option value="Australia">Australia</form:option>
						<form:option value="India">India</form:option>
						<form:option value="Suedia">Suedia</form:option>
						<form:option value="Belgia">Belgia</form:option>
						<form:option value="Egipt">Egipt</form:option>						
					</form:select>
				</td>
			</tr>
			
			<tr>
				<td><form:label path="turnover">Turnover</form:label></td>
				<td><form:select path="turnover"  items="${turnoverlist}"/></td>
			</tr>
			
			<tr>
				<td><form:label path="type">Types</form:label></td>
				<td>
					<form:select path="type" >
						<form:option value="NONE">----------SELECT---------</form:option>
						<form:options items="${typeslist}" />
					</form:select>
				</td>
			</tr>
			
			<tr>
				<td><form:label path="serviceLength">Organization Age</form:label></td>
				<td><form:select path="serviceLength"  items="${serviceLengthList}"/></td>
			</tr>
			
			<tr>
				<td><form:label path="registeredPreviosly">Registered Previosly?</form:label></td>
				<td><form:checkbox path="registeredPreviosly"  items="${registeredList}"/></td>
			</tr>
			
			<tr>
				<td><form:label path="like">Like our website?</form:label></td>
				<td><form:checkbox path="like" value="yes"/>Like</td>
			</tr>
			
			<tr>
				<td><form:label path="optionalServices">Optional Services Subscription?</form:label></td>
				<td>
					<form:checkbox path="optionalServices" value="emailService" /> ${subscriptionList.emailService}
					<form:checkbox path="optionalServices" value="promotionalService" /> ${subscriptionList.promotionalService}
					<form:checkbox path="optionalServices" value="newsLetterService" /> ${subscriptionList.newsLetterService}				
				</td>
			</tr>
			
			<tr>
				<td><form:label path="premiumServices">Premium Services</form:label></td>
				<td><form:checkboxes path="premiumServices"  items="${premiumServiceList}"/></td>
			</tr>
			
			<tr>
				<td><form:label path="overseasOperations">OverSeas Operations?</form:label></td>
				<td>
					<form:radiobutton path="overseasOperations" value="Yes" /> Yes
					<form:radiobutton path="overseasOperations" value="No" />  No		
				</td>
			</tr>
			
			<tr>
				<td><form:label path="employeeStrength">Workforce Size</form:label></td>
				<td><form:radiobuttons path="employeeStrength"  items="${employeeStengthList}"/></td>
			</tr>
			
			<tr>
				<td/>
				<td align="center"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</div>

</body>
</html>