<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page errorPage="/jsp/error.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Details</title>
</head>
<body>

<form method="post" action="/Registration/UserServlet">
<%
	out.println("Your IP address is " + request.getRemoteAddr());
%>
	<table>
	
		<tbody>
		
			<tr>
			<td>
			User Name :			
			</td>
			<td>
			<%= request.getSession().getAttribute("username")%>
			</td>

			</tr>
			
			<tr>
			<td>
			Password :			
			</td>
			<td>
			<%= request.getSession().getAttribute("pwd")%>
			
			<%= request.getSession().getAttribute("121pwd").equals("pwd")%>
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