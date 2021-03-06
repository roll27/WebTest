<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form:form modelAttribute="employee" action="employee_save" method="post">
		<fieldset>
			<legend> Add an employee </legend>
			<p>
				<label for="firstName">First Name: </label>
				<form:input path="firstName" tabindex="1"/>
			</p>
			<p>
				<label for="lastName">First Name:</label>
				<form:input path="lastName" tabindex="2"/>
			</p>
			<p>
				<form:errors path="birthDate" cssClass="error"/>
			</p>
			<p>
				<label for="birthDate"> Date Of Birth:</label>
				<form:input path="birthDate" tabindex="3"/>
			</p>
			<p id="buttons">
				<input id="reset" type="reset" tabindex="4">
				<input id="submit" type="submit" tabindex="5" value="Add Employee">
			</p>
		</fieldset>
		</form:form>
	</div>
</body>
</html>