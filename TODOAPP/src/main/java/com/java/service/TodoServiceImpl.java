package com.java.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.java.dao.ITodoDao;
import com.java.daoFactory.TodoDaoFactory;
import com.java.dto.Todo;
import com.java.util.JdbcUtil;

public class TodoServiceImpl implements ITodoService {

	@Override
	public void insertTodo(Todo todo) {

		ITodoDao todoDao = TodoDaoFactory.getTodoDao();

		todoDao.insertTodo(todo);

	}

	@Override
	public Todo selectTodo(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Todo> selectAllTodo(Integer userId) {

		ITodoDao todoDao = TodoDaoFactory.getTodoDao();

		return todoDao.selectAllTodo(userId);
	}

	@Override
	public void deleteTodo(Integer id) {

		ITodoDao todoDao = TodoDaoFactory.getTodoDao();

		todoDao.deleteTodo(id);

	}

	@Override
	public String updateTodo(Todo todo) {

		ITodoDao todoDao = TodoDaoFactory.getTodoDao();

		return todoDao.updateTodo(todo);

	}

}
