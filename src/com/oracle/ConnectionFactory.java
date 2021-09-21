package com.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {
	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection == null) {
			ResourceBundle rb = ResourceBundle.getBundle("com/oracle/dbConfig");
			String dc = rb.getString("driverclass");
			String url = rb.getString("url");
			String uname = rb.getString("username");
			String pass = rb.getString("password");

			try {
				Class.forName(dc);
			    connection = DriverManager.getConnection(url, uname, pass);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;

	}

}
