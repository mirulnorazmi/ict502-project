import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertQuery {

	public static void main(String[] args) throws Exception {
		try {
			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// step2 create the connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "system");
			// step3 create the statement object
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO COUNTRIES(COUNTRY_ID,COUNTRY_NAME,REGION_ID) VALUES ('ID','Indonesia', 2)";
			// step4 execute query
			stmt.executeUpdate(sql);
			// step5 close the connection object
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
