<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="sign.do" method="post" align = "center" >
<!-- style="width: 100%; vertical-align: middle; font-size: 12px; text-align: center;" styleClass=""> -->
<h1>Please Login </h1>


<br><br><br><br><br><br>

<table align = "center">
		<tr>
			<td> <label for = "username"> Username:</label> </td>
			<td> <input type = "text" name = "username" id = "username" /> </td>
		</tr>
		<tr>
			<td> <label for = "password"> Password:</label> </td>
			<td> <input type = "password" name = "password" id = "password" /> </td>
		</tr>
		<tr>
			<td><input type="submit" name= "action" value="Login" /></td>
		</tr>
</table>


</form>
</body>
</html>