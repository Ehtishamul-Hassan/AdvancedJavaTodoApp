<%@page import="com.java.dto.Todo"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>TODO List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<style>
.btn-custom {
	margin: 0 10px;
}

.user-info {
	position: absolute;
	top: 10px;
	right: 30px;
	text-align: center;
}

.user-info i {
	font-size: 30px;
}
</style>
</head>
<body>
	<%
	ArrayList<Todo> arrayList = (ArrayList<Todo>) session.getAttribute("todo");
	Integer index = 0;

	// Retrieve the message and set it to null
	String message = (String) session.getAttribute("msg");
	if (message != null) {
		session.setAttribute("msg", null);
	}
	%>
	<div class="container">
		<!-- User Icon and Username -->
		<div class="user-info">
			<i class="fas fa-user"></i>
			<p><%=session.getAttribute("firstName")%></p>
			<a href="<%=request.getContextPath()%>/logout"
				class="btn btn-danger logout-btn">Logout</a>

		</div>

		<h1 class="mt-5">TODO List</h1>

		<!-- Button to redirect to Add TODO page -->
		<a href="<%=request.getContextPath()%>/new"
			class="btn btn-primary mb-3">Add New TODO</a>


		<!-- TODO List Section -->
		<h2>Your TODO List</h2>
		<h3></h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Title</th>
					<th>Description</th>
					<th>Target Date</th>
					<th>Status</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Todo todos : arrayList) {
				%>
				<tr>
					<td><c:out value="<%=todos.getTitle()%>" /></td>
					<td><c:out value="<%=todos.getDescription()%>" /></td>
					<td><c:out value="<%=todos.getTargetDate()%>" /></td>
					<td><c:choose>
							<c:when test="<%=todos.isStatus()%>">
                                Completed
                            </c:when>
							<c:otherwise>
                                Pending
                            </c:otherwise>
						</c:choose></td>
					<td>
						<!-- Action Buttons -->
						<div class="btn-group" role="group" aria-label="Actions">
							<!-- Update Button -->
							<form action="updatetodo.jsp?index=<%=index%>" method="post"
								style="display: inline;">
								<input type="hidden" name="id" value="<%=todos.getId()%>">
								<button type="submit" class="btn btn-warning">Update</button>
							</form>
							<!-- Delete Button -->
							<form action="<%=request.getContextPath()%>/delete" method="post"
								style="display: inline;">
								<input type="hidden" name="id" value="<%=todos.getId()%>">
								<button type="submit" class="btn btn-danger btn-custom">Delete</button>
							</form>
						</div>
					</td>
				</tr>
				<%
				index++;
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>
