package com.java.service;

import com.java.dao.ILoginDao;
import com.java.daoFactory.LoginDaoFactory;
import com.java.dto.Login;
import com.java.dto.User;

public class LoginServiceImpl implements ILoginService {

	@Override
	public User validate(Login login) {

		ILoginDao loginDao = LoginDaoFactory.getLoginDao();

		return loginDao.validate(login);
	}

}
