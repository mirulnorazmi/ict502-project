<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<head>
<link rel="stylesheet" href="stylesheets/login.css" />
</head>
<t:genericpage>
	<jsp:attribute name="title">
      login
    </jsp:attribute>
	<jsp:attribute name="header">
      <h1>Welcome</h1>
    </jsp:attribute>

	<jsp:body>
	<div class="d-flex justify-content-center align-items-center" style="height: 85vh;">
    	<div class="loginContainer col-10 col-md-4 col-sm-10 d-flex flex-column justify-content-center align-items-center">
    		<img src="img/flakepms-logo-only.png"" alt="logo-only" width="60"/>
    		<h3 class="mb-4">Login</h3>
        	<form action="SigninServlet" method="post" style="width: 100%;">
  				<div class="mb-3">
			    <label for="exampleInputEmail1" class="form-label">Email address</label>
			    <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
			    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">Password</label>
			    <input name="password" type="password" class="form-control"
							id="exampleInputPassword1">
			  </div>
			  <div class="mb-3 form-check">
			    <input type="checkbox" class="form-check-input"
							id="exampleCheck1">
			    <label class="form-check-label" for="exampleCheck1">Check me out</label>
			  </div>
			  <div class="d-flex justify-content-center" style="width: 100%;">
			  <button type="submit" class="btn btn-primary">Sign in</button>
			  </div>
			</form>
        </div>
     </div>
    </jsp:body>
</t:genericpage>