package controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.LoginService;

import java.io.IOException;
import java.sql.SQLException;

import bean.Users;

/**
 * Servlet implementation class SigninServlet
 */
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginservice;

	public void init() {
		loginservice = new LoginService();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SigninServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		Users user = new Users();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		user.setEmail(email);
		user.setPassword(password);
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());

		try {
			if (loginservice.validate(user)) {
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				user = loginservice.getInformation(email);
				session.setAttribute("name", user.getName());
				session.setAttribute("empid", user.getId());
				System.out.println("session id" + session.getAttribute("empid"));
//				response.sendRedirect("dashboard.jsp");
//				request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
				response.sendRedirect(request.getContextPath() + "/dashboard");
				
			} else {
//				mapping to index	
				response.sendRedirect(request.getContextPath());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
