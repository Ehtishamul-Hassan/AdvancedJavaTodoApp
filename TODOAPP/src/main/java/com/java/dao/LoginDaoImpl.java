package com.java.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.dto.Login;
import com.java.dto.User;
import com.java.util.JdbcUtil;

public class LoginDaoImpl implements ILoginDao {

	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public User validate(Login login) {
		try {
			Connection connection = JdbcUtil.getJdbcConnection();
			String selectQuery = "SELECT id, firstName, lastName, email , password FROM users WHERE email=? AND password=?";

			if (connection != null) {
				preparedStatement = connection.prepareStatement(selectQuery);
			}

			if (preparedStatement != null) {
				preparedStatement.setString(1, login.getEmail());
				preparedStatement.setString(2, login.getPassword());

				resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					User user = new User();
					user.setId(resultSet.getInt("id"));
					user.setFirstName(resultSet.getString("firstName"));
					user.setLastName(resultSet.getString("lastName"));
					user.setEmail(resultSet.getString("email"));
					user.setPassword(resultSet.getString("password"));
					return user;
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			// Close resources
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				// Do not close connection here if you are using a connection pool
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
