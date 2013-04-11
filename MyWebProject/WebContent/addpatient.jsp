<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
 
<div class="content">
<form name="register" action="/HMS/PatientDetails?option=1" method="post">
<input type="hidden" name="req" value="addPatientDetails" /><!-- for server side validation(in do post of fom controller) -->
<center>
<h1>Patient Registration</h1></center>
<table align="center">


			<tr>
				<td>First Name*</td>
			
				<td><input type="text" name="fName" maxlength="20" onkeypress="return check(event)" /></td>
			</tr>
			<tr>
				<td>Middle Name</td>
				
				<td><input type="text" name="mName" maxlength="20" onkeypress="return check(event)"/></td>
			</tr>
			<tr>
				<td>Last Name*</td>
				
				<td><input type="text" name="lName" maxlength="20" onkeypress="return check(event)"/></td>
			</tr>
			<tr>
				<td>Father/Spouse Name<font color="red">*</font></td>
				
				
				<td><input type="text" name="father" maxlength="20" onkeypress="return check(event)"/></td>
			</tr>
			<tr>
				<td>Date Of Birth*</td>
				
				<td>DD
				
				<select name="date" id="date1">
								<option value="Date">Day</option>	
									
									<% for(int i=1;i<=31;i++)
									{
										%>
										<option><%= i %></option>
									<% 
									}%>
									
									
							</select>		
						MM
						
						<select name="month" id='month1'>
									<option>select</option>
									<option>01</option>
									<option>02</option>
									<option>03</option>
									<option>04</option>
									<option>05</option>
									<option>06</option>
									<option>07</option>
									<option>08</option>
									<option>09</option>
									<option>10</option>
									<option>11</option>
									<option>12</option>
							</select>
						YY
							<select name="year" id='year1'>
							
								<option value="year">Year</option>
									<% for(int j=1930;j<=2020;j++)
									{
										%>
										<option><%= j %></option>
									<% 
									}%>
									
									
							</select></td>	
					
					</tr>				
				
					
					
					
					
					
					
			<tr>
				<td>Blood Group*</td>
				
				<td><select name="bGroup" id='bg1'>
							<option>select</option>
							<option>O+</option>
							<option>A+</option>
							<option>B+</option>
							<option>AB+</option>
							<option>O-</option>
							<option>A-</option>
							<option>B-</option>
					</select></td>
					</tr>
			<tr>
				<td>Gender*</td>
				
				<td>male <input type="radio" name="gender" value="male" checked/>
					 female<input type="radio" name="gender" value="male"/></td>
			</tr>
			
			<tr>
				<td>Contact Number*</td>
				
				<td><input type="text" name="cNumber" maxlength=10 onkeypress="return isNumber(event)"/></td>
			</tr>
			<tr>
			<td>Address</td>
			<td><input type="text" name="address" maxlength=10 onkeypress="return isNumber(event)"/>
			</td>
			
			
			</tr>
			
			
				<tr>
			<td>Email Id</td>
			<td><input type="text" name="email" maxlength=10 onkeypress="return isNumber(event)"/>
			</td>
			
			
			</tr>
			
				<tr>
			<td>Already Visited</td>
			<td><input type="radio" name="visit" value="yes">YES
			<input type="radio" name="visit" value="no">NO
			</td>
			
			
			</tr>
			<tr>
			<td>Patient Type</td>
			<td><input type="radio" name="pType" value="in-Patient">in-Patient
			<input type="radio" name="pType" value="out-Patient">out-Patient
			</td>
			
			
			</tr>
			<tr>
				<td colspan=2>
				
				
				<input type="submit" value="Submit" onClick="return formSubmit();"/>
				
		        <input type="reset" value="Reset"/>
		        
		        </td>
		
		
		  
		     </tr>
					
</table>
			
</form>


<script type="text/javascript">

function formSubmit()
{
if(document.register.fName.value==""||document.register.fName.value==Null)
	{
		alert("First Name cannot be blank");
		document.register.fName.focus();
		return false;
	
	} 
	

		if(document.register.lName.value=="")
		{

			alert("Last Name cannot be blank");
			document.register.lName.focus();
		
			return false;
		}
		
	if(validateFatherSpouseName(document.register.father.value))
	if(validateDate(document.register.date.value))
	if(validateMonth(document.register.month.value))
	if(validateYear(document.register.year.value))
    if(validateBloodGroup(document.register.bGroup.value))

     return true;
}
/*
function validateFirstName(firstName)
{
	if(firstName==""||firstName==Null)
	{
		alert("First Name cannot be blank");
		return false;
		//document.getElementById("error_msg").innerHTML='';
		//document.getElementById("error_msg").innerHTML='First Name cannot be blank';
		
	}
	else
	{
		return true;
	}
	return false;
}
*/
function validateLastName(lastName)
{
	if(lastName=="")
	{
		alert("Last Name cannot be blank");
	
		return false;
	}
	else
	{
		return true;
	}
	return false;
}

function validateFatherSpouseName(fs)
{
	if(fs=="")
	{
		alert("Father/Spouse Name cannot be blank");
		
		return false;
	}
	else
	{
		return true;
	}
	return false;
}
function validateDate(date)
{
	
	if(document.getElementById('date1').selectedIndex==0)
	{
		alert("Date cannot be blank");

		return false;
	}

	else
	{
		return true;
	}
	return false;
}

function validateMonth(month)
{
	 if(document.getElementById('month1').selectedIndex==0)
		{
			alert("Month cannot be blank");

		return false;
		}
	 else
		{
			return true;
		}
		return false;
}
function validateYear(year)
{
	 if(document.getElementById('year1').selectedIndex==0)
		{
			alert("Year cannot be blank");
		
		return false;
		}
	else
		{
		return true;
		}
		return false;
}


function validateBloodGroup(Bg)
{
	if(document.getElementById('bg1').selectedIndex==0)
	{
		alert("BloodGroup cannot be blank");
	
		return false;
	}
	else
	{
		return true;
	}
	return false;
}




</script>



<!-- /content -->
</div>
