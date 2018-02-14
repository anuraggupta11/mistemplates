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
			<div class="row">
				<div class="col-md-12">
					<div class="slider multiple-items">
						<%=caurosel.getEventCards()%>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="slider multiple-items">
						<%=caurosel.getProductivityCards()%>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">

					<div class="slider multiple-items">

						<%=caurosel.getElearingCards()%>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /container -->
	<jsp:include page="inc/foot.jsp"></jsp:include>
</body>
</html>
