package service;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Projects;
import bean.Users;

public class ProjectService {
	private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
    private String jdbcUsername = "dbpms";
    private String jdbcPassword = "system";
	
    private static final String SELECT_ALL_PROJECTS = "select * from project";
    private static final String INSERT_PROJECT_SQL = "insert into project (projectname, projectdept, projectsalary) VALUES (?, ?, ?)";
    private static final String SELECT_PROJECT_ID = "SELECT * FROM project WHERE projectid=?";
    private static final String SELECT_PROJECT_NAME = "SELECT * FROM project WHERE projectname=?";
    private static final String DELETE_PROJECT_SQL = "DELETE from project where projectid = ?";
    private static final String UPDATE_PROJECT = "UPDATE project set projectname=?, projectdept=?, projectsalary=? WHERE projectid=?";
	protected Connection getConnection() {
        Connection connection = null;
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
	
	public List < Projects > selectAllProjects() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Projects > projects = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROJECTS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("projectid");
                String name = rs.getString("projectname");
                String dept = rs.getString("projectdept");
                int salary = rs.getInt("projectsalary");

                
                projects.add(new Projects(id, name, dept, salary));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return projects;
    }
	
	public void insertProject(Projects project) throws SQLException {
//        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROJECT_SQL)) {
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getDepartment());
            preparedStatement.setDouble(3, project.getSalary());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
	
	public Projects getOneProject(Projects projects) {
		Projects proj = null;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROJECT_ID)) {
			preparedStatement.setInt(1, projects.getId());

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				int project_id = rs.getInt("projectid");
				String name = rs.getString("projectname");
				String dept = rs.getString("projectdept");
				double salary = rs.getDouble("projectsalary");


				proj = new Projects(project_id, name, dept, salary);
			}

		} catch (SQLException e) {
			printSQLException(e);
		}

		return proj;
	}
	
	public int getProjectByName(Projects projects) {
		int id = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROJECT_NAME)) {
			preparedStatement.setString(1, projects.getName());

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				id = rs.getInt("projectid");
			}

		} catch (SQLException e) {
			printSQLException(e);
		}

		return id;
	}
	
	public boolean updateProject(Projects project) throws SQLException {
		boolean status = false;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PROJECT)) {
			preparedStatement.setString(1, project.getName());
			preparedStatement.setString(2, project.getDepartment());
			preparedStatement.setDouble(3, project.getSalary());
			preparedStatement.setInt(4, project.getId());
			System.out.println(project.getName());
			preparedStatement.executeUpdate();
			status = true;
		} catch (SQLException e) {
			printSQLException(e);
			status = false;
		}

		return status;
	}
	
	public boolean deleteProject(Projects projects) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();) {
			PreparedStatement statement = connection.prepareStatement(DELETE_PROJECT_SQL);
			statement.setInt(1, projects.getId());
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
