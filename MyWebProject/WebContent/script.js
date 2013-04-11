function onvalidate()
{ 
	
if(document.form1.deptid.value=="")
  {
   alert("Specify Department ID");
   return false;
  }


var formValue=document.getElementById("deptid").value;
if(isNaN(formValue)===true){
  alert('Department ID should be numeral!');
return false;
}

if(document.form1.deptname.value=="")
{
 alert("Specify Department Name");
 return false;
}

var TCode1 = document.getElementById('deptname').value;

if( /[^a-zA-Z0-9]/.test( TCode1 ) ) 
  {
     alert('Department Name is not alphanumeric');
     return false;
  }
   


if(document.form1.mn.value=="")
{
 alert("Specify Mobile Number");
 return false;
}



var formValue=document.getElementById("mn").value;
if(isNaN(formValue)===true){
  alert('Mobile Number should be numeral!');
return false;
}

if(document.form1.mn.value.length != 10) 
{
 alert("Mobile Number should be of 10 digits");
 return false;
}

if(document.form1.ln.value=="")
{
 alert("Specify Landline Number");
 return false;
}


var formValue=document.getElementById("ln").value;
if(isNaN(formValue)===true){
  alert('Landline Number should be numeral!');
return false;
}

if(document.form1.ln.value.length != 8) 
{
 alert("Landline Number should be of 8 digits");
 return false;
}

if(document.form1.nfa.value=="")
{
 alert("Specify No of Floor Assistant");
 return false;
}



var formValue=document.getElementById("nfa").value;
if(isNaN(formValue)===true){
  alert('No of Floor Assistant should be numeral!');
return false;
}

if(document.form1.non.value=="")
{
 alert("Specify No of Nurse");
 return false;
}



var formValue=document.getElementById("non").value;
if(isNaN(formValue)===true){
  alert('No of Nurse should be numeral!');
return false;
}


}