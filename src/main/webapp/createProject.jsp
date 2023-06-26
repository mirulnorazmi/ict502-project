
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<head>
<link rel="stylesheet" href="stylesheets/main.css" />
</head>
<t:dashboard>
	<jsp:attribute name="title">
      Employee
    </jsp:attribute>
	<jsp:attribute name="header">
      <h1>Welcome</h1>  
    </jsp:attribute>

	<jsp:body>
	<div
			class="d-flex flex-column justify-content-center align-items-start">
		<nav style="-bs-breadcrumb-divider: '&gt;';" aria-label="breadcrumb">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a
						href="<c:out value="${pageContext.servletContext.contextPath}" />/project">Project</a></li>
		    <li class="breadcrumb-item active" aria-current="page">Create Project</li>
		  </ol>
		</nav> 
		<div
				class="d-flex flex-column justify-content-center align-items-center mt-4">
			<h4>Create Project</h4> 
			<form action="createproject" method="post">
			  <div class="mb-3">
			    <label class="form-label">Project Name</label>
			    <input type="text" class="form-control" name="name"
							aria-describedby="projectName">
			  </div>
			  <div class="mb-3">
			    <label class="form-label">Department</label>
			    <input type="text" class="form-control" name="department"
							aria-describedby="projectDepartment">
			  </div>
			  <div class="mb-3">
			    <label class="form-label">Salary</label>
			    <input type="text" class="form-control" name="salary"
							aria-describedby="projectSalary">
			  </div>
			  <div>
			  	<button type="reset" class="btn btn-danger">Reset</button>
			  	<button type="submit" class="btn btn-primary">Create</button>
			  </div>
			</form>
		</div>
	</div>
    </jsp:body>
</t:dashboard>