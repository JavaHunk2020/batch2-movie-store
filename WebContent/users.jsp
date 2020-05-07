<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
 <header  style="height: 30px;background-color: #21c9ff;">
   <b style="margin-left: 50px;">Hello! Mr. ${sessionScope.pdata.name}  - Email  =${sessionScope.pdata.email} </b>
   </header>
    <div  class="container">
         <%@include file="acommon.jsp" %>
		
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
          <th>Action</th>
      </tr>
    </thead>
    <tbody>
    
    <%
         //Here we are doing downcasting
       /*   List<UserEntity>  userList=( List<UserEntity>)request.getAttribute("mark");
        for(UserEntity entity:userList) { */
    %>
    
    <c:forEach items="${mark}"  var="entity">
      <tr>
        <td>${entity.name}</td>
        <td>${entity.userid}</td>
        <td>${entity.email}</td>
        <td>${entity.salutation}</td>
        <td>${entity.mobile}</td>
        <td>
        <img src="${entity.image}"  style="height: 100px;">
        </td>
         <td>
         <%
         //String tusername =''Role of current record";
         %>
         <c:set value="${entity.role}" var="trole"/>
         
          <c:if test="${sessionScope.pdata.role!=trole}">
         <a href="deleteUser?userid=${entity.userid}">
          <img src="img/delete.png"  style="height: 40px;">
          </a>
          </c:if>
          
         </td>
      </tr>
   </c:forEach>
      
    
      <tr>
        <td>&nbsp;</td>
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
        <td>&nbsp;</td>        <td>&nbsp;</td>
      </tr>
    </tbody>
  </table>
		
	</div>
</body>
</html>