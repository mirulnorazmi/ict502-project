<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="title" fragment="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PMS || <jsp:invoke fragment="title" /></title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
	rel="stylesheet">
<link rel="stylesheet" href="stylesheets/main.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<%
	String username = (String) session.getAttribute("name");
	String user;
	if (username == null) {
		user = "dev";
	} else {
		user = username;
	}
	%>
	<script>
	const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
	const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))
	</script>
	<nav class="navbar fixed-top" id="pageheader"
		style="background-color: #ffffff;">
		<div class="container d-flex jutify-content-between">
			<a class="navbar-brand"
				href="<%=request.getContextPath() + "/dashboard"%>"> <img
				src="img/flakepms-logo.png" alt="Logo" width="150">
			</a>
			<div class="d-flex flex-row align-items-center">
				<h6 style="margin: 0 15px 0 0;">
					Hi,
					<%=user%></h6>
				<a href="LogoutServlet">
					<button type="button" class="btn btn-outline-danger"
						data-bs-toggle="tooltip" data-bs-placement="bottom"
						data-bs-custom-class="custom-tooltip" data-bs-title="Logout"
						style="border-radius: 50px; width: 30px !important; display: flex; justify-content: center;">
						<i class="bi bi-box-arrow-left"></i>
					</button>
				</a>
			</div>

		</div>
	</nav>


	<div id="body">
		<div
			class="sidebar-dashboard col-2 flex-column flex-nowrap overflow-auto">
			<a href="<%=request.getContextPath() + "/dashboard"%>"
				class="nav-link active  mt-4" aria-current="page"><i
				class="bi bi-columns-gap" style="margin: 0 15px 0 30px;"></i>
				Dashboard </a> <br>
			<!-- nav -->
			<a href="<%=request.getContextPath() + "/employee"%>"
				class="nav-link active mt-3" aria-current="page"><i
				class="bi bi-person-square" style="margin: 0 15px 0 30px;"></i>
				Employee </a> <br>
			<!-- nav -->
			<a href="<%=request.getContextPath() + "/project"%>"
				class="nav-link active mt-3" aria-current="page"><i
				class="bi bi-kanban" style="margin: 0 15px 0 30px;"></i> Project </a> <br>

			<!-- nav -->
			<a href="<%=request.getContextPath() + "/payment"%>"
				class="nav-link active mt-3" aria-current="page"><i
				class="bi bi-bank" style="margin: 0 15px 0 30px;"></i> Payment </a><br>

			<!-- nav -->
			<a href="<%=request.getContextPath() + "/report"%>"
				class="nav-link active mt-3" aria-current="page"><i
				class="bi bi-bar-chart-fill" style="margin: 0 20px 0 30px;"></i> Report </a>

		</div>
		<div class="col-10 offset-2 main-section">
			<jsp:doBody />
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
</body>
</html>
