
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
			class="d-flex flex-column justify-content-center align-items-left">
                    <div
				class="container text-left d-flex flex-row justify-content-between align-items-center">
					<h4>Employee list</h4> 
                    </div>
                    
                    <div class="input-group mb-3">
 					 <input type="text" class="form-control" placeholder="Enter Employee Name" aria-label="Recipient's username" aria-describedby="button-addon2">
 						 <button class="btn btn-outline-secondary" type="button" id="button-addon2">Search</button>
					</div>
					
					<div class="alert alert-success" role="alert">
  						Click on the row to update and delete the employee details
					</div>
                    
                    <div class="form-check-inline form-switch">
  						<input class="form-check-input" type="checkbox" role="switch"
							id="flexSwitchCheckChecked" checked>
  					<label class="form-check-label" for="flexSwitchCheckChecked">sort a-z</label>
					</div>
					<div class="form-check-inline form-switch">
  						<input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckDefault">
  						<label class="form-check-label" for="flexSwitchCheckDefault">all employee</label>
					</div>

                    <table class="table table-hover align-middle mt-4">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Phone</th>
                                <th>Email</th>
                                <th>Age</th>
                                <th>Gender</th>
                                <th></th>
                                <th></th> 
                            </tr>
                        </thead>
					
				
				<tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="user" items="${listUser}">

                                <tr>
                                    <td>
                                        <c:out value="${user.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.name}" />
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
                                        <c:out value="${user.gender}" />
                                    </td>
                                    <td><a
								href="employee/edit?id=<c:out value='${user.id}' />"><i
									class="bi bi-pencil-square"></i> Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${user.id}' />"><i
									class="bi bi-trash"></i> Delete</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
     </div>
    </jsp:body>
</t:dashboard>