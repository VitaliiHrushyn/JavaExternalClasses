<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit car</title>
</head>
<body>
	<c:set var="carmodel" value="${param.carmodel}"/>
	<c:set var="carnumber" value="${param.carnumber}"/>
	<c:set var="carid" value="${param.carid}"/>
	<form method ="post" action="${pageContext.request.contextPath}/app/editcar">
		 <fieldset>
			<legend><h2>Editing car (id: ${carid})</h2></legend>
				model: <input type="text" name="model" value="${carmodel}"><br>
				number: <input type="text" name="number" value="${carnumber}"><br>
				<input type="hidden" name="carid" value="${carid}">
				<input type="submit" value="Submit">
			</fieldset>
		</form>
		</form>
		<br>
		<form method ="post" action="${pageContext.request.contextPath}/app/showcars">
		<input type="submit" value="To cars page">
		</form>
</body>
</html>