<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
	<h1>hello world!</h1>
	<jsp:setProperty name="userInfo" property="*" />
	<!-- all -->
	You have entered below details:
	<br>
	<h6>(Option 2)</h6>
	Username : <input type="text" value="<%= session.getAttribute("email") %>" /><br>
	<!--   <servlet>
    <description></description>
    <display-name>LoginServlet</display-name>
    <servlet-name>LoginServlet</servlet-name>
    <servlet-class>controller.LoginServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>LoginServlet</servlet-name>
    <url-pattern>/LoginServlet</url-pattern>
  </servlet-mapping> -->
</body>	
</html> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib prefix="chart" uri="http://liferay.com/tld/chart"%>
<%@ page
	import="com.liferay.frontend.taglib.chart.model.percentage.donut.DonutChartConfig"%>
<%@ page
	import="com.liferay.frontend.taglib.chart.model.SingleValueColumn"%> --%>
<%-- 
<%
DonutChartConfig _donutChartConfig = new DonutChartConfig();

_donutChartConfig.addColumns(new SingleValueColumn("data1", 30), new SingleValueColumn("data2", 70));
%> --%>
<head>
<link rel="stylesheet" href="stylesheets/dashboard.css" />
</head>


<t:dashboard>
	<jsp:attribute name="title">
      dashboard
    </jsp:attribute>
	<jsp:attribute name="header">
      <h1>Welcome</h1>  
    </jsp:attribute>

	<jsp:body>
	<div class="d-flex justify-content-center align-items-center">
    			<div style="width: 100%;">
				<h4 style="text-align: left;">Dashboard</h4>
					<div class="jumbotron jumbotron-fluid">
					
						<div class="form-floating">
						
						<p class="h3"
							style="font-size: 20px; padding: 100px 0 0 100px; color: grey;">"Unlock Your Team's Earnings Potential with Ease!"</p>
						
						</div>
						
					
				</div>
				<br>
					<div class="d-flex flex-row mt-2" style="width: 100%;">
				<div class="col-8">
					<h4 style="text-align: left;">Status</h4>
					<div class="d-flex flex-wrap">
						<div class="card col-5 mb-2" style="margin-right: 10px;">
							<div
									class="card-body d-flex flex-row justify-content-between align-items-center">
								<div>
									<h5 class="card-title"><c:out value="${listCategory.parttime }" /></h5>
									<p class="card-text">Part Time</p>
								</div>
								<div class="border-icon-status">
									<i class="bi bi-people" style="font-size: 30px;"></i>
								</div>
							</div>
						</div>
						<div class="card col-5 mb-2" style="margin-right: 10px;">
							<div
									class="card-body d-flex flex-row justify-content-between align-items-center">
								<div>
									<h5 class="card-title"><c:out value="${listCategory.fulltime }" /></h5>
									<p class="card-text">Full Time</p>
								</div>
								<div class="border-icon-status">
									<i class="bi bi-people" style="font-size: 30px;"></i>
								</div>
							</div>
						</div>
						<div class="card col-5 mb-2" style="margin-right: 10px;">
							<div
									class="card-body d-flex flex-row justify-content-between align-items-center">
								<div>
									<h5 class="card-title"><c:out value="${projects.rowCount }" /></h5>
									<p class="card-text">Total Projects</p>
								</div>
								<div class="border-icon-status">
									<i class="bi bi-cast" style="font-size: 30px;"></i>
								</div>
							</div>
						</div>
							<div class="card col-5 mb-2" style="margin-right: 10px;">
							<div
									class="card-body d-flex flex-row justify-content-between align-items-center">
								<div>
									<h5 class="card-title"><c:out value="${payment.rowCount }" /></h5>
									<p class="card-text">Total Payment</p>
								</div>
								<div class="border-icon-status">
									<i class="bi bi-credit-card" style="font-size: 30px;"></i>
								</div>
							</div>
						</div>

					</div>
				</div>
				<div class="col-4">
					<h4 style="text-align: left;">Shortcut</h4>
					<div
							class="d-flex flex-column justify-content-left align-items-top"
							style="width: 100%">
						<a href="/ICT502-PROJECT/create-employee?emp=fulltime" style="width: 100%;">
						<button type="button" class="btn btn-outline-primary mb-3" style="width: 100%;">
						
							Create employee full time</button>
							</a>	
							<a href="/ICT502-PROJECT/create-employee?emp=parttime" style="width: 100%;">
							<button type="button" class="btn btn-outline-primary mb-3" style="width: 100%;">
						
							Create employee part time</button>
							</a>
							<a href="/ICT502-PROJECT/createproject">
						<button type="button" class="btn btn-outline-primary mb-3" style="width: 100%;">
							Create projects </button>
							</a>
					
					</div>
				</div>
			</div>
			</div>

			
     </div>
     
    </jsp:body>
</t:dashboard>