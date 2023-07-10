
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<head>
<link rel="stylesheet" href="stylesheets/main.css" />
<link rel="stylesheet" href="stylesheets/dashboard.css" />
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
				By hiring full-time employees, we ensure a dedicated and committed workforce.
			</p>
			
			</div>
		</div>
		<form action="" method="post" class="col-11 mt-1">
			<div class="grid gap-1">
			  <div class="p-2 g-col-6">
				 <label for="exampleFormControlInput1" class="form-label">Name</label>
				 <input name="name" type="text" class="form-control"
							id="exampleFormControlInput1"
							value="<c:out value='${employee.name }' />">
				<input name="id" type="text" class="form-control"
							id="exampleFormControlInput1"
							value="<c:out value='${employee.id }' />" hidden>
			  </div>
			  <div class="p-2 g-col-6">
				 <label for="exampleFormControlInput1" class="form-label">Email</label>
				 <input name="email" type="email" class="form-control"
							id="exampleFormControlInput1"
							value="<c:out value='${employee.email }' />">
			  </div> 
			  <div class="p-2 g-col-6">
				 <label for="exampleFormControlInput1" class="form-label">Phone Number</label>
				 <input name="phone" type="text" class="form-control"
							id="exampleFormControlInput1"
							value="<c:out value='${employee.phone }' />">
			  </div> 
			  <div class="p-2 g-col-6 d-flex flex-row justify-content-between">
				  <div class="col-6" style="padding: 0 10px 0 0">
				  	<label for="exampleFormControlInput1" class="form-label">Age</label>
				  	<input name="age" type="text" class="form-control"
								id="exampleFormControlInput1"
								value="<c:out value='${employee.age }' />">
				  </div>    
				  <div class="col-6" style="padding: 0 0 0 10px">
					<label for="exampleFormControlInput1" class="form-label">Gender</label>
				  	<select class="form-select" aria-label="gender select"
								name="gender">
					  <option selected value="<c:out value='${employee.gender }' />">
					  	<c:if test="${employee.gender == 'male' }">
					  		Male
					  	</c:if>
					  	<c:if test="${employee.gender == 'female' }">
					  		Female
					  	</c:if>
					  </option>
					  <c:if test="${employee.gender == 'male' }">
					  	<option value="female">Female</option>
					  </c:if>
					  <c:if test="${employee.gender == 'female' }">
					  	<option value="male">Male</option>
					  </c:if>
					</select>
				  </div>
			  </div>
			  <div
						class="p-2 g-col-6  mt-2 d-flex flex-row justify-content-between">
				  <div class="col-6" style="padding: 0 10px 0 0">
				  	<label for="exampleFormControlInput1" class="form-label">Annual Leave</label>
					<input name="annual" type="number" class="form-control"
								id="exampleFormControlInput1"
								value="<c:out value='${employee.annualLeave }' />">
				  </div>
				  <div class="col-6" style="padding: 0 10px 0 0">
				  	<label for="exampleFormControlInput1" class="form-label">Sick Leave</label>
					<input name="sick" type="number" class="form-control"
								id="exampleFormControlInput1"
								value="<c:out value='${employee.sickLeave }' />">
				  </div>
			  </div>
			  <div
						class="p-2 g-col-6  mt-2 d-flex flex-row justify-content-between">
				  <div class="col-6" style="padding: 0 10px 0 0">
				  	<label for="exampleFormControlInput1" class="form-label">Insurance</label>
				  	<%-- <div class="input-group">
					  	<span class="input-group-text" id="basic-addon1">RM</span>
						<input name="insurance" type="number" class="form-control"
									id="exampleFormControlInput1" value="<c:out value='${employee.insurance }' />">
					</div> --%>
					<select class="form-select" aria-label="gender select"
								name="insurance">
					  <option selected value="<c:out value='${employee.insurance }' />">
					  	<c:if test="${employee.insurance == 'Life insurance' }">
					  		Life insurance
					  	</c:if>
					  	<c:if test="${employee.insurance == 'Health insurance' }">
					  		Health insurance
					  	</c:if>
					  	<c:if test="${employee.insurance == 'Life & Health insurance' }">
					  		Life & Health insurance
					  	</c:if>
					  </option>
					  <c:if test="${employee.insurance != 'Life insurance' }">
					  <option value="Life insurance">
					  		Life insurance
					  </option>
					  	</c:if>
					  	<c:if test="${employee.insurance != 'Health insurance' }">
					  	<option value="Health insurance">
					  		Health insurance
					  		</option>
					  	</c:if>
					  <c:if test="${employee.insurance != 'Life & Health insurance' }">
					  <option value="Life & Health insurance">
					  		Life & Health insurance
					  	</option>
					  	</c:if>
					</select>
				  </div>
				  <div class="col-6" style="padding: 0 10px 0 0">
				  	<label for="exampleFormControlInput1" class="form-label">Unpaid Leave</label>
					<input name="unpaid" type="number" class="form-control"
								id="exampleFormControlInput1"
								value="<c:out value='${employee.unpaidLeave }' />">
				  </div>
			  </div>
			  <div class="p-2 g-col-6">
			  	<a
							href="<c:out value="${pageContext.servletContext.contextPath}" />/employee">
			  		<button type="button" class="btn btn-outline-danger">Cancel</button>
			  	</a>
			  </div>
			  <div class="p-2 g-col-6 d-flex justify-content-end"> 
			  	<button type="reset" class="btn btn-outline-danger"
							style="margin-right: 10px;">Reset</button>
			  	<button type="submit" class="btn btn-outline-primary">Update</button>
			  </div> 
			  
			</div>
			 
		</form>
	</div>
    </jsp:body>
</t:dashboard>