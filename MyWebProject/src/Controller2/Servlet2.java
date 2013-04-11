package Controller2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean2.VendorBean;
import DAL2.VendorDAO;

/**
 * Servlet implementation class Servlet2
 */
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet2() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String vendor_name= request.getParameter("vendorname");
		String company_name=request.getParameter("companyname");
		String addrline1=request.getParameter("addrline1");
		String addrline2=request.getParameter("addrline2");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		long  phoneno=Long.parseLong(request.getParameter("phoneno"));
		String email=request.getParameter("email");
		
			VendorBean bean = new VendorBean();
			
			bean.vendor_Name = vendor_name;
			bean.company = company_name;
			bean.addrline1 = addrline1;
			bean.addrline2 = addrline2;
			bean.city = city;
			bean.state = state;
			bean.contactno= phoneno;
			bean.email=email;
			VendorDAO dao=new VendorDAO();
			dao.insertVendor(bean);
			dao.getVendorid();
			response.sendRedirect("inder.jsp");
			
				}

	}
	


