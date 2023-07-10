package service;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Assigned;
import bean.Payment;
import bean.Projects;
import bean.Users;

public class PaymentService {

	private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String jdbcUsername = "dbpms";
	private String jdbcPassword = "system";

	private static final String SELECT_ALL_PROJECTS = "select * from project";
	private static final String INSERT_PROJECT_SQL = "insert into project (projectname, projectdept, projectsalary) VALUES (?, ?, ?)";
	private static final String SELECT_PROJECT_ID = "SELECT * FROM project WHERE projectid=?";
	private static final String SELECT_PROJECT_NAME = "SELECT * FROM project WHERE projectname=?";
	private static final String DELETE_PROJECT_SQL = "DELETE from project where projectid = ?";
	private static final String UPDATE_PROJECT = "UPDATE project set projectname=?, projectdept=?, projectsalary=? WHERE projectid=?";
	private static final String INSERT_PAYMENT_SQL = "INSERT INTO PAYMENT (amount, paymentdate) VALUES (?,?)";
	private static final String INSERT_ASSIGNED_SQL = "INSERT INTO assigned (empid, projectid, paymentid, annual, commission) "
			+ "VALUES (?,?,?,?,?)";
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
	
	public boolean insertAssigned(Assigned assigned) {
		boolean status = false;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ASSIGNED_SQL)) {
			preparedStatement.setInt(1, assigned.getEmpId());
			preparedStatement.setInt(2, assigned.getProjectId());
			preparedStatement.setInt(3, assigned.getPaymentId());
			preparedStatement.setDouble(4, assigned.getAnnual());
			preparedStatement.setDouble(5, assigned.getCommission());
			System.out.println(preparedStatement);
			status = preparedStatement.executeUpdate()>0;
		} catch (SQLException e) {
			printSQLException(e);
		}
		
		return status;
	}

	public int insertPayment(Payment payment) throws SQLException {
		int id = 0;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PAYMENT_SQL,
						new String[] { "paymentid" })) {
			preparedStatement.setDouble(1, payment.getAmount());
			preparedStatement.setDate(2, payment.getDate());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				System.out.println("Generated ID: " + rs.getInt(1));
				id = rs.getInt(1);
				System.out.println("Payment created... ");

			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return id;
	}
	
	
	
}
