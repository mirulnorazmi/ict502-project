package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.EmployeeService;
import service.PaymentService;
import service.ProjectService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import bean.Payment;
import bean.Projects;
import bean.Users;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/dashboard")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService;
	private ProjectService projectService;
	private PaymentService paymentService;

	public void init() {
		employeeService = new EmployeeService();
		projectService = new ProjectService();
		paymentService = new PaymentService();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
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
		try {

			showDashboard(request, response);

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
		doGet(request, response);
	}

	private void showDashboard(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Users listCategory = employeeService.getAllCategories();
		Projects projects = new Projects();
		Payment payment = new Payment();
		int rowCount = projectService.getTotalProject();
		projects.setRowCount(rowCount);
		int rowCountPayment = paymentService.getTotalPayment();
		payment.setRowCount(rowCountPayment);
		
		
		request.setAttribute("listCategory", listCategory);
		request.setAttribute("projects", projects);
		request.setAttribute("payment", payment);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
		dispatcher.forward(request, response);
	}

}
