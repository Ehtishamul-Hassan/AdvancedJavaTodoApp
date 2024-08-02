package com.java.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.dto.Todo;
import com.java.util.JdbcUtil;

public class TodoDaoImpl implements ITodoDao {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public void insertTodo(Todo todo) {

		try {
			connection = JdbcUtil.getJdbcConnection();
			String insertQuery = "INSERT INTO todos (title, description, targetDate, status, user_id) VALUES (?, ?, ?, ?, ?)";

			if (connection != null) {
				preparedStatement = connection.prepareStatement(insertQuery);

			}

			if (preparedStatement != null) {

				preparedStatement.setString(1, todo.getTitle());
				preparedStatement.setString(2, todo.getDescription());
				preparedStatement.setDate(3, todo.getTargetDate());
				preparedStatement.setBoolean(4, todo.isStatus());
				preparedStatement.setInt(5, todo.getUserId());

				preparedStatement.executeUpdate();

			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Todo selectTodo(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Todo> selectAllTodo(Integer userId) {
		List<Todo> todoList = new ArrayList<>();

		try {
			connection = JdbcUtil.getJdbcConnection();
			String selectQuery = "SELECT id, title, description, targetDate, status FROM todos WHERE user_id=?";

			if (connection != null) {
				preparedStatement = connection.prepareStatement(selectQuery);
			}

			if (preparedStatement != null) {
				preparedStatement.setInt(1, userId);

				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					Integer id = resultSet.getInt(1);
					String title = resultSet.getString(2);
					String description = resultSet.getString(3);
					Date targetDate = resultSet.getDate(4);
					boolean status = resultSet.getBoolean(5);

					

					Todo todo = new Todo();
					todo.setId(id);
					todo.setTitle(title);
					todo.setDescription(description);
					todo.setTargetDate(targetDate);
					todo.setStatus(status);
					todo.setUserId(userId);
					System.out.println(todo.getId());

					todoList.add(todo);

				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return todoList;
	}

	@Override
	public void deleteTodo(Integer id) {

		try {
			Connection connection = JdbcUtil.getJdbcConnection();
			String deleteQuery = "DELETE FROM todos WHERE id=?";

			if (connection != null) {
				preparedStatement = connection.prepareStatement(deleteQuery);
			}

			if (preparedStatement != null) {
				preparedStatement.setInt(1, id);

				preparedStatement.executeUpdate();

			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String updateTodo(Todo todo) {

		try {
			connection = JdbcUtil.getJdbcConnection();
			String updateQuery = "UPDATE todos SET title = ?, description = ?, targetDate = ?, status = ? WHERE id = ?";

			if (connection != null) {
				preparedStatement = connection.prepareStatement(updateQuery);

			}

			if (preparedStatement != null) {

				preparedStatement.setString(1, todo.getTitle());
				preparedStatement.setString(2, todo.getDescription());
				preparedStatement.setDate(3, todo.getTargetDate());
				preparedStatement.setBoolean(4, todo.isStatus());
				preparedStatement.setInt(5, todo.getId());

				int rowAffected = preparedStatement.executeUpdate();

				if (rowAffected == 1) {
					return "RECORD UPDATED SUCCESSFULLY";
				}

			}

		} catch (SQLException | IOException e) {

			e.printStackTrace();
		}

		return "FAILED";
	}

}
