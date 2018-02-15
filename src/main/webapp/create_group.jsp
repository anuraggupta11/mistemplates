
<!DOCTYPE html>
<%@page import="component.group.CreateGroup"%>
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

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron   mt-3">
		<div class="container">
			<%= new CreateGroup().getGroupCreationPage() %>
			<div class="alert alert-danger alert-dismissible fade" role="alert"></div>
		</div>
		
		
		 
	</div>
	<!-- /container -->

	



	<jsp:include page="inc/foot.jsp"></jsp:include>
</body>
</html>
