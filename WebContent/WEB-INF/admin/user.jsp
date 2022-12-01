<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@include file="/headeradmin.jsp" %>

<%@page import="java.util.List"%>
<%@page import="model.Akun"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br>
	<div class="container">
	    <div class="card">
	        <div class="card-header text-white bg-primary">
	            <h5 class="card-title pt-2">
	                Daftar User
	            </h5>
	        </div>
	        <div class="card-body">
	            <div class="table-responsive">
	                <table class="table table-striped table-bordered table-sm">
	                    <thead>
	                        <tr>
	                            <th>No</th>
	                            <th>Nama Pengguna</th>
	                            <th>Username</th>
	                            <th>Aksi</th>
	                        </tr>
	                    	<% 
	                    	List<Akun> listUser = (List<Akun>)session.getAttribute("listUser");
	                        for(Akun akun : listUser){
							%>
	                         <tr>
								<td><%=akun.getId()%></td>
								<td><%=akun.getNama()%></td>
								<td><%=akun.getUsername() %></td>
	                            <td>
	                            	<a href="http://localhost:8081/Garda-rent/adminsewa?id=<%=akun.getId()%>" class="btn btn-success btn-sm">Edit User</a>  
	                                <a href="http://localhost:8081/Garda-rent/adminsewa?id=<%=akun.getId()%>" class="btn btn-primary btn-sm">Detail Transaksi</a>                                 
	                            </td>   
	                        </tr>
	                        <%} %>
						</thead>	                    
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
	<br>
	<br>
</html>
<%@include file="/footer.jsp" %>