import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.UserBean;
import DAL.UserDAO;


/**
 * Servlet implementation class testservlet
 */
public class testservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testservlet() {
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
	
		/*
		 * Fetching values from the html or jsp page
		 * author jyoti-davinder
		 */
		
		long roomid = Long.parseLong(request.getParameter("roomid"));
		long roomcost  = Long.parseLong(request.getParameter("roomcost"));
		long deptid  = Long.parseLong(request.getParameter("dno"));
		long noofbeds = Long.parseLong(request.getParameter("abcd"));
		//System.out.println(request.getParameter("married"));
		String roomtype= request.getParameter("roomtype");
		
		UserDAO dao = new UserDAO();
		UserBean bean = new UserBean();
		
		bean.roomid = roomid;
		bean.roomcost = roomcost;
		bean.noofbeds= noofbeds;
		bean.deptid = deptid;
		bean.type= roomtype;
		int count = dao.insertUser(bean);
		dao.davinder();
		response.sendRedirect("second.jsp");
		
		}

	}


