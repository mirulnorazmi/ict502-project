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
 * Servlet implementation class DeleteProject
 */
public class DeleteProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectService projectService;

	public void init() {
		projectService = new ProjectService();
	}

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		Projects projects = new Projects();
		try {
			projects.setId(Integer.parseInt(request.getParameter("id")));
			boolean status = projectService.deleteProject(projects);
			System.out.println("Status delete : " + status);
			response.sendRedirect(request.getContextPath() + "/project");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
