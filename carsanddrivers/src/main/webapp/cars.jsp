<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <meta charset="utf-8">
  <title>Cars & Drivers App</title>
  <style>
   body {
    font: 11pt Arial, Helvetica, sans-serif; /* Рубленый шрифт текста */
    margin: 0; /* Отступы на странице */
   }
   h1 {
    font-size: 36px; /* Размер шрифта */
    margin: 0; /* Убираем отступы */
    color: #000; /* Цвет текста */
   }
   h2 {
    margin-top: 0; /* Убираем отступ сверху */
   }
   #header { /* Верхний блок */
    background: #ccc; /* Цвет фона */
    padding: 10px; /* Поля вокруг текста */
   }
   #sidebar { /* Левая колонка */
    float: left; /* Обтекание справа */
    border: 1px solid #333; /* Параметры рамки вокруг */
    width: 20%; /* Ширина колонки */
    padding: 5px; /* Поля вокруг текста */
    margin: 10px 10px 20px 5px; /* Значения отступов */
   }
   #content { /* Правая колонка */
    margin: 10px 5px 20px 25%; /* Значения отступов */
    padding: 5px; /* Поля вокруг текста */
    border: 1px solid #333; /* Параметры рамки */
   }
   #footer { /* Нижний блок */
    background: #333; /* Цвет фона */
    padding: 5px; /* Поля вокруг текста */
    color: #fff; /* Цвет текста */
    clear: left; /* Отменяем действие float */
   }
   #form { 
    width: 500px; 
    background: #ccc;
    padding: 15px;
    border: solid 1px black; 
    align: center;
   }
  </style>
 </head>
 <body>
  <div id="header"><h1>cars</h1></div>
  <div id="sidebar">
  	<h2>MENU</h2>
    <p><a href="${pageContext.request.contextPath}/app/showcars">Show cars</a></p>
    <p><a href="${pageContext.request.contextPath}/app/showdrivers">Show drivers</a></p>
  </div>
  <div id="content">
    
			<h3>Cars</h3>
			<form method ="post" action="${pageContext.request.contextPath}/app/createcar">
		 <fieldset>
			<legend><h2>Create car</h2></legend>
				model: <input type="text" name="model" value="model"><br>
				number: <input type="text" name="number" value="number"><br>
				<input type="submit" value="Create">
			</fieldset>
			</form>
			<div>
				<c:set var="cars" value="${requestScope.cars}"/>
				<c:forEach var="car" items="${cars}">
			 <hr>
				<ul>	
					
					<li>Model: <c:out value="${car.name}"/> </li>
					<li>Number: <c:out value="${car.number}"/> </li>
					<li>Drivers: <c:set var="drivers" value="${requestScope.drivers}"/> 
						<c:forEach var="driver" items="${car.drivers}">
							<ul>
								<li>name: <c:out value="${driver.name}"/>, 
								phone: <c:out value="${driver.phone}"/></li>
							</ul>
						</c:forEach>
					</li>
					
					<br>
					<form method ="post" action="${pageContext.request.contextPath}/editcar.jsp">
						<input type="hidden" name="carmodel" value="${car.name}">
						<input type="hidden" name="carnumber" value="${car.number}">
						<input type="hidden" name="carid" value="${car.id}">
						<input type="submit" value="Edit"></form>
						<br>
						<form method ="post" action="${pageContext.request.contextPath}/app/deletecar">
						<input type="hidden" name="carid" value="${car.id}">
						<input type="submit" value="Delete"></form>	
								
				</ul>		
			</c:forEach> 
				
			</div>
			
	  
  </div>
  <div id="footer">&copy; Vitalii Hrushyn</div>
 </body>
</html>