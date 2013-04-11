<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="Add_bean.*" %> 
<%@ page import="Add_DAL.*" %> 

<%
ArrayList<DepartmentBean> users = new ArrayList<DepartmentBean>();
users = (ArrayList<DepartmentBean>)request.getAttribute("users");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name = "form1" method = "post" action ="Department?option=5">
<table border = "0">
	    <tr>
		<td>Department ID :</td> <td> <input type="text" name="deptid" id="deptid" value=<%= users.get(0).getDepartmentID() %> readonly></td>
		</tr>	
	    <tr>
		<td>Department Name :</td> <td> <input type="text" name="deptname" id="deptname" value=<%= users.get(0).getDepartmentName() %> readonly></td>
		</tr>
		<tr>
		<td>Mobile Number :</td> <td><input type="text" name="mn" id="mn" value=<%= users.get(0).getMobileNumber() %> ></td>
		</tr>
		<tr>
		<td>Landline Number :</td> <td><input type="text" name="ln" id="ln"  value=<%= users.get(0).getLandLineNumber() %>></td>
		</tr>
		<tr>
		<td>No of Floor Assistant</td> <td><input type="text" name="nfa" value=<%= users.get(0).getNoOfFloorAssistants() %>></td>
		</tr>
		<tr>
		<td>No of Nurse</td> <td><input type="text" name="non" value=<%= users.get(0).getNoOfNurse() %>></td>
		</tr>
		<tr>
		<td>Facilities Description</td> <td><textarea rows="3" cols="15" name = "description"><%= users.get(0).getFacilityDescription() %></textarea></td>
		</tr>
		
		</table>
	<div id ="submit">
<input type = "submit" value = "Confirm" /><input type = "Reset" value = "Reset" />
</form>
</body>
</html>