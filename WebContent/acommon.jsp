 Your current role is  = <b> ${sessionScope.pdata.role}</b> 
         <!-- sessionScope  is called implicit EL object -->
         <img src="img/student.png"  style="height: 139px">
               <c:if test="${sessionScope.pdata.role=='admin'}">
                <a href="users"><button type="button" class="btn btn-primary">Manage Users</button></a>
                </c:if>
                		
   				  <button type="reset" class="btn btn-danger">Email</button>
   				  	 <a href="profile.jsp"> 
   				  	        <button type="button" class="btn btn-success">Profile</button>
   				  	 </a>
   				  	 
   				  	   <a href="blockTime"> 
   				  	        <button type="button" class="btn btn-warning">Block Times</button>
   				  	 </a>
   				  	  <a href="logout"> 
   				  	        <button type="button" class="btn btn-warning">Logout</button>
   				  	 </a>
         <hr/>