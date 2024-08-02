package com.java.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.java.dto.User;
import com.java.util.JdbcUtil;

public class UserDaoImpl implements IUserDao {

	@Override
	public Integer registerUser(User user) {

		PreparedStatement preparedStatement = null;

		try {
			Connection connection = JdbcUtil.getJdbcConnection();
			String insertQuery = "INSERT INTO users(firstName, lastName, email, password) VALUES (?, ?, ?, ?)";

			if (connection != null) {
				preparedStatement = connection.prepareStatement(insertQuery);

			}

			if (preparedStatement != null) {

				preparedStatement.setString(1, user.getFirstName());
				preparedStatement.setString(2, user.getLastName());
				preparedStatement.setString(3, user.getEmail());
				preparedStatement.setString(4, user.getPassword());

				int rowAffected = preparedStatement.executeUpdate();

				if (rowAffected == 1) {
					return 1;
				}
			}

		} catch (SQLException | IOException e) {

			e.printStackTrace();
		}

		return 0;
	}

}
