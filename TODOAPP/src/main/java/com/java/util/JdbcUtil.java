package com.java.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {

	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	private JdbcUtil() {

	}

	public static Connection getJdbcConnection() throws SQLException, IOException {

		HikariConfig config = new HikariConfig(
				"C:\\Users\\asifh\\eclipse-workspace-SERVLET\\TODOAPP\\src\\main\\java\\com\\java\\properties\\application.properties");

		HikariDataSource dataSource = new HikariDataSource(config);

		return dataSource.getConnection();

	}

}
