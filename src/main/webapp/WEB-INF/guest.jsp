<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
        <title>JPA Guestbook Web Application Tutorial</title>
    </head>
 
    <body>
    	<p>${controllerMessage}</p>
        <form  method="POST" action="addContact.html">
            Name: <input type="text" name="name" />
            <input type="submit" value="Add" />
        </form><br><br>
 		<table>
			<tr>
				<th>Name</th>
				<th>Date</th>
			</tr>
			<c:forEach items="${list}" var="mVar" >
			<tr>
				<td>${mVar.name}</td>
				<td>${mVar.signingDate}</td>
			</tr>
			</c:forEach>
		</table>
        
 
  
  
  	
	
  
		
	</body>
</html>