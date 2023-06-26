package controller.project;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.EmployeeService;
import service.ProjectService;

import java.io.IOException;
import java.util.List;

import bean.Projects;
import bean.Users;

/**
 * Servlet implementation class projectServlet
 */
@WebServlet("/project")   
public class projectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectService projectService;

    public void init() {
    	projectService = new ProjectService();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public projectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Projects> listProject = projectService.selectAllProjects();
		request.setAttribute("listProject", listProject);
		RequestDispatcher dispatcher = request.getRequestDispatcher("project.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
