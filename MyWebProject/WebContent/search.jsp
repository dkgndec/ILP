<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bean.DOC,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor's Registration Page</title>


<script type="text/javascript" src="docs.js">
</script>
</head>
<table width="98%" align="center">
<tr height=40px align="center" style="background-color:#989898;">
	<td> <h1 style="color:white;"> Doctor's Registration Form</h1> </td>
</tr>

<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
<h1 align="center"> Doctor's Page </h1>
<h5 align="center">All fields marked with * are mandatory</h5>
<form name="dreg" action="Upadate" method="post">

<%ArrayList<DOC> doctorList=new ArrayList<DOC>();
doctorList=(ArrayList)request.getAttribute("users");

%>>
<table border="1" align="center">
   <tr><td>Doctor ID:</td><td> <input type="textbox" name="did" value="<%=doctorList.get(0).id %>"readonly></input>"><sup>*</sup></td></tr>
        <tr>
        <tr><td>First Name:</td><td> <input type="textbox" name="fname" value="<%=doctorList.get(0).firstName%>"readonly><sup>*</sup></td></tr>
        <tr><td>Last Name:</td> <td><input type="textbox" name="lastname" value="<%=doctorList.get(0).lastName %>"readonly><sup>*</sup></td></tr>
        <tr><td>Gender:</td><td>    <input type="textbox" name="gender" id="gender" value="<%=doctorList.get(0).gender%>"readonly> </td></tr>
       
<tr><td>Fee:</td> <td><input type="textbox" name="fee" value="<%=doctorList.get(0).fee%>"><sup>*</sup></td></tr>
 
        <tr><td>Date Of Birth:</td><td> <input type="text" name="mydate" id="datepicker" value="<%=doctorList.get(0).dob%>"readonly><sup>*</sup></td></tr>
        <tr><td>Qualification:</td><td><input type="textarea" name="qname" id="qname" value="<%=doctorList.get(0).qualification%>"readonly><sup>*</sup></td></tr>
        <tr><td>Visiting Days:</td> <sup>*</sup><td>
                    <input type="textbox" name="visting" value="<%=doctorList.get(0).visting%>"readonly>
                    
                   
                    
                    
</td></tr>
<tr><td>Specialization:</td><td><input type="text" id="sname" name="sname" value="<%=doctorList.get(0).specialization%>" readonly><sup>*</sup></td></tr>
<tr><td>E-mail Id:</td><td><input type="text" id="mail" name="email"  value="<%=doctorList.get(0).email%>"readonly><sup>*</sup></td></tr>
<tr><td>Contact no:</td><td> <input type="text" name="cnumber" id="cnumber" value="<%=doctorList.get(0).contact%>"readonly><sup>*</sup></td></tr>
<tr><td>Visiting Time</td>
<td> <input type="text" name="cnumber" id="cnumber" value="<%=doctorList.get(0).Visiting_Time%>"readonly></td></tr>
<tr><td>Department id</td>
<td> <input type="text" name="cnumber" id="cnumber" value="<%=doctorList.get(0).departmentid%>"readonly></td>
</tr>
</table>

</form>
  
</div></div></div>
</body>
</html>