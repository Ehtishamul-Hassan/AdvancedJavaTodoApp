package com.java.service;

import com.java.dto.Login;
import com.java.dto.User;

public interface ILoginService {
	
	User validate(Login login);

}
