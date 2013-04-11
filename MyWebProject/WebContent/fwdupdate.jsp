<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="bean.UserBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<form type="dummy" action="Testservlet5" method="post">
<%
ArrayList<UserBean> detail=new ArrayList<UserBean>();

if(request.getAttribute("detail") != null)
{
detail=(ArrayList)request.getAttribute("detail");
}
UserBean b1=new UserBean();
b1=detail.get(0);
%>
<%
for(UserBean bean: detail)
{
	out.println( "<table><tr><td>URN Number<input type=text name=roomurn value="+bean.urn+" readonly></td></tr></table>");
	out.println( "<table><tr><td>Room ID<input type=text value="+bean.roomid+" readonly></td></tr></table>");
	out.println( "<table><tr><td>Room Type<input type=text value="+bean.type+" readonly></td></tr></table>");
	out.println( "<table><tr><td>Room Cost<input type=text name=roomcost value="+bean.roomcost+"></td></tr></table>");
	out.println( "<table><tr><td>No of beds<input type=text value="+bean.noofbeds+" readonly></td></tr></table>");
	out.println( "<table><tr><td>Department Id<input type=text value="+bean.deptid+" readonly></td></tr></table>");
	
}
%>

<input type="submit" value="update"></input>
</form>

</body>
</html>