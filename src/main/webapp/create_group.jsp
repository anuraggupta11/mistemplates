
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
	<div class="jumbotron   mt-3">
		<div class="container">
			<h3>Create group</h3>
			<div class="row">
				<div class="col-md-6 d-flex">
					<div class="form-group mr-2  w-100">
						<label for="inputEmail3" class="col-form-label">Group Name</label> <input
							type="email" class="form-control" id="inputEmail3"
							placeholder="Enter Group Name">

					</div>

					<div class="form-group    w-100">
						<label for="select" class="col-form-label">Group Type</label> <select
							id="select" class="form-control">
							<option>Choose Group Type</option>
						</select>
					</div>

				</div>
			</div>
			<div class="row  ">
			<div class="col-md-8  equal_heights">
						    <label for="dropdownMenuButton" class="">Add Skills</label>
			
			<div class="input-group">
			
      <input type="text" class="form-control ajaxifySearchInput dropdown-toggle" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" placeholder="Search for...">
       <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
       <a class="dropdown-item" href="#">Action</a>
       </div>
      <span class="input-group-btn">
        <button class="btn btn-secondary" type="button"><i class="fas fa-search"></i></button>
      </span>
    </div>
    <div class="row ">
    <div class="col-md-12 d-flex mt-3">
    	<div class=" align-self-center mr-2">Or</div>
    	<hr class="w-100 align-self-center" style="    align-self: center;">
    	</div>
    </div>
			<div class="row">
			<div class="col-md-12">
			 <div class="form-group">
   			 <label for="exampleTextarea">Scan job description</label>
   			 <textarea class="form-control" id="exampleTextarea" rows="8"></textarea>
  				</div></div>
			</div>
			
			</div>
			<div class="col-md-4 equal_heights">
			
				<div class="d-flex justify-content-end">
  <div class="mr-auto p-2"><label for="exampleSkill">Selected Skills</label></div>
  <div class="p-2"> <i class="fas fa-square" style="color:#fd6d81; "></i>
			 Course</div>
  <div class="p-2"><i class="fas fa-square" style="color: #7295fd;"></i>
			 Skills</div>
  
</div>
			<div id="exampleSkill" class="lightyellow-bg " style="height: 82%; ">
			<button type="button" class="btn btn-outline-secondary white-bg gray-text p-2 m-2">Secondary<i class="fas fa-times"></i></button>
			</div>
			
			</div>
			</div>


			<div class=" row">
			<div class="col-md-8">
				<div class="d-flex justify-content-end w-100">
  <div class="p-2"><button type="button" class="btn btn-outline-danger ">Scan</button>


</div>
  <div class="p-2"><button type="button" class="btn btn-danger">Create</button>


</div>
</div>
				</div>
			</div>
		</div>
	</div>


	<!-- /container -->


	<jsp:include page="inc/foot.jsp"></jsp:include>
</body>
</html>
