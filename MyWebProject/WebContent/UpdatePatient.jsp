<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head><script >
function changeCategory()

{
	var opd=document.updateByDoctorForm.opdNo.value;
 	window.location = "UpdatePatient.jsp?opdno="+opd;
}
</script></head>
<div class="content">
<!-- /content -->
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="controller_last.UserDAO" %>
<%
try
{
	int id=0;
	String opdno=request.getParameter("opdno");
			if(request.getParameter("opdno") != null)
				{
				id=Integer.parseInt(request.getParameter("opdno"));
				}
	Connection DatabaseConnection = UserDAO.getDatabaseConnection();
	PreparedStatement ps=null;
	ResultSet rs = null;
	ps = DatabaseConnection.
	prepareStatement("SELECT opd_no FROM HMS_PATIENT");
	rs = ps.executeQuery();
	%>

<center><a href="UpdatePatient.jsp">Reset</a></center>
<form name="updateByDoctorForm" action="/HMS/PatientDetails?option=2" method="post"> 
		<h1><center>
				<font font size="6">Update Patient Details
				</font>
			</center>
		</h1>
		<h1>
			<center>
				<font font size="6">Patient details are given below
				</font>
			</center>
		</h1>
		<table align="center">
		<tr>
				<td>OPD No.
				</td>
				<td><select name="opdNo" onchange="changeCategory()"><%if(id==0){ %>
								<option value="OPD">OPD Number</option>	
									
									<% while(rs.next())
									{
										%>
										<option value="<%=rs.getInt(1)%>"><%= rs.getInt(1) %></option>
									<% 
									}%>
									<%}else {%>
										<option value="<%=id%>"><%= id %></option>
									<%}%>
									
							</select>	
				</td>
			</tr>
			<%if(opdno !=null)
			{
		ps = DatabaseConnection.
	prepareStatement("SELECT * FROM HMS_PATIENT where opd_no=?");
			ps.setInt(1,id);
	rs = ps.executeQuery();
	while(rs.next()){
	 %>
			<tr>
				<td>First Name
				</td>
				<td><input type="text" name="first" value="<%=rs.getString(2) %>">
				</td>
			</tr>
		<tr>
			<td>Middle Name 
			</td>
			<td><input type="text" name="middle" value="<%=rs.getString(3) %>">
			</td>
		</tr>
		<tr>
			<td>Last Name
			</td>
			<td><input type="text" name="last" value="<%=rs.getString(4) %>">
			</td>
		</tr>
		<tr>
			<td>Father/Spouse Name
			</td>
			<td><input type="text" name="father" value="<%=rs.getString(5) %>">
			</td>
		</tr>
		<tr>
			<td>Contact Number(+91)
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
			<td><input type="text" name="phone" id="ph" value="<%=rs.getString(9) %>">
			</td>
		</tr>
		<tr>
			<td>Gender
			</td>
			<td><input type="text" name="gender" value="<%=rs.getString(8) %>">
			</td>
		</tr>
		<tr>
			<td>Blood Group
			</td>
			<td><input type="text" name="bGroup" value="<%=rs.getString(7) %>">
			</td>
		</tr>
		<tr>
			<td>Date of birth
			</td>
			<td><input type="text" name="dob" value="<%=rs.getDate(6) %>">
			</td>
		</tr>
		<tr>
			<td>Address
			</td>
			<td><input type="text" name="address" value="<%=rs.getString(10) %>">
			</td>
		</tr>
		<tr>
			<td>Email Id
			</td>
			<td><input type="text" name="email" value="<%=rs.getString(11) %>">
			</td>
		</tr>
	</table>
		<center><input type= "submit" name= "update" value="Update"></input>
		</center>
	</form>
	</div>
<% }}}catch(Exception e){e.printStackTrace();}
finally
		{
			try {
				UserDAO.closeConnection();	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}%>
		
		
		</html>