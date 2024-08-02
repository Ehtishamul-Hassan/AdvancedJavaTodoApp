package com.java.serviceFactory;

import com.java.service.IUserService;
import com.java.service.UserServiceImpl;

public class UserServiceFactory {

	private UserServiceFactory() {

	}

	private static IUserService userServiceImpl = null;

	public static IUserService getUserService() {

		if (userServiceImpl == null) {

			userServiceImpl = new UserServiceImpl();

		}

		return userServiceImpl;
	}

}
