package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Fulltime;
import bean.Parttime;
import bean.Projects;
import bean.Users;
import oracle.jdbc.OracleTypes;

public class EmployeeService {
	private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String jdbcUsername = "dbpms";
	private String jdbcPassword = "system";

	private static final String SELECT_ALL_USERS = "select * from employee order by empid";
//    private static final String SELECT_EMPLOYEE_ID = "SELECT e.empid,f.empid \"fulltime_id\", p.empid \"parrtime_id\", empname, empphone, empemail, empage, empgender, emproleid, annualleave, sickleave, insurance, unpaidleave, hourlyrate, startdate, enddate "
//    		+ "FROM employee e "
//    		+ "LEFT OUTER JOIN fulltime f "
//    		+ "ON (e.empid = f.empid) "
//    		+ "LEFT OUTER JOIN parttime p "
//    		+ "ON (e.empid = p.empid) WHERE e.empid=?";
	private static final String SELECT_ALL_USERS_ROLE = "SELECT e.empid \"employee_id\",CASE "
			+ "WHEN f.empid IS NOT NULL THEN 'fulltime' " + "WHEN p.empid IS NOT NULL THEN 'parttime' "
			+ "ELSE 'Unknown' " + "END AS category, " + "empname, empphone, empemail, empage, empgender, emproleid "
			+ "FROM employee e " + "LEFT OUTER JOIN fulltime f " + "ON (e.empid = f.empid) "
			+ "LEFT OUTER JOIN parttime p " + "ON (e.empid = p.empid) ORDER BY e.empid";
	private static final String SELECT_FULLTIME_ID = "SELECT * FROM employee JOIN fulltime ON (employee.empid = fulltime.empid) WHERE employee.empid=?";
	private static final String SELECT_PARTTIME_ID = "SELECT * FROM employee JOIN parttime ON (employee.empid = parttime.empid) WHERE employee.empid=?";
	private static final String SELECT_EMPLOYEE_EMAIL = "SELECT * FROM employee WHERE empemail=?";
	private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee(empname, empphone, empemail, empage, empgender, emproleid)"
			+ "VALUES(?,?,?,?,?,?)";
	private static final String INSERT_FULLTIME_SQL = "INSERT INTO fulltime(empid, annualleave, sickleave, insurance, unpaidleave)"
			+ "VALUES (?,?,?,?,?)";
	private static final String INSERT_PARTTIME_SQL = "INSERT INTO parttime(empid, startdate, enddate, hourlyrate)"
			+ "VALUES (?,?,?,?)";
	private static final String UPDATE_EMPLOYEE_SQL = "UPDATE employee SET empname=?, empphone=?, empemail=?, empage=?, "
			+ "empgender=?, emproleid=? WHERE empid=?";
	private static final String UPDATE_PARTTIME_SQL = "UPDATE parttime SET startdate=?, enddate=?, hourlyrate=? WHERE empid=?";
	private static final String UPDATE_FULLTIME_SQL = "UPDATE fulltime SET annualleave=?, sickleave=?, insurance=?, unpaidleave=? WHERE empid=?";
	private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM employee WHERE empid=?";
	private static final String DELETE_FULLTIME_SQL = "DELETE FROM fulltime WHERE empid=?";
	private static final String DELETE_PARTTIME_SQL = "DELETE FROM parttime WHERE empid=?";

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

	public boolean checkEmail(Users users) {
		boolean status = false;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_EMAIL)) {
			preparedStatement.setString(1, users.getEmail());

			ResultSet rs = preparedStatement.executeQuery();
			System.out.println("Display email...");
//			if true email is exist
			status = rs.next();
			if (status) {
				System.out.println("email already exist...");
			}

		} catch (SQLException e) {
			printSQLException(e);
			status = true;
		}

		return status;
	}

	public List<Users> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Users> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS_ROLE);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("employee_id");
				String category = rs.getString("category");
				String name = rs.getString("empname");
				String phone = rs.getString("empphone");
				String email = rs.getString("empemail");
				int age = rs.getInt("empage");
				String gender = rs.getString("empgender");
				int roleId = rs.getInt("emproleid");

				users.add(new Users(id, name, phone, email, age, gender, roleId, category));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public int insertEmployee(Users users) {
		int id = 0;
		if (!checkEmail(users)) {
			try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL,
							new String[] { "empid" })) {
				preparedStatement.setString(1, users.getName());
				preparedStatement.setString(2, users.getPhone());
				preparedStatement.setString(3, users.getEmail());
				preparedStatement.setInt(4, users.getAge());
				preparedStatement.setString(5, users.getGender());
				preparedStatement.setInt(6, users.getRoleId());

				preparedStatement.executeUpdate();
				System.out.println("executed...");
				ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
//				System.out.println("generatedKeys next:" + generatedKeys.next());
				if (generatedKeys.next()) {
					System.out.println("Generated ID: " + generatedKeys.getInt(1));
					id = generatedKeys.getInt(1);

				}

			} catch (SQLException e) {
				printSQLException(e);
				id = 0;
			}
		}

		return id;
	}

	public boolean insertFulltime(Fulltime fulltime) throws SQLException {
		boolean status = false;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FULLTIME_SQL)) {
			int id = insertEmployee(new Users(fulltime.getName(), fulltime.getPhone(), fulltime.getEmail(),
					fulltime.getAge(), fulltime.getGender(), fulltime.getRoleId()));
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, fulltime.getAnnualLeave());
			preparedStatement.setInt(3, fulltime.getSickLeave());
			preparedStatement.setString(4, fulltime.getInsurance());
			preparedStatement.setInt(5, fulltime.getUnpaidLeave());

			preparedStatement.executeUpdate();

			status = true;

		} catch (SQLException e) {
			printSQLException(e);
			status = false;
		}

		return status;
	}

	public boolean insertParttime(Parttime parttime) throws SQLException {
		boolean status = false;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PARTTIME_SQL)) {
			int id = insertEmployee(new Users(parttime.getName(), parttime.getPhone(), parttime.getEmail(),
					parttime.getAge(), parttime.getGender(), parttime.getRoleId()));
			preparedStatement.setInt(1, id);
			preparedStatement.setDate(2, parttime.getStartdate());
			preparedStatement.setDate(3, parttime.getEnddate());
			preparedStatement.setDouble(4, parttime.getHourlyrate());

			preparedStatement.executeUpdate();

			status = true;

		} catch (SQLException e) {
			printSQLException(e);
			status = false;
		}

		return status;
	}

	public Fulltime getOneFulltime(Users usr) {
		Fulltime fulltime = null;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FULLTIME_ID)) {
			preparedStatement.setInt(1, usr.getId());

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("empid");
				String name = rs.getString("empname");
				String phone = rs.getString("empphone");
				String email = rs.getString("empemail");
				int age = rs.getInt("empage");
				String gender = rs.getString("empgender");
				int annualLeave = rs.getInt("annualleave");
				int sickLeave = rs.getInt("sickleave");
				String insurance = rs.getString("insurance");
				int unpaidLeave = rs.getInt("unpaidleave");

				System.out.println("employee id : " + id);

				fulltime = new Fulltime(id, name, phone, email, age, gender, annualLeave, sickLeave, insurance,
						unpaidLeave);
			}

		} catch (SQLException e) {
			printSQLException(e);
		}

		return fulltime;
	}

	public Parttime getOneParttime(Users usr) {
		Parttime parttime = null;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PARTTIME_ID)) {
			preparedStatement.setInt(1, usr.getId());

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("empid");
				String name = rs.getString("empname");
				String phone = rs.getString("empphone");
				String email = rs.getString("empemail");
				int age = rs.getInt("empage");
				String gender = rs.getString("empgender");
				Double hourlyRate = rs.getDouble("hourlyRate");
				Date startDate = rs.getDate("startdate");
				Date endDate = rs.getDate("enddate");

				System.out.println("employee id : " + id);

				parttime = new Parttime(id, name, phone, email, age, gender, hourlyRate, startDate, endDate);
			}

		} catch (SQLException e) {
			printSQLException(e);
		}

		return parttime;
	}

	public boolean updateEmployee(Users users) throws SQLException {
		boolean status = false;
		if (!checkEmail(users)) {
			try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL)) {
				preparedStatement.setString(1, users.getName());
				preparedStatement.setString(2, users.getPhone());
				preparedStatement.setString(3, users.getEmail());
				preparedStatement.setInt(4, users.getAge());
				preparedStatement.setString(5, users.getGender());
				preparedStatement.setInt(6, users.getRoleId());
				preparedStatement.setInt(7, users.getId());
				preparedStatement.executeUpdate();
				status = true;
				System.out.println(users.getId());

			} catch (SQLException e) {
				printSQLException(e);
				status = false;
			}
		}

		return status;
	}

	public boolean updateParttime(Parttime parttime) throws SQLException {
		boolean status = false;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PARTTIME_SQL)) {
			boolean statusEmp = updateEmployee(new Users(parttime.getId(), parttime.getName(), parttime.getPhone(),
					parttime.getEmail(), parttime.getAge(), parttime.getGender(), parttime.getRoleId()));

			preparedStatement.setDate(1, parttime.getStartdate());
			preparedStatement.setDate(2, parttime.getEnddate());
			preparedStatement.setDouble(3, parttime.getHourlyrate());
			preparedStatement.setInt(4, parttime.getId());

			preparedStatement.executeUpdate();

			status = true;
			System.out.println("Employee update : " + statusEmp);
			System.out.println("Employee parttime : " + status);

		} catch (SQLException e) {
			printSQLException(e);
			status = false;
		}

		return status;
	}

	public boolean updateFulltime(Fulltime fulltime) throws SQLException {
		boolean status = false;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FULLTIME_SQL)) {
			boolean statusEmp = updateEmployee(new Users(fulltime.getId(), fulltime.getName(), fulltime.getPhone(),
					fulltime.getEmail(), fulltime.getAge(), fulltime.getGender(), fulltime.getRoleId()));
			preparedStatement.setInt(1, fulltime.getAnnualLeave());
			preparedStatement.setInt(2, fulltime.getSickLeave());
			preparedStatement.setString(3, fulltime.getInsurance());
			preparedStatement.setInt(4, fulltime.getUnpaidLeave());
			preparedStatement.setInt(5, fulltime.getId());
			System.out.println("insurance dao : " + fulltime.getInsurance());
			preparedStatement.executeUpdate();

			status = true;
			System.out.println("Employee update : " + statusEmp);
			System.out.println("Employee fulltime : " + status);
		} catch (SQLException e) {
			printSQLException(e);
			status = false;
		}

		return status;
	}

	public boolean deleteEmployee(Users users) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();) {
			PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);
			statement.setInt(1, users.getId());
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean deleteFulttime(Fulltime fulltime) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();) {
			PreparedStatement statement = connection.prepareStatement(DELETE_FULLTIME_SQL);
			statement.setInt(1, fulltime.getId());
			rowDeleted = statement.executeUpdate() > 0;
			if (rowDeleted) {
				boolean status = deleteEmployee(fulltime);
				System.out.println("Delete employee : " + status);
			}
		}
		return rowDeleted;
	}

	public boolean deleteParttime(Parttime parttime) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();) {
			PreparedStatement statement = connection.prepareStatement(DELETE_PARTTIME_SQL);
			statement.setInt(1, parttime.getId());
			rowDeleted = statement.executeUpdate() > 0;
			if (rowDeleted) {
				boolean status = deleteEmployee(parttime);
				System.out.println("Delete employee : " + status);
			}
		}
		return rowDeleted;
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
