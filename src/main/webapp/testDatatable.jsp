<%@page import="testdatatable.NewDatatableService"%>
<%@page import="testdatatable.DatatableService"%>
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

<style>
.datatable_container>table>thead>tr>th.desc {
	/* content: "\f35b";
	font-family: "Font Awesome\ 5 Free";
	float: right;
	color: black; */
	background-image: url(http://localhost:8080/mistemplates/assets/img/sort-down.svg);
    background-repeat: no-repeat;
    background-color: white;
    background-position: right;
    background-size: 30% 30%;
      background-color: #bad0b8;
    
}

.datatable_container>table>thead>tr>th.asc {
	/* content: "\f358";
	font-family: "Font Awesome\ 5 Free";
	float: right;
	color: black; */
	background-image: url(http://localhost:8080/mistemplates/assets/img/sort-up.svg);
    background-repeat: no-repeat;
    background-color: white;
    background-position: right;
    background-size: 30% 30%;
      background-color: #bad0b8;
    
}



.datatable_container>table>thead>tr>th.default{
	/* content: "\f358";
	font-family: "Font Awesome\ 5 Free";
	float: right;
	color: black; */
	background-image:  url(http://localhost:8080/mistemplates/assets/img/1.svg);
    background-repeat: no-repeat;
    background-color: white;
    background-position: right;
    background-size: 30% 30%;
  background-color: #bad0b8;
}


/* Absolute Center Spinner */
.loading {
  position: fixed;
  z-index: 999;
  height: 2em;
  width: 2em;
  overflow: show;
  margin: auto;
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
}

/* Transparent Overlay */
.loading:before {
  content: '';
  display: block;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0,0,0,0.3);
}

/* :not(:required) hides these rules from IE9 and below */
.loading:not(:required) {
  /* hide "loading..." text */
  font: 0/0 a;
  color: transparent;
  text-shadow: none;
  background-color: transparent;
  border: 0;
}

.loading:not(:required):after {
  content: '';
  display: block;
  font-size: 10px;
  width: 1em;
  height: 1em;
  margin-top: -0.5em;
  -webkit-animation: spinner 1500ms infinite linear;
  -moz-animation: spinner 1500ms infinite linear;
  -ms-animation: spinner 1500ms infinite linear;
  -o-animation: spinner 1500ms infinite linear;
  animation: spinner 1500ms infinite linear;
  border-radius: 0.5em;
  -webkit-box-shadow: rgba(0, 0, 0, 0.75) 1.5em 0 0 0, rgba(0, 0, 0, 0.75) 1.1em 1.1em 0 0, rgba(0, 0, 0, 0.75) 0 1.5em 0 0, rgba(0, 0, 0, 0.75) -1.1em 1.1em 0 0, rgba(0, 0, 0, 0.5) -1.5em 0 0 0, rgba(0, 0, 0, 0.5) -1.1em -1.1em 0 0, rgba(0, 0, 0, 0.75) 0 -1.5em 0 0, rgba(0, 0, 0, 0.75) 1.1em -1.1em 0 0;
  box-shadow: rgba(0, 0, 0, 0.75) 1.5em 0 0 0, rgba(0, 0, 0, 0.75) 1.1em 1.1em 0 0, rgba(0, 0, 0, 0.75) 0 1.5em 0 0, rgba(0, 0, 0, 0.75) -1.1em 1.1em 0 0, rgba(0, 0, 0, 0.75) -1.5em 0 0 0, rgba(0, 0, 0, 0.75) -1.1em -1.1em 0 0, rgba(0, 0, 0, 0.75) 0 -1.5em 0 0, rgba(0, 0, 0, 0.75) 1.1em -1.1em 0 0;
}

/* Animation */

@-webkit-keyframes spinner {
  0% {
    -webkit-transform: rotate(0deg);
    -moz-transform: rotate(0deg);
    -ms-transform: rotate(0deg);
    -o-transform: rotate(0deg);
    transform: rotate(0deg);
  }
  100% {
    -webkit-transform: rotate(360deg);
    -moz-transform: rotate(360deg);
    -ms-transform: rotate(360deg);
    -o-transform: rotate(360deg);
    transform: rotate(360deg);
  }
}
@-moz-keyframes spinner {
  0% {
    -webkit-transform: rotate(0deg);
    -moz-transform: rotate(0deg);
    -ms-transform: rotate(0deg);
    -o-transform: rotate(0deg);
    transform: rotate(0deg);
  }
  100% {
    -webkit-transform: rotate(360deg);
    -moz-transform: rotate(360deg);
    -ms-transform: rotate(360deg);
    -o-transform: rotate(360deg);
    transform: rotate(360deg);
  }
}
@-o-keyframes spinner {
  0% {
    -webkit-transform: rotate(0deg);
    -moz-transform: rotate(0deg);
    -ms-transform: rotate(0deg);
    -o-transform: rotate(0deg);
    transform: rotate(0deg);
  }
  100% {
    -webkit-transform: rotate(360deg);
    -moz-transform: rotate(360deg);
    -ms-transform: rotate(360deg);
    -o-transform: rotate(360deg);
    transform: rotate(360deg);
  }
}
@keyframes spinner {
  0% {
    -webkit-transform: rotate(0deg);
    -moz-transform: rotate(0deg);
    -ms-transform: rotate(0deg);
    -o-transform: rotate(0deg);
    transform: rotate(0deg);
  }
  100% {
    -webkit-transform: rotate(360deg);
    -moz-transform: rotate(360deg);
    -ms-transform: rotate(360deg);
    -o-transform: rotate(360deg);
    transform: rotate(360deg);
  }
}

</style>
</head>

<body>
<div class="loading" style="display:none">Loading&#8230;</div>
	<jsp:include page="inc/navbar.jsp"></jsp:include>
	<%
	NewDatatableService datatableService = new NewDatatableService();
	%>
	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron white-bg">
		<div class="container pt-4">
			<h3 class="p-2">Today's Event</h3>
			<div class="row">
				<div class="col-md-12">
					<%=datatableService.getDataTable(1,null,null,null,null,null,null) %>
				</div>
			</div>

		</div>
		
		
	
			
	</div>
	<!-- /container -->
	<jsp:include page="inc/foot.jsp"></jsp:include>
	<script>
  FontAwesomeConfig = { searchPseudoElements: true };
</script>

</body>
</html>
