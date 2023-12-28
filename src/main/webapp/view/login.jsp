<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<style>
		div {
			display: flex;
			flex-direction: column;
			align-items: center;
			justify-content: center;
		}
	</style>
</head>

<body>
    
	<div>
		<h1>Todo Login</h1>
		<h3 style="color:red">${pass}</h3>
		
		
		
		<!-- action is address where the values are carried to  -->
		<form action="login" method="post">
			<fieldset>
				<legend>Login here,</legend>
				<table>
					<tr>
						<th>Email: </th>
						<!-- Name attribute is Complusory to carry value  -->
						<th><input type="email" name="email"></th>
						<th><h3>${email}</h3></th>
					</tr>
					<tr>
						<th>Password: </th>
						<!-- Name attribute is Complusory to carry value  -->
						<th><input type="password" name="password"></th>
						<th><h3>${invalidp}</h3></th>
					</tr>
					<tr>
						<!-- Clicking this button will carry the values to action Location  -->
						<th><button>Login</button></th>
						<th><button type="reset">Cancel</button></th>
					</tr>
					<tr>
						<!-- This is for Loading Signup Page -->
						<th colspan="2"><a href="Signup"><button type="button">Click to Create Account</button></a>
						</th>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>

</html>
