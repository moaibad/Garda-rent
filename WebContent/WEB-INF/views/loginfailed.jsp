<%@include file="/header.jsp" %>
<body>
	<div style="padding-top:100px" align="center">
		<div class="col-sm-3">
	    	<div class="card" style=" background: #ddd">
	        	<div class="card-body">
	                   Selamat Datang , Silahkan Login!
	                   <br/>
	                   <br/>
	                   <form method="post" action="<%= request.getContextPath() %>/login">
	                       <center><h5 class="card-title">Login</h5></center>
	                       <h6 class="card-subtitle mb-2 text-muted"></h6>
	                       <div class="form-group">
	                       <label for="">Username</label>
	                       <input type="text" name="email" id="" class="form-control" placeholder="" aria-describedby="helpId">
	                       </div>
	                       <div class="form-group">
	                       <label for="">Password</label>
	                       <input type="password" name="password" id="" class="form-control" placeholder="" aria-describedby="helpId">
	                       </div>
	                       <center><button class="btn btn-primary">Login</button>
	                       
	                       <!-- Button trigger modal -->
	                       <a class="btn btn-danger text-white" data-toggle="modal" href="<%= request.getContextPath() %>/register">
	                           Daftar
	                        </a></center>
	                        <br/>
	                        <div class="alert alert-danger" role="alert">
	                       	Masukan username/password yang valid !
	                       </div>
	                   </form>
	        	</div>
	    	</div>
		</div>
	</div>
</body>
