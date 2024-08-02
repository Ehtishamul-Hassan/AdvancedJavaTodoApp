package com.java.dao;

import com.java.dto.Login;
import com.java.dto.User;

public interface ILoginDao {

	User validate(Login login);

}
