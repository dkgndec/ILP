<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="DAL.UserDAO"%>
<%@page import="bean.UserBean"%>
<%@page import="java.util.ArrayList"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Room Description</title>
</head>
<body>
<%
ArrayList<UserBean> users = new ArrayList<UserBean>();
if(request.getAttribute("users") != null)
{
	users = (ArrayList<UserBean>)request.getAttribute("users");
}
%>
<%
long roomid=0;
String type=null;
long mn=0;
long ln=0;
long nfa=0;
long nn=0;
String d=null;

	for(UserBean bean : users)
	{
		roomid=bean.roomid;
		type=bean.type;
		mn=bean.roomcost;
		ln=bean.noofbeds;
		nfa=bean.deptid;
		
	}
%>
<table border=1>
<tr>
<td>
System Generated Receipt:</td>
<td><%= roomid %>
</td>
</tr>
<tr>
<td>
Product Name: </td>
<td><%= type %>
</td>
</tr>
<tr>
<td>
Selling Price</td>
<td><%= mn %>
</td>
</tr>

<tr>
<td>
Product Name: </td>
<td><%=ln %>
</td>
</tr>
</table>

		

</body>
</html>