<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form:form modelAttribute="product" action="product_save.action" method="post">
			<fieldset>
				<legend>Add a product</legend>
				<p>
					<form:errors path="name" cssClass="error"/>
				</p>
				<p>
					<label for="name">Product Name:</label>
					<form:input path="name" tabindex="1"/>
				</p>
				<p>
					<label for="description">Description:</label>
					<form:input path="description" tabindex="2"/>
				</p>
				<p>
					<form:errors path="price" cssClass="error"/>
				</p>
				<p>
					<label for="price">Price:</label>
					<form:input path="price" tabindex="3"/>
				</p>
				<p>
				</p>	
				<p>
					<form:errors path="productionDate" cssClass="error"/>
				</p>
				<p>
					<label for="productionDate">ProductionDate:</label>
					<form:input path="productionDate" tabindex="4"/>
				</p>
				<p>
					<input id="reset" type="reset" tabindex="5">
					<input id="submit" type="submit" tabindex="6" value="Add Product">
				</p>
			</fieldset>
		</form:form>
	</div>
</body>
</html>