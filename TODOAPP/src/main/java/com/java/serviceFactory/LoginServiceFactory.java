package com.java.serviceFactory;

import com.java.service.ILoginService;
import com.java.service.LoginServiceImpl;

public class LoginServiceFactory {

	private LoginServiceFactory() {

	}

	private static ILoginService loginServiceImpl = null;

	public static ILoginService getLoginService() {

		if (loginServiceImpl == null) {
			loginServiceImpl = new LoginServiceImpl();
		}

		return loginServiceImpl;
	}

}
