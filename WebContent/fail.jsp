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
	 <marquee scrolldelay="10" direction="up">
		<img src="img/student.png" class="tcenter" style="height: 200px;">
		</marquee>
		
		 <h1>I am sorry! your username and password are not correct!</h1>
		 <marquee scrolldelay="10" direction="right">
		 <a href="index.jsp">
		 <span >
		 <img src="img/login.png" class="tcenter" style="height: 100px;display: inline;">
		 Click here to sign in
		 </span>
		 </a>
		 </marquee>
	</div>

</body>
</html>