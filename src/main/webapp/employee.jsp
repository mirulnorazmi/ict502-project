
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<head>
<link rel="stylesheet" href="stylesheets/main.css" />
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
	<div class="d-flex flex-column justify-content-center align-items-left">
                    <div
				class="container text-left d-flex flex-row justify-content-between align-items-center">
					<h4>Employee list</h4> 
					<div class="dropdown">
					 <button class="btn btn-primary dropdown-toggle" type="button"
						data-bs-toggle="dropdown" aria-expanded="false">
					    Create Employee
					  </button>
					  <ul class="dropdown-menu">
					    <li><a class="dropdown-item"
							href="<c:out value="${pageContext.servletContext.contextPath}" />/create-employee?emp=fulltime">Full time</a></li>
					    <li><a class="dropdown-item"
							href="<c:out value="${pageContext.servletContext.contextPath}" />/create-employee?emp=parttime">Part time</a></li>
					  </ul>
					</div>
                    </div>
                    
                   <!--  <div class="input-group mb-3 mt-3">
 					 <input type="text" class="form-control"
					placeholder="Enter Employee Name" aria-label="Recipient's username"
					aria-describedby="button-addon2">
 						 <button class="btn btn-outline-success" type="button"
					id="button-addon2">Search</button>
					</div> -->
					 
					
					<!-- <div class="alert alert-success" role="alert">
  						Click on the row to update and delete the employee details
					</div> -->
                    
                    <!-- <div class="form-check-inline form-switch">
  						<input class="form-check-input" type="checkbox" role="switch"
					id="flexSwitchCheckChecked" checked>
  					<label class="form-check-label" for="flexSwitchCheckChecked">sort a-z</label>
					</div>
					<div class="form-check-inline form-switch">
  						<input class="form-check-input" type="checkbox" role="switch"
					id="flexSwitchCheckDefault">
  						<label class="form-check-label" for="flexSwitchCheckDefault">all employee</label>
					</div> -->
 
                    <table class="table table-hover align-middle mt-2">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th class="col-4">Name</th>
                                <th></th>
                                <th>Phone</th>
                                <th>Email</th>
                                <th>Age</th>
                                <th class="col-1">Gender</th>
                                <th class="col-2"></th>
                            </tr>
                        </thead>
					
				
				<tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="user" items="${listUser}"
						varStatus="usr">

                                <tr style="height: 54px;">
                                    <td>
                                        <c:out value="${usr.index + 1}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.name}" />
                                    </td>
                                    <td>
                                    <c:if
									test="${user.category == 'fulltime'}">
                                    	<span class="badge bg-primary">
                                    		Full time
                                    	</span>
                                    </c:if>
                                    <c:if
									test="${user.category == 'parttime'}">
                                    	<span
										class="badge bg-light text-dark">
                                    		Part time
                                    	</span>
                                    </c:if>
                                    
                                    </td>
                                    <td>
                                        <c:out value="${user.phone}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.email}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.age}" />
                                    </td>
                                    <td>
                                        👤 <c:out value="${user.gender}" />
                                    </td>
                                    <td><a
								style="margin-right: 10px;"
								href="edit-employee?id=<c:out value='${user.id}' />&emp=<c:out value="${user.category }" />"
								class="btn btn-success"><i class="bi bi-pencil-square"></i></a> 
									<button onclick="openRelativeModal('${user.id}', '${user.category }')" type="button"
									class="btn btn-danger" data-bs-toggle="modal"
									data-bs-target="deleteModal-${user.id}"> 
									  <i class="bi bi-trash"></i> 
									</button></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
     <c:forEach var="user" items="${listUser}">
     <div class="modal fade" id="deleteModal-${user.id}" tabindex="-1">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">Delete employee : <b style='color: red !important;'><c:out value="${user.email }" /></b></h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <p>Are you sure you want to delete this employee? <br> this process
	        can't be undo</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary"
								data-bs-dismiss="modal">cancel</button>
								<a id="deleteLink" href="/ICT502-PROJECT/DeleteEmployee?id=${user.id }&emp=${user.category}"
								class="btn btn-danger">Yes, Delete this employee
	        </a>
	      </div>
	    </div>
	  </div>
	</div>
	</c:forEach>
	<script>
						function openRelativeModal(id,emp) {
							console.log('id : ' + id);
							var link = '/ICT502-PROJECT/DeleteEmployee?id=' + id + '&emp='+ emp;
							$("#deleteLink").attr('href', link);
							/* console.log($("#deleteLink").attr('href')); */
							$('#deleteModal-' + id).modal('show');
						}
					</script>

    </jsp:body>
</t:dashboard>