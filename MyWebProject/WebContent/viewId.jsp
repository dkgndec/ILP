<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="bean.UserBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<body>
<form name="book" action="Testservlet4" method="POST">

<table>
<tr>
<td>Booking-Id:</td>&nbsp;&nbsp;&nbsp;
<td><select name="booking" style="width: 150px">
<option value="SelectId">Select-ID</option>
			<%
				ArrayList<UserBean> bookingId = new ArrayList<UserBean>();
			bookingId = (ArrayList<UserBean>) request.getAttribute("objId");

				for (int i = 0; i < bookingId.size(); i++) {
					long s = bookingId.get(i).urn;
			%>
<option><%=s%> <%
 	}
 %>
</option>
</select></td>
</tr>
<tr>
<td></td><td><input type="submit" value="Submit"></input></td>
</tr>
</table>
</form>
</body>
</html>