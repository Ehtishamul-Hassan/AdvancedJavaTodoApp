<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
	integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>

	<!-- navbar start  -->

	<nav class="navbar navbar-expand-lg navbar-custom">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">TODOAPP</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">

					<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
					<li class="nav-item"><a class="nav-link" href="register.jsp">Register</a></li>
				</ul>

			</div>
		</div>
	</nav>
	<!-- navbar end  -->

	<!-- error message start -->
	<div class="container mt-3">
		<%
		String status = (String) request.getAttribute("status");
		if (status != null) {
		%>
		<div class="alert alert-danger alert-dismissible fade show"
			role="alert">
			<%=status%>
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
		<%
		}
		%>
	</div>
	<!-- error message end -->

	<!-- login form start -->
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">


					<!-- error message start -->
					<div class="container mt-3">
						<%
						String check = (String) session.getAttribute("check");
						if (check != null) {
						%>
						<div class="alert alert-danger alert-dismissible fade show"
							role="alert">
							<%=check%>
							<button type="button" class="btn-close" data-bs-dismiss="alert"
								aria-label="Close"></button>
						</div>
						<%
						}
						%>
					</div>
					<!-- error message end -->

					<!-- success alert start -->
					<div class="container mt-3">
						<%
						String message = (String) request.getAttribute("message");
						if (message != null) {
						%>
						<div class="alert alert-success alert-dismissible fade show"
							role="alert">
							<%=message%>

							<button type="button" class="btn-close" data-bs-dismiss="alert"
								aria-label="Close"></button>
						</div>
						<%
						request.removeAttribute("message"); // Remove the attribute after displaying it
						}
						%>
					</div>
					<!-- success alert end -->
					<div class="card-header text-center">
						<h3 class="navbar-custom">Login</h3>
					</div>
					<div class="card-body">
						<form action="${pageContext.request.contextPath}/login"
							method="post">
							<div class="mb-3">
								<label for="username" class="form-label">Email</label> <input
									type="text" class="form-control" id="username" name="email"
									required>
							</div>
							<div class="mb-3">
								<label for="password" class="form-label">Password</label> <input
									type="password" class="form-control" id="password"
									name="password" required>
							</div>
							<div class="d-grid">
								<button type="submit" class="btn btn-primary">Login</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- login form end -->

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

</body>
</html>
