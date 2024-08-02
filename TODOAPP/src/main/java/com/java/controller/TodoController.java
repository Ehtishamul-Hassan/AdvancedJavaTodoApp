package com.java.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.dto.Todo;
import com.java.service.ITodoService;
import com.java.serviceFactory.TodoServiceFactory;

@WebServlet("/")
public class TodoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertUser(request, response);
			break;
		case "/delete":
			deleteTodo(request, response);
			break;
		case "/edit":
			break;
		case "/update":
			updateTodo(request, response);
			break;
		default:
			listTodo(request, response);
			break;
		}
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("addTodo.jsp");
		System.out.println("control in new form");
		HttpSession session = request.getSession();
		try {
			requestDispatcher.forward(request, response);

		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		ITodoService todoService = TodoServiceFactory.getTodoService();
		System.out.println("inside insert");

		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			try {
				response.sendRedirect("index.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}

		String title = request.getParameter("title");
		String description = request.getParameter("description");
		Date targetDate = java.sql.Date.valueOf(request.getParameter("targetDate"));
		Boolean status = Boolean.parseBoolean(request.getParameter("status"));

		Todo todo = new Todo();
		todo.setTitle(title);
		todo.setDescription(description);
		todo.setTargetDate(targetDate);
		todo.setStatus(status);
		todo.setUserId(userId);

		todoService.insertTodo(todo);
		System.out.println("data inserted successfully...");
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void listTodo(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		System.out.println("in the list todo");
		ITodoService todoService = TodoServiceFactory.getTodoService();

		Integer userId = (Integer) session.getAttribute("userId");
		System.out.println("userid is: " + userId);
		if (userId == null) {
			try {
				response.sendRedirect("login.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}

		List<Todo> todos = todoService.selectAllTodo(userId);
		System.out.println("inside the read");
		for (Todo todo : todos) {
			System.out.println(todo.toString());
		}

		try {
			session.setAttribute("todo", todos);
			response.sendRedirect("welcome.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void deleteTodo(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("inside delete");
		Integer id = Integer.parseInt(request.getParameter("id"));

		ITodoService todoService = TodoServiceFactory.getTodoService();
		todoService.deleteTodo(id);

		try {
			response.sendRedirect("list");
		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}
	}

	private void updateTodo(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			try {
				response.sendRedirect("login.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}

		System.out.println("update delete");
		Integer id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		Date targetDate = Date.valueOf(request.getParameter("targetDate"));
		Boolean status = Boolean.parseBoolean(request.getParameter("status"));

		Todo todo = new Todo();
		todo.setId(id);
		todo.setTitle(title);
		todo.setDescription(description);
		todo.setTargetDate(targetDate);
		todo.setStatus(status);
		todo.setUserId(userId);

		ITodoService todoService = TodoServiceFactory.getTodoService();
		String result = todoService.updateTodo(todo);

		try {
			session.setAttribute("msg", result);
			response.sendRedirect("list");
		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
