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
            preparedStatement.setInt(3, project.getSalary());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
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
