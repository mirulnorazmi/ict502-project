package controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.LoginService;
import bean.Users;

import java.io.IOException;



/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginservice;

	public void init() {
		loginservice = new LoginService();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		Users user = new Users();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		user.setEmail(email);
		user.setPassword(password);
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());

//		try {
//			if (loginservice.validate(user)) {
//				HttpSession session = request.getSession();
//				session.setAttribute("email", email);
//				response.sendRedirect("dashboard.jsp");
//			} else {
////				HttpSession session = request.getSession();
//				// session.setAttribute("user", username);
////				response.sendRedirect("index.jsp");
//			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		System.out.println("User email : " + user.getEmail());
//		System.out.println("User password : " + user.getPassword());
//		request.getRequestDispatcher("/dashboard.jsp").forward(request,response);

		System.out.println("Hello world!...");
	}

}
