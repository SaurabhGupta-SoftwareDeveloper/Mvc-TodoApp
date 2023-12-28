<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Task</title>
</head>

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
</style>
<body>
	<div>
		
		<form action="update-task" method="post">
			<fieldset>
				<legend>Edit here</legend>
				
				<input type="hidden" name="id" value="${task.id}">
				<table>
					<tr>
						<th>Task Name:</th>
						
						<th><input type="text" name="name" value="${task.name}"></th>
					</tr>
					<tr>
						<th>Task Description:</th>
						<th><input type="text" name="description" value="${task.description}"></th>
					</tr>

					<tr>
						<th><button type="submit" id="btn1">Update</button></th>
						<th><button type="reset" id="btn2">Cancel</button></th>
					</tr>
				</table>
			</fieldset>
		</form>
		<br> <br> <a href="home"><button>back</button></a>
	</div>
</body>
</html>