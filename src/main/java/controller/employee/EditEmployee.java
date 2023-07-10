package controller.employee;

import jakarta.servlet.RequestDispatcher;
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
import bean.Users;

/**
 * Servlet implementation class EditEmployee
 */
@WebServlet("/edit-employee")
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService;

	public void init() {
		employeeService = new EmployeeService();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditEmployee() {
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
				getFulltime(request, response);
				break;
			case "parttime":
				getParttime(request, response);
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
				updateFulltime(request, response);
				break;
			case "parttime":
				updateParttime(request, response);
				break;
			default:
				break;

			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}

	private void getFulltime(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Users users = new Users();
		Fulltime fulltime = new Fulltime();
		users.setId(Integer.parseInt(request.getParameter("id")));

		fulltime = employeeService.getOneFulltime(users);
		request.setAttribute("employee", fulltime);

		RequestDispatcher dispatcher = request.getRequestDispatcher("editFulltime.jsp");
		dispatcher.forward(request, response);
	}

	private void getParttime(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Users users = new Users();
		Parttime parttime = new Parttime();
		users.setId(Integer.parseInt(request.getParameter("id")));
		parttime = employeeService.getOneParttime(users);
		request.setAttribute("employee", parttime);
		System.out.println(parttime.getName());

		RequestDispatcher dispatcher = request.getRequestDispatcher("editParttime.jsp");
		dispatcher.forward(request, response);
	}

	private void updateFulltime(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		Fulltime fulltime = new Fulltime();

		fulltime.setId(Integer.parseInt(request.getParameter("id")));
		fulltime.setName(request.getParameter("name"));
		fulltime.setPhone(request.getParameter("phone"));
		fulltime.setEmail(request.getParameter("email"));
		fulltime.setAge(Integer.parseInt(request.getParameter("age")));
		fulltime.setGender(request.getParameter("gender"));
		fulltime.setRoleId((int) session.getAttribute("empid"));
		fulltime.setAnnualLeave(Integer.parseInt(request.getParameter("annual")));
		fulltime.setSickLeave(Integer.parseInt(request.getParameter("sick")));
		fulltime.setInsurance(request.getParameter("insurance"));
		fulltime.setUnpaidLeave(Integer.parseInt(request.getParameter("unpaid")));

//		System.out.println("Gender input : " + request.getParameter("gender") );
//		System.out.println("insurance : " + request.getParameter("insurance"));
		boolean status = false;
		if (!employeeService.checkEmail(fulltime)) {
			status = employeeService.updateFulltime(fulltime);
			response.sendRedirect(request.getContextPath() + "/employee");
		} else {
			response.sendRedirect(request.getContextPath() + "/employee?error=201");
		}
		System.out.println("update fulltime : " + status);
	}

	private void updateParttime(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		Parttime parttime = new Parttime();

		parttime.setId(Integer.parseInt(request.getParameter("id")));
		parttime.setName(request.getParameter("name"));
		parttime.setPhone(request.getParameter("phone"));
		parttime.setEmail(request.getParameter("email"));
		parttime.setAge(Integer.parseInt(request.getParameter("age")));
		parttime.setGender(request.getParameter("gender"));
		parttime.setRoleId((int) session.getAttribute("empid"));
		parttime.setStartdate(Date.valueOf(request.getParameter("startDate")));
		parttime.setEnddate(Date.valueOf(request.getParameter("endDate")));
		parttime.setHourlyrate(Double.parseDouble(request.getParameter("hourlyRate")));

		boolean status = false;
		if (!employeeService.checkEmail(parttime)) {
			status = employeeService.updateParttime(parttime);	
			response.sendRedirect(request.getContextPath() + "/employee");
		} else {
			response.sendRedirect(request.getContextPath() + "/employee?error=202");
		}
		System.out.println("update parttime : " + status);
	}

}
