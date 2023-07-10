
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<head>
<link rel="stylesheet" href="stylesheets/main.css" />
<link rel="stylesheet" href="stylesheets/dashboard.css" />
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
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
		<div class="jumbotron jumbotron-fluid-employee col-11 d-flex align-items-center">
			<div class="form-floating"> 
			<p class="h1 col-8" style="font-size: 20px; padding: 0 0 0 50px; color: #FFFFFF;">
				We value the contributions of part-time employees, leveraging their unique skills and flexibility to enhance our team.
			</p>
			
			</div>
		</div>
		<form action="" method="post" class="col-11 mt-1">
			<div class="grid gap-1">
			  <div class="p-2 g-col-6">
				 <label for="exampleFormControlInput1" class="form-label">Name</label>
				 <input name="name" type="text" class="form-control"
							id="exampleFormControlInput1" placeholder="Ahmad bin Kassim">
			  </div>
			  <div class="p-2 g-col-6">
				 <label for="exampleFormControlInput1" class="form-label">Email</label>
				 <input name="email" type="email" class="form-control"
							id="exampleFormControlInput1" placeholder="example@gmail.com">
			  </div> 
			  <div class="p-2 g-col-6">
				 <label for="exampleFormControlInput1" class="form-label">Phone Number</label>
				 <input name="phone" type="text" class="form-control"
							id="exampleFormControlInput1" placeholder="0179688011">
			  </div> 
			  <div class="p-2 g-col-6 d-flex flex-row justify-content-between">
				  <div class="col-6" style="padding: 0 10px 0 0">
				  	<label for="exampleFormControlInput1" class="form-label">Age</label>
				  	<input name="age" type="text" class="form-control"
								id="exampleFormControlInput1" placeholder="18">
				  </div>    
				  <div class="col-6" style="padding: 0 0 0 10px">
					<label for="exampleFormControlInput1" class="form-label">Gender</label>
				  	<select class="form-select" aria-label="gender select"
								name="gender">
					  <option selected value="male">Male</option>
					  <option value="female">Female</option>
					</select>
				  </div>
			  </div>
			  <div
						class="p-2 g-col-6  mt-2 d-flex flex-row justify-content-between">
				  <div class="col-6" style="padding: 0 10px 0 0">
				  	<label for="exampleFormControlInput1" class="form-label">Start date</label>
					<input name="startDate" type="date" class="form-control" id="minDate"
								id="exampleFormControlInput1">
				  </div>
				  <div class="col-6" style="padding: 0 10px 0 0">
				  	<label for="exampleFormControlInput1" class="form-label">End date</label>
					<input name="endDate" type="date" class="form-control" id="minDate"
								id="exampleFormControlInput1">
				  </div>
			  </div>
			  <div
						class="p-2 g-col-6  mt-2 d-flex flex-row justify-content-between">
				  <div class="col-6" style="padding: 0 10px 0 0">
				  	<label for="exampleFormControlInput1" class="form-label">Hourly Rate</label>
				  	<div class="input-group">
					  	<span class="input-group-text" id="basic-addon1">RM</span>
						<input name="hourlyRate" type="number" class="form-control"
									id="exampleFormControlInput1" placeholder="15">
					</div>
				  </div>
				  <!-- <div class="col-6" style="padding: 0 10px 0 0">
				  	<label for="exampleFormControlInput1" class="form-label">Unpaid Leave</label>
					<input name="unpaid" type="number" class="form-control"
								id="exampleFormControlInput1" placeholder="16">
				  </div> -->
			  </div>
			  <div class="p-2 g-col-6">
			  	<a href="<c:out value="${pageContext.servletContext.contextPath}" />/employee">
			  		<button type="button" class="btn btn-outline-danger">Cancel</button>
			  	</a>
			  </div>
			  <div class="p-2 g-col-6 d-flex justify-content-end"> 
			  	<button type="reset" class="btn btn-outline-danger" style="margin-right: 10px;">Reset</button>
			  	<button type="submit" class="btn btn-outline-primary">Create</button>
			  </div> 
			  
			</div>
			 
		</form>
	</div>
	<script>
		$(document).ready(function () {
		    var today = new Date().toISOString().split('T')[0];
		    $("#minDate").attr('min', today);
		    $("#minDate").attr('value', today);
		});
	</script>
    </jsp:body>
</t:dashboard>