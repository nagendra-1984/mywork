<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
</head>
<body>

<form method="post" action="/Registration/UserServlet">
<%
out.println("Your IP address is " + request.getRemoteAddr());

%>
	<% out.println(config.getInitParameter("CompanyName")); %>
	<% out.println(config.getInitParameter("Country")); %>
	
	
Company Name : <% config.getInitParameter("CompanyName"); %>
Country : 	<% config.getInitParameter("Country"); %>
	<table>
	
		<tbody>
		
			<tr>
			<td>
			User Name :			
			</td>
			<td>
			<input type="text" name="name"/>
			</td>

			</tr>
			
			<tr>
			<td>
			Password :			
			</td>
			<td>
			<input type="text" name="pwd"/>
			</td></tr>
						
			<tr>
			<td colspan="2"><input type="submit" value="create"/>
			</td>
			</tr>
		</tbody>
	</table>

</form>

</body>
</html>