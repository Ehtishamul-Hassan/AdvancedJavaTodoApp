package com.java.daoFactory;

import com.java.dao.ITodoDao;
import com.java.dao.TodoDaoImpl;

public class TodoDaoFactory {

	private TodoDaoFactory() {

	}

	private static ITodoDao todoDaoImpl = null;

	public static ITodoDao getTodoDao() {

		if (todoDaoImpl == null) {
			todoDaoImpl = new TodoDaoImpl();
		}

		return todoDaoImpl;

	}

}
