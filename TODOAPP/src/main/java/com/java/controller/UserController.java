package com.java.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.dto.User;
import com.java.service.IUserService;
import com.java.serviceFactory.UserServiceFactory;

@WebServlet("/register")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);

	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response) {

		IUserService userService = UserServiceFactory.getUserService();

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = new User();

		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);

		Integer status = userService.registerUser(user);

		try {
			if (status == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("status", "User Registered Successfully!");
			}

			// Redirect to the register page to avoid form resubmission
			response.sendRedirect("register.jsp");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
