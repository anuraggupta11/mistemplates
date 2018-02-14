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

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<div class="container pt-4">
			<div class="row">
				<div class="col-md-12">

					<div class="slider multiple-items">
						<%
							for (int i = 0; i < 10; i++) {
						%>
						<div class="card p-3 m-2 " style="width: 20rem;">
							<button type="button" class="btn d-flex justify-content-center"
								style="position: absolute; top: 0; right: 0; background-color: #35bdf0; border-bottom-left-radius: 86px; width: 30px; height: 30px;">
								<i class="fas fa-video"
									style="font-size: 12px; vertical-align: middle; margin-left: 6px; color: white;"></i>
							</button>

							<div class="row">
								<div class="col-md-12 d-flex font-13">
									<div class="mr-3 cyan-text">
										<i class="fas fa-clock"></i> &nbsp;03:33 PM
									</div>
									<div class="cyan-text">
										<i class="fas fa-hourglass"></i> &nbsp;2hrs: 33 min
									</div>
								</div>
							</div>
							<div class="row pt-2">
								<div class="col-4 pr-0">
									<img
										src="https://pbs.twimg.com/profile_images/900338165113815045/aA0Wx0uR_400x400.jpg"
										class="custom_image_size_80" alt="Responsive image">

								</div>
								<div class="col-8 pl-0 pr-0 ">
									<p class="text-left mb-1 font-12">Business Communication</p>
									<p class="text-left mb-1 font-16 font-weight-bold">Trainer
										- Direct Tax</p>
									<p class="text-left mb-1 font-12">BOI Demo Course Jaron
										Rice</p>

								</div>
							</div>
							<hr class="mt-0 mb-0">
							<div class="row text-center pt-2">
								<div class="col-4 font-12 text-left">Hello</div>
								<div class="col-4 font-12 ">Hello1</div>
								<div class="col-4 font-12">Hello2</div>
							</div>
							<div class="row text-center pt-2">
								<div class="col-4 text-left font-14">Hello</div>
								<div class="col-4 d-flex">
									<div class="rating_star align-self-center" data-rating="3.5"
										data-star_width="14"></div>
								</div>
								<div class="col-4 font-14">Hello2</div>
							</div>


						</div>
						<%
							}
						%>

					</div>
				</div>
			</div>





			<div class="row">
				<div class="col-md-12">

					<div class="slider multiple-items">
						<%
							for (int i = 0; i < 10; i++) {
						%>
						<div class="card p-3 m-2 " style="width: 20rem;">
							<button type="button" class="btn d-flex justify-content-center"
								style="position: absolute; top: 0; right: 0; background-color: #35bdf0; border-bottom-left-radius: 86px; width: 30px; height: 30px;">
								<i class="fas fa-video"
									style="font-size: 12px; vertical-align: middle; margin-left: 6px; color: white;"></i>
							</button>
							<div class="row">
								<div class="col-md-12 d-flex font-13">14/02/2018</div>

							</div>
							<div class="row pt-2">
								<div class="col-md-12 d-flex font-13">
									<div class="mr-3 cyan-text">
										<i class="fas fa-clock"></i> &nbsp;03:33 AM-03:33 PM
									</div>
									<div class="cyan-text">
										<i class="fas fa-hourglass"></i> &nbsp;2hrs: 33 min
									</div>
								</div>
							</div>
							<div class="row pt-2">
								<div class="col-12 font-weight-bold font-16">3M india
									Limited</div>
							</div>
							<hr class=" mb-0 mt-1">
							<div class="row text-center pt-2">
								<div class="col-3 font-12 text-left">Talentify Score</div>
								<div class="col-3 font-12">Self Rating</div>
								<div class="col-3 font-12">Keyword Detection</div>
								<div class="col-3 font-12">Sentiment Score</div>
							</div>
							<div class="row text-center pt-2">
								<div class="col-3 text-left d-flex">
									<div class="rating_star align-self-center" data-rating="3.5"
										data-star_width="14"></div>
								</div>
								<div class="col-3 d-flex">
									<div class="rating_star align-self-center" data-rating="3.5"
										data-star_width="14"></div>
								</div>
								<div class="col-3 font-14">100%</div>
								<div class="col-3 font-14">%</div>
							</div>
							<hr class=" mb-0 mt-2">
							<div class="row pt-2">
								<div class="col-12 font-11">
									<i class="fab fa-font-awesome-flag theme-text"
										style="font-size: 12px;"></i> &nbsp;Mild Interest
								</div>
							</div>


						</div>
						<%
							}
						%>

					</div>
				</div>
			</div>










			<div class="row">
				<div class="col-md-12">

					<div class="slider multiple-items">
						<%
							for (int i = 0; i < 10; i++) {
						%>
						<div class="card p-3 m-2 " style="width: 20rem;">



							<div class="row pt-2">
								<div class="col-4 pr-0">
									<img
										src="https://pbs.twimg.com/profile_images/900338165113815045/aA0Wx0uR_400x400.jpg"
										class="custom_image_size_80" alt="Responsive image">

								</div>
								<div class="col-8 pl-0 pr-0 ">
									<p class="text-left mb-1 font-12">Business Communication</p>
									<p class="text-left mb-1 font-16 font-weight-bold">Trainer
										- Direct Tax</p>
									<p class="text-left mb-1 font-12">BOI Demo Course Jaron
										Rice</p>

								</div>
							</div>
							<hr class="mt-0 mb-0">
							<div class="row text-center pt-2">
								<div class="col-4 font-12 ">Hello</div>
								<div class="col-4 font-12 ">Hello1</div>
								<div class="col-4 font-12">Hello2</div>
							</div>
							<div class="row text-center pt-2">
								<div class="col-4  font-14">Hello</div>
								<div class="col-4 d-flex">
									<div class="rating_star align-self-center" data-rating="3.5"
										data-star_width="14"></div>
								</div>
								<div class="col-4 font-14">Hello2</div>
							</div>


						</div>
						<%
							}
						%>

					</div>
				</div>
			</div>















		</div>
	</div>


	<!-- /container -->


	<jsp:include page="inc/foot.jsp"></jsp:include>
</body>
</html>
