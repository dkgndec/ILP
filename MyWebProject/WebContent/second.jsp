<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*" %>
<%@ page import="bean.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="DAL.UserDAO"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="staff.css">
<link rel="stylesheet" href="style.css">

<title>URN Number of Room </title>

</head>
<body>



<table width="100%" cellpadding="10" cellspacing="0" id="table" border="0">
<tr>

<!-- ============ HEADER SECTION ============== -->
<td colspan="3" class="Site_name" style="height: 100px;" bgcolor="#f0f0f0"><h2>Hospital Management System</b></br>HMS Management</h2></td></tr>


<!-- ============ NAVIGATION BAR SECTION ============== -->
<tr><td colspan="3" valign="middle" height="30" bgcolor="#a9ae9f"><a href="test.html">Home</a></td></tr>



<!-- ============ MIDDLE COLUMN (CONTENT) ============== -->

<td width="100%" valign="top" bgcolor="#d2d8c7">
 <h4 class="test">New Room Form</h4>
<h3>New room id is </h3>
<%
UserDAO a= new UserDAO();

out.println(a.davinder());

%>

<!-- ============ FOOTER SECTION ============== -->
<tr><td colspan="3" align="center" height="20" bgcolor="#777d6a">Copyright@</td></tr>
</table>

</body>
</html>