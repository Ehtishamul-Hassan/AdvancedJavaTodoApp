package com.java.daoFactory;

import com.java.dao.ILoginDao;
import com.java.dao.LoginDaoImpl;

public class LoginDaoFactory {

	private LoginDaoFactory() {

	}

	private static ILoginDao loginDaoImpl = null;

	public static ILoginDao getLoginDao() {

		if (loginDaoImpl == null) {

			loginDaoImpl = new LoginDaoImpl();

		}

		return loginDaoImpl;
	}

}
