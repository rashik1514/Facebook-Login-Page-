package loginPage;



import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FacebookDatabase {

	final private String dbName = "facebook.db";
	final private String url = "jdbc:sqlite:" + dbName;
	final private String tableName = "Facebook";

	private Connection connect() {
		// SQLite connection string

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public void createNewDatabase() {

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created.");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void createNewTable() {
		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (\n" + "	email text PRIMARY KEY,\n"
				+ "	password text,\n" + "	firstName text,\n" + "	lastName text,\n" + "	birthday text,\n"
				+ "	age text\n" + ");";

		try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
			System.out.println("Table created sucessfully.");
			System.out.println(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void insert(String email, String password, String firstName, String lastName, String birthday, String age) {
		String sql = "INSERT INTO " + tableName
				+ " (email,password,firstName,lastName,birthday,age) VALUES(?,?,?,?,?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			pstmt.setString(3, firstName);
			pstmt.setString(4, lastName);
			pstmt.setString(5, birthday);
			pstmt.setString(6, age);
			pstmt.executeUpdate();
			System.out.println("Account Created Successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void showAllInformationInDatabase() {
		String sql = "SELECT email, password, firstName, lastName, birthday, age FROM " + tableName + "";

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				System.out.println(rs.getString("email") + "\t" + rs.getString("password") + "\t"
						+ rs.getString("firstName") + "\t" + rs.getString("lastName") + "\t" + rs.getString("birthday")
						+ "\t" + rs.getString("age") + "\t");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}

