<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "spring" uri = "http://java.sun.com/jsp/jstl/core" %>	
<%@page import="java.time.format.DateTimeFormatter"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todo Home Page</title>
<style>
div {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}

form {
	background-color: cyan;
}

body {
	background-color: salmon;
}

#btn1 {
	background-color: lightgreen;
}

#btn2 {
	background-color: red;
}
</style>
</head>
<body>

	
	<div>
	<h1>${pass}</h1>
		<fieldset>
			<legend>Home Page here</legend>
			<h1>home page</h1>
	        <h3>${welcome}</h3>
	        	<table border="2px solid black">
				<tr>
					<th>Task Name</th>
					<th>Task description</th>
					<th>Date Created</th>
					<th>Status</th>
					<th>Delete</th>
					<th>Edit</th>
				</tr>
				
				<tr>
				<spring:forEach var="task" items="${list}">
				
					<th>${task.name}</th>
					<th>${task.description}</th>
					<th>${task.createdTime.format(DateTimeFormatter.ofPattern('dd MMM YYYY hh:mm'))}</th>
					
					<th>
					<spring:if test="${task.status}">
					 Completed
					</spring:if>
					<spring:if test="${!task.status}">
					<a href="change-status?id=${task.id}"><button>Complete</button></a> 
					</spring:if>	
					</th>
					<th><a href="delete?id=${task.id}"><button>Delete</button></th></a>
					<th><a href="Edit?id=${task.id}"><button>Edit</button></th></a>
					
				</tr>
				
			</spring:forEach>
			</table>
		</fieldset>
		<br> <br> <a href="add-task"><button>Add
				Task</button></a> <br> <br> <a href="logout"><button>Logout</button></a>
	</div>
</body>
</html>