<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
		<form name="updateByDoctorForm" action="/HMS/PatientDetails?option=3" method="post"> 
		<h1><center>
				Delete OPD
			</h1>
			<table>
			<tr>
			<td>OPD Number
			</td>
			<td><input type="text" name="opd">
			</td>
		</tr>
	</table>
	</center>	
			
		<center><input type= "submit" name= "delete" value="Delete"></input>
		</center>
			</form>
</body>
</html>