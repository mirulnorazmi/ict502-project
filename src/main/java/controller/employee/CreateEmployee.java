package controller.employee;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.EmployeeService;
import service.ProjectService;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import bean.Fulltime;
import bean.Parttime;
import bean.Users;

/**
 * Servlet implementation class CreateEmployee
 */
@WebServlet("/create-employee")
public class CreateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService;

	public void init() {
		employeeService = new EmployeeService();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateEmployee() {
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
//		RequestDispatcher dispatcher = request.getRequestDispatcher("createEmployee.jsp");
//		dispatcher.forward(request, response); 
		String emp = request.getParameter("emp");
		try {
			switch (emp) {
			case "fulltime":
				showFulltime(request, response);
				break;
			case "parttime":
				showParttime(request, response);
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
		String emp = request.getParameter("emp");
		try {
			switch (emp) {
			case "fulltime":
				createFulltime(request, response);
				break;
			case "parttime":
				createParttime(request, response);
				break;
			default:
				break;

			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}

	private void showFulltime(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeFulltime.jsp");
		dispatcher.forward(request, response);
	}

	private void showParttime(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeParttime.jsp");
		dispatcher.forward(request, response);
	}

	private void createFulltime(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
//		Fulltime fulltime = new Fulltime();
//		Users users = new Users();

		HttpSession session = request.getSession();
		System.out.println("session id" + session.getAttribute("empid"));

		int managerid = (int) session.getAttribute("empid");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		int annualLeave = Integer.parseInt(request.getParameter("annual"));
		int sickLeave = Integer.parseInt(request.getParameter("sick"));
		String insurance = request.getParameter("insurance");
		int unpaidLeave = Integer.parseInt(request.getParameter("unpaid"));

		Fulltime fulltime = new Fulltime(name, phone, email, age, gender, managerid, annualLeave, sickLeave, insurance,
				unpaidLeave);
		boolean status = false;
		if (!employeeService.checkEmail(fulltime)) {
			status = employeeService.insertFulltime(fulltime);
			System.out.println("create fulltime status : " + status);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeFulltime.jsp");
//		dispatcher.forward(request, response);
			response.sendRedirect(request.getContextPath() + "/employee");
		} else {
			response.sendRedirect(request.getContextPath() + "/employee?error=101");
		}
		System.out.println("create fulltime status : " + status);

	}

	private void createParttime(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		System.out.println("session id" + session.getAttribute("empid"));

		int managerid = (int) session.getAttribute("empid");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		Date startDate = Date.valueOf(request.getParameter("startDate"));
		Date endDate = Date.valueOf(request.getParameter("endDate"));
		System.out.println(request.getParameter("hourlyRate"));
		Double hourlyRate = Double.parseDouble(request.getParameter("hourlyRate"));

		Parttime parttime = new Parttime(name, phone, email, age, gender, managerid, startDate, endDate, hourlyRate);

		boolean status = false;
		if (!employeeService.checkEmail(parttime)) {
			status = employeeService.insertParttime(parttime);
			System.out.println("create fulltime status : " + status);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("EmplyeeParttime.jsp");
//		dispatcher.forward(request, response);
			response.sendRedirect(request.getContextPath() + "/employee");
		} else {
			response.sendRedirect(request.getContextPath() + "/employee?error=102");
		}
	}

}
