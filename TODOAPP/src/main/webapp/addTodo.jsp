<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Add TODO</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1 class="mt-5">Add TODO</h1>

		<!-- Add TODO Form Section -->
		<form action="<%=request.getContextPath()%>/insert" method="post"
			class="mb-5">
			<input type="hidden" name="action" value="add">
			<div class="form-group">
				<label for="title">Title</label> <input type="text"
					class="form-control" id="title" name="title" required>
			</div>
			<div class="form-group">
				<label for="description">Description</label>
				<textarea class="form-control" id="description" name="description"
					required></textarea>
			</div>
			<div class="form-group">
				<label for="targetDate">Target Date</label> <input type="date"
					class="form-control" id="targetDate" name="targetDate" required>
			</div>
			<div class="form-group">
				<label for="status">Status</label> <select class="form-control"
					id="status" name="status">
					<option value="false">Pending</option>
					<option value="true">Completed</option>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Add TODO</button>
		</form>
	</div>
</body>
</html>
