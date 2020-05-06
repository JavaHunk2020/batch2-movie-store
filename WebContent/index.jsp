<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<style type="text/css">

.semere {
	display: block;
	margin-left: auto;
	margin-right: auto;
}
</style>

</head>
<body>
	<header style="background-color: #03a9f4; height: 30px;"> </header>

	<div  class="container">
		<img src="img/student.png" class="semere"  style="height: 200px;">
		<form action="auth" method="post">
		<div  class="semere"   style="width: 50%">
		            <label for="username">Username</label>
		            <input type="text" name="username" class="form-control">
		              <br/>
		               <label>Password</label>
		            <input type="password" name="password" class="form-control">
		             <br/>
		<button type="submit" class="btn btn-primary">Sign In</button>
		<button type="button" class="btn btn-danger">Clear</button>
		<a href="register.jsp"><button type="button" class="btn btn-info">Sign Up</button></a>
		<a href="fortgotPassword.jsp"><button type="button" class="btn btn-primary">Forget Password</button></a>
		<a href="users"><button type="button" class="btn btn-danger">Show Users</button></a>
		</div>
		</form>
	</div>

</body>
</html>