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
		
		 <marquee scrolldelay="10" direction="right">
		 <h1>I am sorry! your username and password are not correct!</h1>
		 </marquee>
	</div>
	
	<script type="text/javascript">
	       //function without name is called anonymous function or function expression
	       var  paa=function(num1,num2) {
	    	   var tempa=num1+num2;
	    	   return tempa;
	      }
	       
	       var  sub=function(num1,num2) {
	    	   var tempa=num1-num2;
	    	   return tempa;
	      }
	       
	       ajax(90,60,paa,sub);
	       
	       function ajax(num1,num2,callback1,callback2){
	    	    var temp=callback1(num1,num2);
	    	    console.log("Magic Sum = "+temp);
	    	    temp=callback2(num1,num2);
	    	    console.log("Magic Sub= "+temp);
	       }
	       
         
	</script>

</body>
</html>