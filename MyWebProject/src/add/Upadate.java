package add;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAL.InsertDoc;
import bean.DOC;

/**
 * Servlet implementation class Upadate
 */
public class Upadate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upadate() {
        super();
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
		String firstName = request.getParameter("fname");
		String lastName  = request.getParameter("lastname");
		String qua = request.getParameter("qname");
		String mail = request.getParameter("email");
		char gender = request.getParameter("gender").equals("M")?'M':'F'; 
		long contact = Long.parseLong(request.getParameter("cnumber"));
		//System.out.println(request.getParameter("married"));
		String special  = request.getParameter("sname");
 String visiting=request.getParameter("visting");
		String date = request.getParameter("mydate");
		String Visiting_Time = request.getParameter("vt");
		int fee=Integer.parseInt(request.getParameter("fee"));
		int departmentid=Integer.parseInt(request.getParameter("depid"));
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		int id=Integer.parseInt(request.getParameter("did"));
   	    Date bill = null;
		try {
			bill = df.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			InsertDoc dao = new InsertDoc();
			 DOC v=new DOC();
		v.firstName=firstName;
		v.lastName=lastName;
		v.qualification=qua;
		v.email=mail;
		v.gender=gender;
		v.contact=contact;
		v.specialization=special;
		v.fee=fee;
		v.dob=bill;
		v.Visiting_Time=Visiting_Time;
		v.visting=visiting;
		v.departmentid=departmentid;
		v.id=id;	
		
			int count = dao.UpadateUser(v);
	
	}

}
