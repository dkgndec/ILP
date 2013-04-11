
function onValidate()
{


if(document.dreg.fname.value== ""|| document.dreg.lastname.value== "")
{
alert("Please fill the mandatory Name values");
return false;
}



if(document.dreg.fee.value== "")
  {
alert("Please fill the mandatory fee value");
return false;
  }



var valid=true;
chosen= "";
var len = document.dreg.gender.length;
var i;
for (i = 0;i <len; i++) 
    {
if (document.dreg.gender[i].checked) 
    {
chosen = document.dreg.gender[i].value;
    }
    }
	if(chosen== "")
	{
	alert("Please select gender");
	return false;
	}
if(document.dreg.sname.value== "")
  {
alert("Please fill the mandatory specialization");
return false;
  }
if(document.dreg.qname.value== "")
  {
alert("Please fill the qualification");
return false;
  }

mail();

var mobile=document.getElementById("cnumber");
			var numericExpression = /^[0-9]+$/;
			if(mobile.value.match(numericExpression)&&mobile.value.length==10)
                        {
return true;
			}
else
{
alert("The value of contact number is not valid");
return false;
}



	return true;
	}


function mail()
	{
	var valid=true;
		if ((dreg.mail.value == "" || dreg.mail.value.indexOf('@','a', 0) == -1) || dreg.mail.value.indexOf('.') == -1)
		{ 
		alert("Please enter a proper value for your email"); 
return false;
		}

	}
		
		


