<%@page import="component.caurosel.Caurosel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="component.group.Group"%>
<%@page import="dropdown.DropdownHtml"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jumbotron Template for Bootstrap</title>

<jsp:include page="inc/head.jsp"></jsp:include>

</head>

<body>
	<jsp:include page="inc/navbar.jsp"></jsp:include>
	<%
		Caurosel caurosel = new Caurosel();
	%>
	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<div class="container pt-4">
		<h3 class="p-2">Today's Event</h3>
			<div class="row">
				<div class="col-md-12">
					<div class="slider multiple-items">
						<%=caurosel.getEventCards()%>
					</div>
				</div>
			</div>
			<h3 class="p-2">Productivity</h3>
			<div class="row">
				<div class="col-md-12">
					<div class="slider multiple-items">
						<%=caurosel.getProductivityCards()%>
					</div>
				</div>
			</div>
			<h3 class="p-2">E-learning Activity</h3>
			<div class="row">
				<div class="col-md-12">

					<div class="slider multiple-items">

						<%=caurosel.getElearingCards()%>

					</div>
				</div>
			</div>
			<h3  class="p-2">Productivity Metric</h3>
			<div class="row">
				<div class="col-md-12">
				 <div id="chart_div"></div>
				</div>
			</div>	
		</div>
	</div>
	<!-- /container -->
	<jsp:include page="inc/foot.jsp"></jsp:include>
	 <script type="text/javascript">

      // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create the data table.
         var data = google.visualization.arrayToDataTable([
        ['Genre', 'Fantasy & Sci Fi', 'Romance', 'Mystery/Crime', 'General',
         'Western', 'Literature', { role: 'annotation' } ],
        ['2010', 10, 24, 20, 32, 18, 5, ''],
        ['2020', 16, 22, 23, 30, 16, 9, ''],
        ['2030', 28, 19, 29, 30, 12, 13, '']
      ]);

      var options = {
        height: '400px',
        bar: { groupWidth: '75%' },
        isStacked: true,
      };
      


        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
</body>
</html>
