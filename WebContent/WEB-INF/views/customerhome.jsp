<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%@include file="/header.jsp" %>
<div class="container">
<div class="row">
    <div class="col-sm-12">
        <div class="row mt-3">
        <%
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try{ 
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TEST", "123");
		statement=connection.createStatement();
		String sql ="select * from mobil where status = 'Tersedia'";
		
		resultSet = statement.executeQuery(sql);
		System.out.println(statement);
		while(resultSet.next()){
		%>
            <div class="col-sm-4">
                <div class="card">
                <img src="" class="card-img-top" style="height:200px;object-fit:cover;">
                    <div class="card-body" style="background:#ddd">
                        <h5 class="card-title"><%=resultSet.getString("nama")%></h5>
                    </div>
                    <ul class="list-group list-group-flush">
					    <li class="list-group-item bg-primary text-white">
                        	<i class="fa fa-check"></i>  Available
                        </li>       
                        
                        <li class="list-group-item bg-info text-white"><i class="fa fa-money"></i> Free E-toll 50k</li>
                        <li class="list-group-item bg-dark text-white">
                           <i class="fa fa-money"></i> Rp. <%=resultSet.getString("harga")%> / day
                        </li>
                    </ul>
                    <div class="card-body">
                        <center>                        
	                        <form class="btn btn-success" action="<%= request.getContextPath() %>/sewa" method="post">
								<input type='hidden' name='mobil_id' value=<%=resultSet.getString("id") %> />
								<input type='hidden' name='mobil_plat' value=<%=resultSet.getString("plat") %> />
								<input type='hidden' name='mobil_nama' value=<%=resultSet.getString("nama") %> />
								<input type='hidden' name='mobil_tahun' value=<%=resultSet.getString("tahun") %> />
								<input type='hidden' name='mobil_tipe' value=<%=resultSet.getString("tipe") %> />
								<input type='hidden' name='mobil_merek' value=<%=resultSet.getString("merek") %> />
								<input type='hidden' name='mobil_kapasitas' value=<%=resultSet.getInt("kapasitas") %> />
								<input type='hidden' name='mobil_harga' value=<%=resultSet.getInt("harga") %> />
								<button type='submit' class="btn btn-success btn-sm">Booking Now!</button>
							</form>
                            <a href="detail.php?id=<?php echo $isi['id_mobil'];?>" class="btn btn-info">Detail</a>
                        </center>
                    </div>
                </div>
            </div>
        <% 
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		statement.close();
		connection.close();
		%>
        </div>
    </div>
</div>
</div>

<br>

<br>

<br>

<%@include file="/footer.jsp" %>
</html>