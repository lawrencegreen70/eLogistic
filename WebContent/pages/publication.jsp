<%@taglib uri="http://java.sun.com/jstl/core" prefix="c1"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<%@page language= "java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<script type="text/javascript">
	
	        function validate()
            {
                var id = document.getElementById("id");
				if(id.value.length > 0 && isNaN(id))
				{
	                if( document.getElementById("Move") != null){
	                	document.getElementById('Move').disabled=false;
	                	document.getElementById('GetRequest').disabled=false;
	       
	                }
	                else if(document.getElementById("Approve") != null){
	                	document.getElementById('Approve').disabled=false;  
	                	document.getElementById('Deny').disabled=false;          
	                }
	            }
                return true;    
            };
	
	</script>

</head>

<body>
<form action="item.do" method="POST" align = "center">
<h1> Welcome to the publication page!! </h1>

<table align = "center">

<tr>
	<td>Id</td>
	<td>Name</td>
	<td>Location</td>
	<td>NeedsApproval</td>
	<td>Approved</td>
	<td>ApprovalRequsted</td>
</tr>
<c:forEach items="${list}" var="publications">
    <tr>
   		<td>  ${publications.id}   </td>
       	<td>  ${publications.name} </td>    
       	<td>  ${publications.location}   </td>
       	<td>  ${publications.needApproval} </td>
       	<td>  ${publications.approved}   </td>
       	<td>  ${publications.requested} </td>      
    </tr>
</c:forEach>

</table>

<br><br><br><br><br><br>

<table align = "center">
	<tr>	
	<td></td><td></td><td></td>
		<td> <label for = "id"> Enter ID:</label> </td>
		<td> <input type = "text" name = "id" id = "id" class="mytext" maxlength="3" style="width: 50px;" onkeyup="validate()" /> </td>
	</tr>
	<tr>
		 <c:if test= "${role == 'Worker'}">
		 	<td></td><td></td><td></td>
			<td><input id ="Move" type="submit" name= "action" value="Move" disabled="disabled"/></td>
			<td><input id ="GetRequest" type="submit" name= "action" value="GetRequest" disabled="disabled"/></td>
   		</c:if>
		<c:if test= "${role == 'Manager'}" >
			<td></td><td></td><td></td>
			<td><input id ="Approve" type="submit"name= "action" value="Approve" disabled="disabled"/></td>
			<td><input id ="Deny" type="submit"name= "action" value="Deny" disabled="disabled"/></td>
   		</c:if>
   		<td><a href="login.jsp"> Sign Out </a></td>
	</tr>
</table>

</form>
</body>
</html>