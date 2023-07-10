package controller.employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.EmployeeService;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import bean.Fulltime;
import bean.Parttime;

/**
 * Servlet implementation class DeleteEmployee
 */
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService;

	public void init() {
		employeeService = new EmployeeService();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String emp = request.getParameter("emp");
		try {
			switch (emp) {
			case "fulltime":
				deleteFulltime(request, response);
				break;
			case "parttime":
				deleteParttime(request, response);
				break;
			default:
				break;

			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

	}

	private void deleteFulltime(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Fulltime fulltime = new Fulltime();
//		Users users = new Users();
		try {
			fulltime.setId(Integer.parseInt(request.getParameter("id")));
			boolean status = employeeService.deleteFulttime(fulltime);
			System.out.println("Status delete fulltime : " + status);
			response.sendRedirect(request.getContextPath() + "/employee");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/employee");
		}
//		RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeFulltime.jsp");
//		dispatcher.forward(request, response);
//		response.sendRedirect(request.getContextPath() + "/employee");
	}

	private void deleteParttime(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Parttime parttime = new Parttime();

		try {
			parttime.setId(Integer.parseInt(request.getParameter("id")));
			boolean status = employeeService.deleteParttime(parttime);
			System.out.println("Status delete parttime : " + status);
			response.sendRedirect(request.getContextPath() + "/employee");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/employee");
		}
	}

}
