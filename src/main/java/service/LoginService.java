package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Users;

public class LoginService {
	private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String jdbcUsername = "dbpms";
	private String jdbcPassword = "system";

	private final String SELECT_EMPLOYEE_ID = "SELECT empid FROM employee WHERE (empid = ? AND emproleid IS NULL) OR (empid IN (SELECT emproleid FROM employee) AND empid=?)";
	private final String SELECT_EMPLOYEE_VALIDATE = "SELECT * FROM employee WHERE empemail=? AND empphone=?";

	public Connection getConnection() {
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

//	public boolean validate(Users users) throws ClassNotFoundException {
//		boolean status = false;
//
//		try (Connection connection = getConnection();) {
//			// Create a statement using connection object
//			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_ID);
//			preparedStatement.setInt(1, users.getId());
//			preparedStatement.setInt(2, users.getId());
//			ResultSet rs = preparedStatement.executeQuery();
//
////			while(rs.next()) {
////				if(rs.getInt("empid") == users.getId()) {
////					status=true;
////				}
////			}
//			status = rs.next();
//			
//			
//			
//		} catch (SQLException e) {
//			// process sql exception
//			printSQLException(e);
//		}
//		return status;
//	}

	public boolean validate(Users users) throws SQLException {
		boolean status = false;

		try (Connection connection = getConnection()) {
			// Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_VALIDATE);
			preparedStatement.setString(1, users.getEmail());
			preparedStatement.setString(2, users.getPassword());
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
//			while(rs.next()) {
//				if(rs.getInt("empid") == users.getId()) {
//					status=true;
//				}
//			}

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return status;
	}

	public String getNameDb(String email) throws SQLException {
		String name = "";

//		Class.forName("oracle.jdbc.driver.OracleDriver");
		Users users = new Users();
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dbpms",
				"system");

				// Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from employee where empemail = ?")) {
			preparedStatement.setString(1, email);
			System.out.println(users.getEmail());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
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
		for (Throwable e : ex) {
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
