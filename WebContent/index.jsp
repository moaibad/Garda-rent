<%@include file="header.jsp" %>


<%
String username = (String)session.getAttribute("username");

if(username!=null) { // Means session is not there
session.setAttribute("login","login");%>
<jsp:forward page="/WEB-INF/views/customerhome.jsp" />
<%}%>


<%
String login = (String)session.getAttribute("login");

if(login!=null) { // Means session is not there
%>
<script>alert("Silahkan login!");</script>
<%session.removeAttribute("login");
}
%>

<style>
body{
    min-height: 100vh;
}
</style>

<body>
	<div style="padding-top:50px;padding-bottom:50px" align="center">
		<div class="col-sm-3">
	    	<div class="card" style=" background: #ddd;width: 25rem">
	        	<div class="card-body">
	                   Selamat Datang , Silahkan Login!
	                   <br/>
	                   <br/>
	                   <form method="post" action="<%= request.getContextPath() %>/login">
	                       <center><h4 class="card-title">Login</h4></center>
	                       <h6 class="card-subtitle mb-2 text-muted"></h6>
	                       <div class="form-group">
	                       <label for="">Username</label>
	                       <input type="text" name="username" id="" class="form-control" placeholder="" aria-describedby="helpId">
	                       </div>
	                       <div class="form-group">
	                       <label for="">Password</label>
	                       <input type="password" name="password" id="" class="form-control" placeholder="" aria-describedby="helpId">
	                       </div>
	                       <center><button class="btn btn-primary">Login</button>
	                       
	                       <!-- Button trigger modal -->
	                       <a class="btn btn-danger text-white" data-toggle="modal" data-target="#modelId">
                            Daftar
                         	</a></center>
	                   </form>
	        	</div>
	    	</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	

<!-- Modal -->
<div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Daftar Pengguna</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
            </div>
            <div class="modal-body">
                <form method="post" action="<%= request.getContextPath() %>/register">
                    <div class="form-group">
                    <label for="">Nama Pengguna</label>
                    <input type="text" name="nama" class="form-control" required>
                    </div>
                    <div class="form-group">
                    <label for="">Username</label>
                    <input type="text" name="username" id="" class="form-control"  required placeholder="" aria-describedby="helpId">
                    </div>
                    <div class="form-group">
                    <label for="">Password</label>
                    <input type="password" name="password" id="" class="form-control" required placeholder="" aria-describedby="helpId">
                    </div>
                    <div class="form-group">
                    <label for="">Email</label>
                    <input type="text" name="email" id="" class="form-control" required placeholder="" aria-describedby="helpId">
                    </div>
            </div>
            <div class="modal-footer">
                <a class="btn btn-secondary text-white" data-dismiss="modal">Close</a>
                <button type="submit" class="btn btn-primary">Save</button>
            </div>
            </form>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>