package controller.project;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProjectService;

import java.io.IOException;

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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
