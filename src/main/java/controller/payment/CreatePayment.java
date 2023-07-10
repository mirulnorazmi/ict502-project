package controller.payment;

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
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import bean.Payment;
import bean.Projects;
import bean.Users;
import bean.Assigned;

/**
 * Servlet implementation class CreatePayment
 */
@WebServlet("/create-payment")
public class CreatePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher view;
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
    public CreatePayment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Users> listUser = employeeService.selectAllUsersEmail();
		List<Projects> listProject= projectService.selectAllProjects();		
		request.setAttribute("listUser", listUser);
		request.setAttribute("listProject", listProject);
		view = request.getRequestDispatcher("createPayment.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		Users users = new Users();
		Projects project = new Projects();
		
		users.setEmail(request.getParameter("email"));
		project.setName(request.getParameter("project"));
		
		System.out.println("model users email : " + users.getEmail());
		System.out.println("model project name : " + project.getName());
		
		int emp_id = employeeService.getEmployeeByEmail(users);
		int proj_id = projectService.getProjectByName(project);
		Double annual = Double.parseDouble(request.getParameter("annual"));
		Double commission = Double.parseDouble(request.getParameter("commission"));
		Double amount = Double.parseDouble(request.getParameter("amount"));
		Date date = Date.valueOf(request.getParameter("date"));
		
		System.out.println("emp id : " + emp_id);
		System.out.println("proj id : " + proj_id);
		
		int id_payment = 0;
		boolean statusAssigned = false;
		
		try {
			id_payment = paymentService.insertPayment(new Payment(amount, date));
			Assigned assigned = new Assigned(emp_id, proj_id, id_payment , annual, commission);
			statusAssigned = paymentService.insertAssigned(assigned);
			System.out.println("status create payment :" + statusAssigned);
			response.sendRedirect(request.getContextPath() + "/payment");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/create-payment");
		}
		
	}

}
