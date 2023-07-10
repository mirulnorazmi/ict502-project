
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
    <div class="col-12">
            <div
				class="d-flex justify-content-center align-items-center"
				style="height: 85vh;">
              <div class="col-12"
					style="margin-top: 2%; margin-bottom: 5%;">
                <div class="col-12 mt-2">
                  <div class="container">
                    <div class="row">
				        <div class="col-md-6"> 
				          <h6>Employee Category</h6>
				          
				          	<p id="fulltime" style="display: none;">
								<c:out value="${category.fulltime }" />
							</p>
							<p id="parttime" style="display: none;">
								<c:out value="${category.parttime }" />
							</p> 
				        <!--   <p id="sedan" style="display: none;">30</p>
				          <p id="compact" style="display: none;">15</p> -->
				          <div class="chart-container">
				            <canvas id="pieChart"></canvas>
				          </div>
				        </div>
				        <div class="col-md-6">
				          <h6>Total of payment in month</h6>
				          <c:forEach var="lm" varStatus="loop" items="${listMonth}">
				          	<p id="lm-${lm.month }" style="display: none;"><c:out value="${lm.count }" /></p> 
				          </c:forEach>
				          <div class="chart-container" style="height: 60%;">
				            <canvas id="barChart"></canvas>
				          </div>
				        </div>
				      </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script
			src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
    <script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    <script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
					let valFulltime = document.getElementById("fulltime").innerText;
					let valParttime = document.getElementById("parttime").innerText;
					
			
					let valJan = document.getElementById("lm-1")?.innerText ?? '0';
					let valFeb = document.getElementById("lm-2")?.innerText ?? '0';
					let valMar = document.getElementById("lm-3")?.innerText ?? '0';
					let valApr = document.getElementById("lm-4")?.innerText ?? '0';
					let valMay = document.getElementById("lm-5")?.innerText ?? '0';
					let valJun = document.getElementById("lm-6")?.innerText ?? '0';
					let valJul = document.getElementById("lm-7")?.innerText ?? '0';
					let valAug = document.getElementById("lm-8")?.innerText ?? '0';
					let valSep = document.getElementById("lm-9")?.innerText ?? '0';
					let valOct = document.getElementById("lm-10")?.innerText ?? '0';
					let valNov = document.getElementById("lm-11")?.innerText ?? '0';
					let valDec = document.getElementById("lm-12")?.innerText ?? '0';


					

					

					// Pie Chart Data
					var pieData = {
						labels : [ 'Full time', 'Part time' ],
						datasets : [ {
							data : [ valFulltime, valParttime ],
							backgroundColor : [ '#FF6384', '#36A2EB' ]
						/* '#FFCE56' ] */
						} ]
					};

					// Doughnut Chart Data

					// Bar Chart Data
					var barData = {
						labels : [ 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
								'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec' ],
						datasets : [ {
							label : 'Payment',
							data : [ valJan, valFeb, valMar, valApr, valMay, valJun, valJul, valAug, valSep, valOct,
								valNov, valDec ],
							backgroundColor : '#36A2EB'
						} ]
					};

					// Chart Options
					var options = {
						responsive : true,
						maintainAspectRatio : false
					};

					// Create the Pie Chart
					var pieCtx = document.getElementById('pieChart')
							.getContext('2d');
					var pieChart = new Chart(pieCtx, {
						type : 'pie',
						data : pieData,
						options : options
					});

					// Create the Bar Chart
					var barCtx = document.getElementById('barChart')
							.getContext('2d');
					var barChart = new Chart(barCtx, {
						type : 'bar',
						data : barData,
						options : options
					});
				</script>

    </jsp:body>
</t:dashboard>