

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAL.UserDAO;
import bean.UserBean;

/**
 * Servlet implementation class Testservlet5
 */
public class Testservlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Testservlet5() {
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
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		long roomcost = Long.parseLong(request.getParameter("roomcost"));
		long roomurn = Long.parseLong(request.getParameter("roomurn"));
		UserDAO dao = new UserDAO();
		UserBean bean = new UserBean();
		bean.roomcost=roomcost;
		bean.urn=roomurn;
		users.add(bean);

		int count = dao.update(bean);
		dao.davinder();
		
		response.sendRedirect("third.jsp");
		
	}

}
