package com.java.service;

import com.java.dao.IUserDao;
import com.java.daoFactory.UserDaoFactory;
import com.java.dto.User;

public class UserServiceImpl implements IUserService {

	@Override
	public Integer registerUser(User user) {
		
		IUserDao userDao = UserDaoFactory.getUserDao();
		
		return userDao.registerUser(user);
	}

}
