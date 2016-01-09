<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Here is the registration page</p>
	
	<!-- Auto call setUsername and setPasswrod for object user -->
	<sf:form method="POST" action="registerDetails" modelAttribute="user">
		Username: <input type="text" name="username" path="username"/>
		password: <input type="text" name="password" path="password"/>
		confpassword: <input type="text" name="confpassword" />
		<input type="submit" value="submit" />
	</sf:form>
	
</body>
</html>