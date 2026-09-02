<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body style="font-family: san-serif; padding: 50px">

	<h1>Welcome to Servlet Filter</h1>
	
	<% if(request.getParameter("error") != null) { %>
		<p style="color: red">Invalid username or password!</p>
	<% } %>
	
	<form action="/login" method="post" style="border: 1px solid #ccc; padding: 20px; width: 300px">
		
		<label>Username:</label><br>
		<input type="text" name="username" required><br><br>
		
		<label>Password:</label><br>
		<input type="password" name="password" required><br><br>
		
		<button type="submit">Login</button>
		
	</form>

</body>
</html>