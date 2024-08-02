package com.java.service;

import java.util.List;

import com.java.dto.Todo;

public interface ITodoService {

	void insertTodo(Todo todo);

	Todo selectTodo(Integer id);

	List<Todo> selectAllTodo(Integer userId);

	void deleteTodo(Integer id);

	String updateTodo(Todo todo);
	
	

}
