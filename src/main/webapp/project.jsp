
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
	<div
			class="d-flex flex-column justify-content-center align-items-center">
                    <div
				class="container text-left d-flex flex-row justify-content-between align-items-center">
						<h4>Project list</h4> 
                        <a href="createproject" class="btn btn-success">Create Project</a>
                    </div>

                    <table class="table table-hover align-middle mt-4">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Project Name</th>  
                                <th>Department</th>
                                <th>Salary</th>
                                <th></th>
                            </tr>
                        </thead>
					
				
				<tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="proj" varStatus="loop"
						items="${listProject}">

                                <tr>
                                    <td>
                                        <c:out value="${loop.index+1}" />
                                    </td>
                                    <td>
                                        <c:out value="${proj.name}" />
                                    </td>
                                    <td>
                                        <c:out
									value="${proj.department}" />
                                    </td>
                                    <td>
                                        <c:out value="${proj.salary}" />
                                    </td>
                                    <td><a
								href="edit-project?id=<c:out value='${proj.id}' />"
								class="btn btn-success"><i class="bi bi-pencil-square"></i> Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <button
									onclick="openRelativeModal('${proj.id}')" type="button"
									class="btn btn-danger" data-bs-toggle="modal"
									data-bs-target="deleteModal-${proj.id}"> 
  <i class="bi bi-trash"></i> Delete
</button></td>
                                </tr> 
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
     </div>
     <c:forEach var="proj" items="${listProject}">
     <div class="modal fade" id="deleteModal-${proj.id}" tabindex="-1">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">Delete project : <b style='color: red !important;'><c:out value="${proj.name }"></c:out></b></h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
	      </div> 
	      <div class="modal-body">
	        <p>Are you sure you want to delete this project? <br> this process
	        can't be undo</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
								<a id="deleteLink" href="/ICT502-PROJECT/DeleteProject?id="
								class="btn btn-danger">Yes, delete this project
	        </a>
	      </div>
	    </div>
	  </div>
	</div>
	</c:forEach>

     <script>
						function openRelativeModal(id) {
							console.log('id : ' + id);

							$("#deleteLink").attr('href',
									'/ICT502-PROJECT/DeleteProject?id=' + id);
							$('#deleteModal-' + id).modal('show');
						}
					</script>
    </jsp:body>
</t:dashboard>