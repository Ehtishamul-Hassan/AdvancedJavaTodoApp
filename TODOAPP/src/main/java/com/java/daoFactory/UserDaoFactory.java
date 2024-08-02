package com.java.daoFactory;

import com.java.dao.IUserDao;
import com.java.dao.UserDaoImpl;

public class UserDaoFactory {

	private UserDaoFactory() {

	}

	private static IUserDao userDaoImpl = null;

	public static IUserDao getUserDao() {

		if (userDaoImpl == null) {
			userDaoImpl = new UserDaoImpl();
		}

		return userDaoImpl;

	}

}
