function allnumeric()   
    {   
        var roomid = document.htmlform.roomid.value;
        var roomcost = document.htmlform.roomcost.value;
        
       
        var roomtype = document.htmlform.roomtype;
        var dno = document.htmlform.dno.value;
        
        var numbers = /^[A-z]+$/;
        var number = /^[0-9]+$/;
        
        
        var abcd=document.htmlform.abcd.value;
        if (roomid=="" || roomid.length>6)//for first roomid
            {
                alert("Please enter room_id with maximum 6 Numerals");
                document.htmlform.roomid.focus();
                return false;
  
            }
       if(roomid.match(number))   //for first roomid without space and numeric
            {
                //do nothing
            }
       else
            {
                alert ("Please enter only numeric");
                document.htmlform.roomid.focus();
                return false;
             }
       if (roomcost=="" || roomcost.length>6)  //for roomcost
            {
                alert ("Please enter room cost with maximum 6 numerals");
                document.htmlform.roomcost.focus();
                return false;
            }
        if(roomcost.match(number)) //for lastname without space and numerics
           {
               //do nothing
           }
        else   
            {   
                alert('Please input numerics only');   
                document.htmlform.roomcost.focus();   
                return false;   
            }  
        
        
         if (roomtype.value=="123")
             {
                 alert("Please enter roomtype field");
                 document.htmlform.roomtype.focus();
                return false;
             }
         if(dno=="")
            {
                alert("Please enter department number");
                document.htmlform.dno.focus();
                 return false;

            }
         if(dno.match(number))
           {
               //do nothing
           }
        else   
            {   
                alert('Please input only numerics without spaces in Dept Number field');   
                document.htmlform.dno.focus();   
                return false;   
            }
         
             
        
        if(abcd=="")
            {
                alert("please Enter the bed Numbers");
                document.htmlform.abcd.focus();
                return false;
                
            }
        
        if(abcd.match(number))
        {
            //do nothing
        }
     else   
         {   
             alert('Please input only numerics without spaces in Dept Number field');   
             document.htmlform.dno.focus();   
             return false;   
         }
      
      
     }  



function validateNoOfBeds()
{
	var x=document.htmlform.roomtype.value;

	var str=x.split(",");
	document.htmlform.abcd.value=str[1];
	
}



       




