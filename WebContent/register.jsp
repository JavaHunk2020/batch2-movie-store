<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Register</title>
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
.tcenter {
	display: block;
	margin-left: auto;
	margin-right: auto;
}
</style>

</head>
<body>
	<header style="background-color: #03a9f4; height: 30px;"> </header>

	<div class="container">
		<img src="img/student.png" class="tcenter" style="height: 150px;">
		 <span class="tcenter" style="font-weight: bold;font-size: 18px">${message}</span>
		<form action="register" method="post">
		<div  class="tcenter" style="width: 50%">
		            <label for="username">Username</label>
		            <input type="text" name="username" class="form-control">
		               <label for="password">Password</label>
		            <input type="password" name="password" class="form-control">
		             <label for="email">Email</label>
		            <input type="email" name="email" class="form-control">
		             <label for="salutation">Salutation</label>
		            <select  name="salutation" class="form-control" style="width: 50%;">
		               <option>Mr.</option>
		               <option>Miss</option>
		            </select>
		            
		                       <label for="name">Name</label>
		            <input type="text" name="name" class="form-control">
		                       <label for="mobile">Mobile</label>
		            <input type="number" name="mobile" class="form-control">
		            
		             <label for="image">Image</label>
		            <input type="text" name="image" class="form-control">
		            
		             <br/>
		<button type="submit" class="btn btn-primary">Register</button>
		<button type="button" class="btn btn-danger">Clear</button>
		<a href="index.jsp"><button type="button" class="btn btn-info">Sign In</button></a>
		</div>
		</form>
	</div>

</body>
</html>