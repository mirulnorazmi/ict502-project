package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Assigned;
import bean.Payment;
import bean.PaymentMonth;
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
	private static final String SELECT_ALL_PAYMENT_ASSIGNED = "SELECT p.paymentid, e.empname, pr.projectname , p.amount, p.paymentdate "
			+ "FROM employee e " + "JOIN assigned a ON e.empid = a.empid "
			+ "JOIN payment p ON a.paymentid = p.paymentid " + "JOIN project pr ON pr.projectid = a.projectid "
			+ "ORDER BY p.paymentid";
	private static final String DELETE_PAYMENT_SQL = "DELETE FROM payment WHERE paymentid=?";
	private static final String COUNT_PAYMENT_ALL = "SELECT COUNT(*) FROM PAYMENT";
	private static final String GET_MONTH_PAYMENT = "SELECT TO_CHAR(paymentdate, 'mm') AS month, "
			+ "COUNT(*) AS data_count " + "FROM payment "
			+ "WHERE TO_CHAR(paymentdate, 'YYYY') = TO_CHAR(SYSDATE, 'YYYY') " + "GROUP BY TO_CHAR(paymentdate, 'mm') "
			+ "ORDER BY TO_CHAR(paymentdate, 'mm') ";

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

	public int getTotalPayment() {
		int rowCount = 0;

		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_PAYMENT_ALL);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				rowCount = rs.getInt(1);
			}

		} catch (SQLException e) {
			printSQLException(e);
		}

		return rowCount;
	}

	public List<PaymentMonth> getMonthCount() {
		List<PaymentMonth> paymentMonth = new ArrayList<>();

		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(GET_MONTH_PAYMENT);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int month = rs.getInt("MONTH");
				int count = rs.getInt("DATA_COUNT");

				paymentMonth.add(new PaymentMonth(month, count));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}

		return paymentMonth;
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
			status = preparedStatement.executeUpdate() > 0;
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

	public List<Payment> selectAllPayment() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Payment> payment = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PAYMENT_ASSIGNED);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("paymentid");
				String empname = rs.getString("empname");
				String projectname = rs.getString("projectname");
				Double amount = rs.getDouble("amount");
				Date date = rs.getDate("paymentdate");

				payment.add(new Payment(id, amount, date, empname, projectname));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return payment;
	}

	public boolean deletePayment(Payment payment) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();) {
			PreparedStatement statement = connection.prepareStatement(DELETE_PAYMENT_SQL);
			statement.setInt(1, payment.getId());
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

}
