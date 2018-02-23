<!DOCTYPE html>
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
	<div class="jumbotron white-bg mt-3">
		
		 
		<div class="container">
		 
		 
					<form>
					<div class="form-group">
					  <label for="example-text-input" >Name</label>
					    <input class="form-control" type="text" " id="example-text-input" placeholder="Enter Name" required>
					</div>
					  <div class="form-group">
					    <label for="exampleInputEmail1">Email address</label>
					    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" required>
					    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">Password</label>
					    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required>
					  </div>
					  <div class="form-group">
						  <label for="example-number-input">Number</label>
						    <input class="form-control" type="number" placeholder="Number"  required id="example-number-input">
						  
						</div>
					  <div class="form-group">
					    <label for="exampleSelect1">Example select</label>
					    <select class="form-control" id="exampleSelect1" required>
					    <option value="">select</option>
					      <option>1</option>
					      <option>2</option>
					      <option>3</option>
					      <option>4</option>
					      <option>5</option>
					    </select>
					  </div>
					  
					  <div class="form-group">
					    <label for="exampleTextarea">Example textarea</label>
					    <textarea class="form-control" id="exampleTextarea" rows="3" required></textarea>
					  </div>
					  <div class="form-group">
					    <label for="exampleInputFile">File input</label>
					    <input type="file" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp" required>
					    <small id="fileHelp" class="form-text text-muted">This is some placeholder block-level help text for the above input. It's a bit lighter and easily wraps to a new line.</small>
					  </div>
					  
					  <div class="form-group">
						  <label for="example-datetime-local-input">Date and time</label>
						    <input class="form-control" type="datetime-local" id="example-datetime-local-input"  placeholder="Enter date-time" required>
						</div>
						<div class="form-group">
						  <label for="example-date-input">Date</label>
						    <input class="form-control" type="date"  id="example-date-input" placeholder="Enter date" required>
						</div>
						<div class="form-group ">
						  <label for="example-month-input" >Month</label>
						    <input class="form-control" type="month" id="example-month-input" placeholder="Enter month" required>
						</div>
						<div class="form-group">
						  <label for="example-week-input"  >Week</label>
						    <input class="form-control" type="week" id="example-week-input" placeholder="Enter week" required>
						</div>
						<div class="form-group ">
						  <label for="example-time-input">Time</label>
						    <input class="form-control" type="time" id="example-time-input" placeholder="Enter time" required>
						</div>
					  
					  
					  
					  <fieldset class="form-group">
					    <legend>Radio buttons</legend>
					    <div class="form-check">
					      <label class="form-check-label">
					        <input type="radio" class="form-check-input" name="optionsRadios" id="optionsRadios1" value="option1" checked required>
					        Option one is this and that&mdash;be sure to include why it's great
					      </label>
					    </div>
					    <div class="form-check">
					    <label class="form-check-label">
					        <input type="radio" class="form-check-input" name="optionsRadios" id="optionsRadios2" value="option2" required>
					        Option two can be something else and selecting it will deselect option one
					      </label>
					    </div>
					    <div class="form-check disabled">
					    <label class="form-check-label">
					        <input type="radio" class="form-check-input" name="optionsRadios" id="optionsRadios3" value="option3" disabled >
					        Option three is disabled
					      </label>
					    </div>
					  </fieldset>
					  <div class="form-check">
					    <label class="form-check-label">
					      <input type="checkbox" class="form-check-input" required>
					      Check me out
					    </label>
					  </div>
					  
					  
					  
					  <button type="submit" class="btn btn-primary">Submit</button>
					</form>
		
	 
		</div>
	</div>

	<!-- /container -->


	<jsp:include page="inc/foot.jsp"></jsp:include>
</body>
</html>
