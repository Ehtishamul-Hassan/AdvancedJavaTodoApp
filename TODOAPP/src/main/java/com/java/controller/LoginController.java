package com.java.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.dto.Login;
import com.java.dto.User;
import com.java.service.ILoginService;
import com.java.serviceFactory.LoginServiceFactory;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response) {

		ILoginService loginService = LoginServiceFactory.getLoginService();

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Login login = new Login();

		login.setEmail(email);

		login.setPassword(password);

		// Validate the login credentials
		User user = loginService.validate(login);

		try {
			if (user != null) {
				// If the login is successful, create a session
				HttpSession session = request.getSession();

				session.setAttribute("userId", user.getId()); // Store the username in the session
				session.setAttribute("firstName", user.getFirstName());
				session.setAttribute("status", "Login Successful!");

				// Redirect to a welcome page or home page
				response.sendRedirect(request.getContextPath() + "/");

			} else {
				// If the login fails, set an error message in the request
				System.out.println("invalid");
				HttpSession session = request.getSession();
				session.setAttribute("check", "Invalid username or password");

				// Forward back to the login page
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
