package org.qa.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbManager {

	private static Connection conn = null; // MySql
	private static Connection con = null; // Sql
	private static Connection Ocon = null; // Oracle

	public static void setConnection() throws ClassNotFoundException {
		try {
			Class.forName(TestConfig.mysql_driver);
			conn = DriverManager.getConnection(TestConfig.mysql_Url);
			if (!conn.isClosed()) {
				System.out.println("MySql COnnected Successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<String> getQuery(String Query) throws SQLException {

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(Query);
		List<String> values = new ArrayList<String>();
		while (rs.next()) {
			values.add(rs.getInt(1) + " " + rs.getString(2) + rs.getString(3) + "  " + rs.getString(4) + " "
					+ rs.getString(5));
		}
		System.out.println(values);
		return values;
	}
	
//	public static Connection getConnection()
//	{
//		return conn;
//			}
}
