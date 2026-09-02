<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body style="font-family: sans-serif; padding: 50px; background-color: #f4f6f9;">

	<h2 style="color: #2c3e50">Secure Dashboard</h2>
	
	<div style="background-color: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1)">
	
		<h3>Welcome, <%= session.getAttribute("loggedInUser") %>! 👋</h3>
		<p>This is protected page. Only authenticated users can see this content.</p>
		
		<hr>
		
		<form action="/logout" method="post">
			<button type="submit" style="background-color: #e74c3c; color: white; border: none; padding: 10px 15px; cursor: pointer">
				Logout
			</button>
		</form>
	
	</div>

</body>
</html>