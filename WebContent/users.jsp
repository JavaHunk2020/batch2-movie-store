<%@page import="com.cubit.it.entity.UserEntity"%>
<%@page import="java.util.List"%>
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
		<img src="img/student.png" class="semere"  style="height: 120px;">
		
		<h4>Users Data</h4>            
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Name</th>
        <th>Userid</th>
        <th>Email</th>
        <th>Salutation</th>
        <th>Mobile</th>
        <th>Photo</th>
      </tr>
    </thead>
    <tbody>
    
    <%
         //Here we are doing downcasting
         List<UserEntity>  userList=( List<UserEntity>)request.getAttribute("mark");
        for(UserEntity entity:userList) {
    %>
      <tr>
        <td><%=entity.getName()%></td>
        <td><%=entity.getUserid()%></td>
        <td><%=entity.getEmail()%></td>
        <td><%=entity.getSalutation()%></td>
        <td><%=entity.getMobile()%></td>
        <td><img src="<%=entity.getImage() %>"  style="height: 100px;"></td>
      </tr>
     <% } %>
      
    
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>

      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </tbody>
  </table>
		
	</div>
</body>
</html>