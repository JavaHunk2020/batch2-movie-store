<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Forgot Password</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
	</script>
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
	<header style="background-color: #03a9f4; height: 30px;">
	   <b>Address : = ${applicationScope.address}</b> 
	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<b style="color:yellow;">Email : = ${applicationScope.email}</b> 
	 </header>
	<div  class="container">
	     <hr style="border-top: 5px solid rgba(103,58,183,1);"/>
		<img src="img/password.png" class="semere"  style="height: 140px;">
		
		<form action="forgotPassword" method="post">
		<div  class="semere"   style="width: 50%">
		 <span style="color:red;font-size: 16px;font-weight: bold;">${msg}</span>
		 			<br/>
		            <label for="email">Email*</label>
		            <input type="email" name="email" class="form-control">
		              <br/>
		<button type="submit" class="btn btn-primary">Forgot Password In</button>
		<a href="index.jsp"><button type="button" class="btn btn-info">Sign In</button></a>
		<hr/>
		 <b>${password}</b>
		</div>
		 
		</form>
	</div>

</body>
</html>