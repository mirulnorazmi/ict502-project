package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Users;

public class LoginService {
	public boolean validate(Users users) throws ClassNotFoundException {
		boolean status = false;

		Class.forName("oracle.jdbc.driver.OracleDriver");

		try (Connection connection = DriverManager
				.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dbpms", "system");

				// Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from employee where empemail = ? and emppassword = ? ")) {
			preparedStatement.setString(1, users.getEmail());
			preparedStatement.setString(2, users.getPassword());
			System.out.println(users.getEmail());
			ResultSet rs = preparedStatement.executeQuery();
			
			status = rs.next();
			System.out.println(status);

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return status;
	}
	
	public String getNameDb(String email) throws ClassNotFoundException {
		String name = "";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Users users = new Users();
		try (Connection connection = DriverManager
				.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dbpms", "system");

				// Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from employee where empemail = ?")){
			preparedStatement.setString(1, email);
			System.out.println(users.getEmail());
			ResultSet rs = preparedStatement.executeQuery(); 
			
			while(rs.next()) {
				name = rs.getString("EMPNAME");
			}
			System.out.println(name);
//			System.out.println(status);

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return name;
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
