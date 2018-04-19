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
	<c:set var="driver" value="${requestScope.driver}"/>
	
	<form method ="post" action="${pageContext.request.contextPath}/app/editdriver">
		 <fieldset>
			<legend><h2>Editing driver (id: ${driver.id})</h2></legend>
				name: <input type="text" name="name" value="${driver.name}"><br>
				phone: <input type="text" name="phone" value="${driver.phone}"><br>
				
				<input type="hidden" name="driverid" value="${driver.id}">
				<br>
				<input type="submit" value="Save changes">
			
	</form>	
		<br>
		<br>		
				<b>cars:</b> <c:set var="cars" value="${driver.cars}"/> 	
					<c:forEach var="car" items="${driver.cars}">
						<form method ="post" action="${pageContext.request.contextPath}/app/deletecardriver">
							<c:out value="${car.name}"/>   <c:out value="${car.number}"/>
							<input type="hidden" name="carid" value="${car.id}">
							<input type="hidden" name="driverid" value="${driver.id}">
							<input type="submit" value="delete car">
						</form>							
					</c:forEach>
					
				
				
			</fieldset>
		
		<br>
		<form method ="post" action="${pageContext.request.contextPath}/app/addcar">
				 <fieldset>
					<legend><b>Add car to driver</b></legend>
						<select name="allcarid">
			                <c:forEach items="${allCars}" var="allcar">
			                <option value ="${allcar.id}">${allcar.name} ${allcar.number}</option>
			                </c:forEach>
                 		</select>
						
						<input type="hidden" name="driverid" value="${driver.id}">
						<input type="submit" value="add car">
					</fieldset>
		</form>
		<br>
		<form method ="post" action="${pageContext.request.contextPath}/app/showdrivers">
		<input type="submit" value="To drivers page">
		</form>
</body>
</html>