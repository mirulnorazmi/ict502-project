
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<head>
<link rel="stylesheet" href="stylesheets/main.css" />
<link rel="stylesheet" href="stylesheets/dashboard.css" />
<script src="https://code.jquery.com/jquery-3.7.0.js"
	integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
	crossorigin="anonymous"></script>
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
			class="d-flex flex-column justify-content-center align-items-center">
		<div
				class="jumbotron jumbotron-fluid-employee col-11 d-flex align-items-center">
			<div class="form-floating"> 
			<p class="h1 col-10"
						style="font-size: 20px; padding: 0 0 0 50px; color: #FFFFFF;">
				Unlock the power of seamless transactions with our secure and efficient payment solutions.
			</p>
			
			</div>
		</div>
		<form action="" method="post" class="col-11 mt-1">
			
			<div class="grid gap-1">
			  <div class="p-2 g-col-6">
				 <label for="exampleFormControlInput1" class="form-label">Email</label>
				 <!-- <input name="email" type="email" class="form-control"
							id="exampleFormControlInput1" placeholder="example@gmail.com"> -->
				 <select class="form-select" aria-label="email select" name="email">
					  <option value="" disabled selected>Select email</option>
					  <c:forEach var="user" items="${listUser}">
					  	 <option value="${user.email }"><c:out
										value="${user.email }" /></option>
					  </c:forEach>
					 
				 </select>
			  </div> 
			  <div class="p-2 g-col-6">
				 <label for="exampleFormControlInput1" class="form-label">Project</label>
				 <select class="form-select" aria-label="project select"
							name="project">
					  <option value="" disabled selected>Select project</option>
					  <c:forEach var="proj" items="${listProject}">
					  	 <option value="${proj.name }"><c:out
										value="${proj.name }" /></option>
					  </c:forEach>
					 
				 </select>
			  </div> 
			  <div class="d-flex flex-column g-col-6 mt-3">
			  	<p class="h6">Employee annual and commission</p>
			  	<div class="p-2 d-flex flex-row justify-content-between">
			  
				  <div class="col-6" style="padding: 0 10px 0 0">
				  	<label for="exampleFormControlInput1" class="form-label">Annual Salary</label>
				  	<div class="input-group">
					  	<span class="input-group-text" id="basic-addon1">RM</span>
						<input name="annual" type="number" class="form-control"
									id="exampleFormControlInput1" placeholder="50000">
					</div>
				  </div>    
				  <div class="col-6" style="padding: 0 0 0 10px">
					<label for="exampleFormControlInput1" class="form-label">Commission</label>
				  	<div class="input-group">
					  	<span class="input-group-text" id="basic-addon1">RM</span>
						<input name="commission" type="number" class="form-control"
									id="exampleFormControlInput1" value="0">
					</div> 
				  </div>
			  </div>
			  </div>
			  <div class="d-flex flex-column g-col-6 mt-3">
			  	<p class="h6">Payment details</p>
			  <div class="p-2 d-flex flex-row justify-content-between">
				  <div class="col-6" style="padding: 0 10px 0 0">
				  	<label for="exampleFormControlInput1" class="form-label">Amount</label>
					<div class="input-group">
					  	<span class="input-group-text" id="basic-addon1">RM</span>
						<input name="amount" type="number" class="form-control"
									id="exampleFormControlInput1" placeholder="100">
					</div>
				  </div>
				  <div class="col-6" style="padding: 0 10px 0 0">
				  	<label for="exampleFormControlInput1" class="form-label">Date</label>
					<input name="date" type="date" class="form-control" id="minDate"
								id="exampleFormControlInput1">
				  </div>
			  </div>
			  </div>
			  
			  <div class="p-2 g-col-6">
			  	<a
							href="<c:out value="${pageContext.servletContext.contextPath}" />/payment">
			  		<button type="button" class="btn btn-outline-danger">Cancel</button>
			  	</a>
			  </div>
			  <div class="p-2 g-col-6 d-flex justify-content-end"> 
			  	<button type="reset" class="btn btn-outline-danger"
							style="margin-right: 10px;">Reset</button>
			  	<button type="submit" class="btn btn-outline-primary">Create</button>
			  </div> 
			  
			</div>
			 
		</form>
	</div>
	<script>
		$(document).ready(function() {
			var today = new Date().toISOString().split('T')[0];
			$("#minDate").attr('min', today);
			$("#minDate").attr('value', today);
			console.log($("#minDate").attr('value', today));
		});
	</script> 
    </jsp:body>
</t:dashboard>