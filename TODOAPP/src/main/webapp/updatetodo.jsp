<%@page import="com.java.dto.Todo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Update TODO</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

	<%
	Integer id = Integer.parseInt(request.getParameter("index"));
	ArrayList<Todo> arrayList = (ArrayList<Todo>) session.getAttribute("todo");
	Todo uid = arrayList.get(id);
	%>

	<div class="container">
		<h1 class="mt-5">UPDATE TODO</h1>
		

		<!-- Update TODO Form Section -->
		<form action="update" method="post" class="mb-5">
			<!-- Hidden field to pass the ID -->
			<input type="hidden" name="id" value="<%=uid.getId()%>">

			<div class="form-group">
				<label for="title">Title</label> <input type="text"
					class="form-control" id="title" name="title"
					value="<%=uid.getTitle()%>" required>
			</div>
			<div class="form-group">
				<label for="description">Description</label>
				<textarea class="form-control" id="description" name="description"
					required><%=uid.getDescription()%></textarea>
			</div>
			<div class="form-group">
				<label for="targetDate">Target Date</label> <input type="date"
					class="form-control" id="targetDate" name="targetDate"
					value="<%=uid.getTargetDate()%>" required>
			</div>
			<div class="form-group">
				<label for="status">Status</label> <select class="form-control"
					id="status" name="status">
					<option value="false" <%=!uid.isStatus() ? "selected" : ""%>>Pending</option>
					<option value="true" <%=uid.isStatus() ? "selected" : ""%>>Completed</option>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Update TODO</button>
		</form>
	</div>
</body>
</html>
