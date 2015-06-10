package edu.model2.bean;

import java.sql.*;

public class DBConnection {

	private Connection connection = null;

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection(
							"jdbc:mysql://localhost/Attend?useUnicode=true&characterEncoding=utf-8",
							"root", "123");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return connection;
	}

	public void closeConnection(Connection connection) {
		try {
			if (connection != null)
				connection.close();
			connection = null;
		} catch (SQLException e3) {
			e3.printStackTrace();
		}
	}
}
