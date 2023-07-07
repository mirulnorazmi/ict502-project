
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
			class="d-flex flex-column justify-content-center align-items-center">
                    <div
				class="container text-left d-flex flex-row justify-content-between align-items-center">
						<h4>Project list</h4> 
                        <a href="createproject"
					class="btn btn-success">Create Project</a>
                    </div>

                    <table class="table table-hover align-middle mt-4">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Project Name</th>  
                                <th>Department</th>
                                <th>Salary</th>
                                <th></th>
                                <th></th> 
                            </tr>
                        </thead>
					
				
				<tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="proj" items="${listProject}">

                                <tr>
                                    <td>
                                        <c:out value="${proj.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${proj.name}" />
                                    </td>
                                    <td>
                                        <c:out value="${proj.department}" />
                                    </td>
                                    <td>
                                        <c:out value="${proj.salary}" />
                                    </td>
                                    <td><a
								href="edit-project?id=<c:out value='${proj.id}' />"><i
									class="bi bi-pencil-square"></i> Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${proj.id}' />"><i
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