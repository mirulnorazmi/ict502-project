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
		<%-- <nav style="-bs-breadcrumb-divider: '&gt;';" aria-label="breadcrumb">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a
						href="<c:out value="${pageContext.servletContext.contextPath}" />/project">Project</a></li>
		    <li class="breadcrumb-item active" aria-current="page">Create Project</li>
		  </ol>
		</nav>  --%>
		
<!-- 		<section class="vh-100"> -->
  <div class="container-fluid h-custom">
    <div class="row d-flex justify-content-center align-items-center"
					style="height: 80vh;">
      <div class="col-md-9 col-lg-6 col-xl-5">
        <img src="img/create_logo.png" class="img-fluid"
							alt="Sample image" width=800px height=800px>
      </div>
      <div class="col-md-8 col-lg-6 col-xl-6">
        <form action="<c:out value='${pageContext.servletContext.contextPath}' />/edit-project" method="post">
          <!-- Email input -->
          <div class="form-outline mb-4">
          <label class="form-label" for="form3Example3">Project Name</label>
            <input name="name" type="text" id="form3Example3"
									class="form-control form-control" value="${project.name}" />
          	<input name="id" value="${project.id }" hidden />
          </div>

          <!-- Password input -->
          <div class="form-outline mb-3">
          <label class="form-label" for="form3Example4">Department</label>
            <input name="department" type="text" id="form3Example4"
									class="form-control form-control" value="${project.department}" />
          </div>
          
          <div class="form-outline mb-3">
          <label class="form-label" for="form3Example5">Salary</label>
            <input name="salary" type="number" id="form3Example5"
									class="form-control form-control" value="${project.salary}" />  
          </div>

          <div class="d-flex justify-content-between align-items-center"> 
          </div>

          <div
								class="d-flex flex-row justify-content-between text-center text-lg-start mt-4 pt-2">
          <a
									href="<c:out value="${pageContext.servletContext.contextPath}" />/project">
          <button type="button" class="btn btn-danger btn"
										style="padding-left: 2.5rem; padding-right: 2.5rem;">cancel</button>
									</a>
          <div>
         <!--  <button type="reset" class="btn btn-danger btn"
										style="padding-left: 2.5rem; padding-right: 2.5rem;">Reset</button> --> 
            <button type="submit" class="btn btn-primary btn"
										style="padding-left: 2.5rem; padding-right: 2.5rem;">Save</button>
			</div>
          </div>  
        </form>
      </div>
    </div>
  </div>

  
<!-- </section> -->
</div>
    
	</jsp:body>
</t:dashboard>