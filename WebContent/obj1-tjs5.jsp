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
	    //Function constructor
	    function Customer(name,email,mobile) {
	    	 this.name=name;
	    	 this.email=email;
	    	 this.mobile=mobile;
	    }
	    
	    Customer.prototype.show=function() {
	    	  console.log("name = "+this.name);
  	    	  console.log("email = "+this.email);
  	    	  console.log("mobile = "+this.mobile);
  	        };
	    
       var customer1=new Customer("Nagendra","nagen@gmail.com","92928929229");
       var customer2=new Customer("Packer","packa@gmail.com","56756757");
       var customer3=new Customer("Jaks","jaks@gmail.com","534345");
       var customer4=new Customer("JavaHunk","javahunk100@gmail.com","345345");
       customer1.show();
       customer2.show();
       customer3.show();
       customer4.show();
       
	    
	</script>

</body>
</html>