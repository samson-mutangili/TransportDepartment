<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="style.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

<title>Sign in</title>


<script type="text/javascript">
	
	function valdate(){
		debugger;
		
		//get the details from the from the form
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		
		//check if the user has entered some data and show error message
		//incase the fields are empty
		if(username == null || username == ''){
			alert("Please enter the username!!!");
			return false;
		}
		
		//check if the user entered some password
		if(password == null || password == ''){
			alert("Please enter the password");
			return false;
		}
		
		//else the user has entered all the details, return false
		return true;
	}

</script>

</head>
<body>

<jsp:include page="includes/navbar.jsp"></jsp:include>


<form action="login" method="post">
<div class="container">
	<div class="row">
		
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12"></div>
			
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
			<div class="jumbotron">
				<h1 class="text-center">Sign In</h1>
				<br>
				<p class="text-danger">${error}</p>
				
				<div class="form-group">
					<label class="control-table" for="userId">User Id</label>
					<input type="text" name="userId" class="form-control" placeholder="User Id">
					
			</div>	
			
			<div class="form-group">
					<label class="control-table" for="password">Password</label>
					<input type="password" name="password" class="form-control" placeholder="Password">
					
			</div>
			<input type="checkbox" name="remember">	Remember Me?
			<br><br>
			<div class="pull-right">
			<button type="submit" class="btn btn-success btn-block">Login</button>
			
			</div>
			
			<a href="http://localhost:8080/TransportManagement/Signup.jsp" title="Click here to create account">Sign Up Here</a>		
					
			
			</div>
			
			<div class="col-md-3"></div>
		</div>
	</div>
</div>
		
</form>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
	
</body>
</html>