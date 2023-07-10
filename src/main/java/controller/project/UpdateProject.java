package controller.project;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProjectService;

import java.io.IOException;
import java.sql.SQLException;

import bean.Projects;

/**
 * Servlet implementation class UpdateProject
 */
@WebServlet("/edit-project")
public class UpdateProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectService projectService;
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		projectService = new ProjectService();
	}
	
    public UpdateProject() {
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
		System.out.println("id : "+id);
		Projects project = new Projects();
		project.setId(id);
		project = projectService.getOneProject(project);
		request.setAttribute("project", project);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editProject.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		Projects project = new Projects();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String dept = request.getParameter("department");
		Double salary = Double.parseDouble(request.getParameter("salary")); 
		project.setId(id);
		project.setName(name);
		project.setDepartment(dept);
		project.setSalary(salary);
		try {
			boolean status = projectService.updateProject(project);
			response.sendRedirect(request.getContextPath() +"/project");
			System.out.println("update status ; " + status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
