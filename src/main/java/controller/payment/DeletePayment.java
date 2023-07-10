package controller.payment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.PaymentService;

import java.io.IOException;
import java.sql.SQLException;

import bean.Payment;

/**
 * Servlet implementation class DeletePayment
 */
public class DeletePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PaymentService paymentService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		paymentService = new PaymentService();
	}
	
    public DeletePayment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.parseInt(request.getParameter("id")); 
		Payment payment = new Payment();
		payment.setId(id);
		boolean status = false;
		try {
			status = paymentService.deletePayment(payment);
			
			response.sendRedirect(request.getContextPath() + "/payment");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			response.sendRedirect(request.getContextPath() + "/payment");
		}
		System.out.println("delete status : " + status);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
