<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<style>
	div {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
		margin-top: 200px;
	}
	form{
		background-color: cyan;
	}
	body{
		background-color: salmon;
	}
	
	#btn1{
	
		background-color: lightgreen;
	}
	#btn2{
	
		background-color: red;
	}
	input{
		background-color:rgb(128, 255, 255);
	}
	
	
	
</style>

<body>
   
	<div>
		<form method="post" id="from">
			<fieldset>
				<legend>Signup Here</legend>
				<table>
					<tr>
						<th>Name: </th>
						<th><input type="text" name="name"></th>
					</tr>
					<tr>
						<th>Email: </th>
						<th><input type="email" name="email"></th>
					</tr>
					<tr>
						<th>Password: </th>
						<th><input type="text" name="password"></th>
					</tr>
					<tr>
						<th>Gender: </th>
						<th><input type="radio" id="male" name="Gender" value="male">Male
						<input type="radio" id="male" name="Gender" value="male">Female
						</th>
					</tr>
					<tr>
						<th>Dob: </th>
						<th><input type="date" name="date"></th>
						<th> <h6>${dob}</h6></th>
					</tr>
					<tr>
						<th>Mobile: </th>
						<th><input type="tel" pattern="[0-9]{10}" name="phone"></th>
					</tr>
					<tr>
						<th><button formaction="Signup" id="btn1">Create</button></th>
						<th><button type="reset" id="btn2">cancel</button></th>
						
					</tr>
				</table>
		</form>
		</fieldset>
	</div>
</body>

</html>