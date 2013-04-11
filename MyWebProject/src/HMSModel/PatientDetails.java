package HMSModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller_last.UserDaoConnection;

import beans.PatientBean;

/**
 * Servlet implementation class PatientDetails
 */
public class PatientDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PatientDetails() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
		String opt = request.getParameter("option");

		

		if(opt.equals("1"))
		{
			System.out.println(opt);
			String fName=request.getParameter("fName");
			String mName=request.getParameter("mName");
			String lName=request.getParameter("lName");
			String father=request.getParameter("father");
			String date=request.getParameter("date");
			String month=request.getParameter("month");
			String year=request.getParameter("year");
			String dob1 = date+"/"+month+"/"+year;
		    String pType=request.getParameter("pType");
		   /* SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy"); 
		    Date dob = dateFormat.parse(dob1); 

*/
			String bGroup=request.getParameter("bGroup");
			String gender=request.getParameter("gender");
			System.out.println(gender);
			String cNumber1=request.getParameter("cNumber");
			double cNumber=Integer.parseInt(cNumber1);
			String address=request.getParameter("address");
			String email=request.getParameter("email");
			String visit=request.getParameter("visit");
			UserDaoConnection dao = new UserDaoConnection();
			PatientBean pBean=new PatientBean();
			pBean.setFirstName(fName);
			pBean.setMiddleName(mName);
			pBean.setLastName(lName);
			pBean.setFatherName(father);
			pBean.setDateofBirth(dob1);
			pBean.setBloodGroup(bGroup);
			pBean.setContactNumber(cNumber);
			pBean.setContactAddress(address);
			pBean.setEarlierVisited(visit);
			pBean.setGender(gender);
			pBean.setEmailId(email);
			pBean.setPatientType(pType);
			int count = dao.insertUser(pBean);
			String msg = "<html><body><table border = 1>";

			msg+= "<tr><td>"+"OPD number"+"</td><td>"+count+"</td></tr>";
			msg+= "<tr><td>"+"First Nmae"+"</td><td>"+pBean.getFirstName()+"</td></tr>";
			msg+= "<tr><td>"+"Middle Name"+"</td><td>"+pBean.getMiddleName()+"</td></tr>";
			msg+= "<tr><td>"+"Last Name"+"</td><td>"+pBean.getLastName()+"</td></tr>";
			msg+= "<tr><td>"+"Father/Spouse Name"+"</td><td>"+pBean.getFatherName()+"</td></tr>";
			msg+= "<tr><td>"+"Date of Birth"+"</td><td>"+pBean.getDateofBirth()+"</td></tr>";
			msg+= "<tr><td>"+"Blood Group"+"</td><td>"+pBean.getBloodGroup()+"</td></tr>";
			msg+= "<tr><td>"+"Gender"+"</td><td>"+pBean.getGender()+"</td></tr>";
			msg+= "<tr><td>"+"Contact number"+"</td><td>"+pBean.getContactNumber()+"</td></tr>";
			msg+= "<tr><td>"+"Address"+"</td><td>"+pBean.getContactAddress()+"</td></tr>";
			msg+= "<tr><td>"+"eMail Id"+"</td><td>"+pBean.getEmailId()+"</td></tr>";
			msg+= "<tr><td>"+"Visited Before"+"</td><td>"+pBean.getEarlierVisited()+"</td></tr>";
			msg+= "<tr><td>"+"Patient Type"+"</td><td>"+pBean.getPatientType()+"</td></tr>";
			msg+= "</table></body></html>";

			response.getWriter().println(msg);
			
	}
		if(opt.equals("2"))
		{
			String opdNo=request.getParameter("opdNo");
			int opd=Integer.parseInt(opdNo);
			String phone=request.getParameter("phone");
			double contactNumber=Double.parseDouble(phone);
			String address=request.getParameter("address");
			String email=request.getParameter("email");
			UserDaoConnection dao = new UserDaoConnection();
			PatientBean pBean=new PatientBean();
			pBean.setOpdNumber(opd);
			pBean.setContactAddress(address);
			pBean.setContactNumber(contactNumber);
			pBean.setEmailId(email);
			int count = dao.updateUser(pBean);
			System.out.println(count);
			String msg = "<html><body><center>Updated Details</center><table border = 1>";
			
			msg+= "<tr><td>"+"OPD number"+"</td><td>"+pBean.getOpdNumber()+"</td></tr>";
			msg+= "<tr><td>"+"Contact number"+"</td><td>"+pBean.getContactNumber()+"</td></tr>";
			msg+= "<tr><td>"+"Address"+"</td><td>"+pBean.getContactAddress()+"</td></tr>";
			msg+= "<tr><td>"+"eMail Id"+"</td><td>"+pBean.getEmailId()+"</td></tr>";
			msg+= "</table></body></html>";
			response.getWriter().println(msg);
		}
		if(opt.equals("3"))
		{
			String opdNo=request.getParameter("opd");
			int opd=Integer.parseInt(opdNo);
			UserDaoConnection dao = new UserDaoConnection();
			PatientBean pBean=new PatientBean();
			pBean.setOpdNumber(opd);
			System.out.println("kapish");
			int count = dao.deleteUser(pBean);
			System.out.println(count);
			String msg = "<html><body><center>Deleted Details</center><table border = 1>";
			if(count !=0)
			{
				msg+= "<tr><td>"+"Details of this OPD number"+pBean.getOpdNumber()+" is deleted</td></tr>";
				
			}
			else
			{
				msg+="<tr><td>OPD number not found</td></tr>";
			}
			msg+= "</table></body></html>";
			response.getWriter().println(msg);
		}
		if(opt.equals("4"))
		{
			String opdNo=request.getParameter("opdNo");
			int opd=Integer.parseInt(opdNo);
			String bGroup=request.getParameter("bGroup");
			String docob=request.getParameter("docob");
			String medicine=request.getParameter("medicine");
			String ward=request.getParameter("radio1");
			String pType=request.getParameter("radio2");
			UserDaoConnection dao = new UserDaoConnection();
			PatientBean pBean=new PatientBean();
			pBean.setOpdNumber(opd);
			pBean.setBloodGroup(bGroup);
			pBean.setDoctorObservation(docob);
			pBean.setMedicineProvided(medicine);
			pBean.setWardissued(ward);
			pBean.setPatientType(pType);
			int count = dao.updateUserAppointment(pBean);
			System.out.println(count);
			String msg = "<html><body><center>Updated Details</center><table border = 1>";
			if(count==1)
			{
			msg+= "<tr><td>"+"OPD number"+"</td><td>"+pBean.getOpdNumber()+"</td></tr>";
			msg+= "<tr><td>"+"Blood Group"+"</td><td>"+pBean.getBloodGroup()+"</td></tr>";
			msg+= "<tr><td>"+"Doctor Observation"+"</td><td>"+pBean.getDoctorObservation()+"</td></tr>";
			msg+= "<tr><td>"+"Ward Type Issued"+"</td><td>"+pBean.getWardissued()+"</td></tr>";
			msg+= "<tr><td>"+"Patient Type"+"</td><td>"+pBean.getPatientType()+"</td></tr>";
			}
			else
			{
				msg+= "<tr><td>Updation Failed</td></tr>";
			}
			msg+= "</table></body></html>";
			response.getWriter().println(msg);
			
			
		}
		if(opt.equals("5"))
		{
			String search=request.getParameter("search");
			String userName=request.getParameter("userName");
			System.out.println(userName);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy"); 
		    Date dob = null;
		    try{
	        	 dob = dateFormat.parse(search);
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	        java.sql.Date sqlDOB = new java.sql.Date(dob.getTime());
	        UserDaoConnection dao = new UserDaoConnection();
	        ArrayList ar=dao.searchAppointment(sqlDOB,userName);
	        System.out.println(search);
	        System.out.println(sqlDOB);
	        String msg = "<html><body><center>Updated Details</center><table border = 1>";
			if(ar.isEmpty())
			{
				msg+= "<tr><td>Enter Correct Date</td></tr>";
			}
			else
			{
				msg+= "<tr><td>"+"OPD number"+"</td><td>"+(Double)ar.get(1)+"</td></tr>";
				msg+= "<tr><td>"+"Patient Name"+"</td><td>"+(String)ar.get(6)+"</td></tr>";
				msg+= "<tr><td>"+"Date Of Birth"+"</td><td>"+(Date)ar.get(7)+"</td></tr>";
				msg+= "<tr><td>"+"Blood Group"+"</td><td>"+(String)ar.get(8)+"</td></tr>";
				msg+= "<tr><td>"+"Gender"+"</td><td>"+(String)ar.get(9)+"</td></tr>";
				msg+= "<tr><td>"+"Patient Type"+"</td><td>"+(String)ar.get(10)+"</td></tr>";
				msg+= "<tr><td>"+"Department Name"+"</td><td>"+(String)ar.get(2)+"</td></tr>";
				msg+= "<tr><td>"+"Visiting Date"+"</td><td>"+(Date)ar.get(3)+"</td></tr>";
				msg+= "<tr><td>"+"Slot Start Time"+"</td><td>"+(Time)ar.get(4)+"</td></tr>";
				msg+= "<tr><td>"+"Slot End Time"+"</td><td>"+(Time)ar.get(5)+"</td></tr>";
				
				
			}
			msg+= "</table></body></html>";
			response.getWriter().println(msg);
		}
		}catch(Exception e)
		{e.printStackTrace();}
	}

}
