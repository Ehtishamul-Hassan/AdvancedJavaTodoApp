package com.java.serviceFactory;

import com.java.service.ITodoService;
import com.java.service.TodoServiceImpl;

public class TodoServiceFactory {

	private TodoServiceFactory() {

	}

	private static ITodoService todoServiceImpl = null;

	public static ITodoService getTodoService() {

		if (todoServiceImpl == null) {

			todoServiceImpl = new TodoServiceImpl();

		}

		return todoServiceImpl;
	}

}
