<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	  <h1>Selamat Datang ${sessionScope['customer'].nama}</h1>
	  
	  <p align = "left">
	  ID 		: ${sessionScope['customer'].id}<br>
	  Email 	: ${sessionScope['customer'].email}<br>
	  Password 	: ${sessionScope['customer'].password}<br>
	  Nama 		: ${sessionScope['customer'].nama}<br>
	  KTP 		: ${sessionScope['customer'].ktp}<br>
	  SIM 		: ${sessionScope['customer'].sim}<br>
	  No Telp 	: ${sessionScope['customer'].telp}<br>
	  </p>
	  
	</div>
	<h2 align="center"><font><strong>Daftar Mobil yang Tersedia</strong></font></h2>
	<table align="center" cellpadding="5" cellspacing="5" border="1">
	<tr>
	
	</tr>
	<tr bgcolor="#A52A2A">
	<td><b>ID</b></td>
	<td><b>PLAT</b></td>
	<td><b>NAMA</b></td>
	<td><b>TAHUN</b></td>
	<td><b>TIPE</b></td>
	<td><b>MEREK</b></td>
	<td><b>KAPASITAS</b></td>
	<td><b>HARGA</b></td>
	<td><b>PESAN</b></td>
	</tr>
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
	<tr bgcolor="#DEB887">
	
	<td><%=resultSet.getString("id") %></td>
	<td><%=resultSet.getString("plat") %></td>
	<td><%=resultSet.getString("nama") %></td>
	<td><%=resultSet.getString("tahun") %></td>
	<td><%=resultSet.getString("tipe") %></td>
	<td><%=resultSet.getString("merek") %></td>
	<td><%=resultSet.getInt("kapasitas") %></td>
	<td><%=resultSet.getInt("harga") %></td>
	<td>
	<form action="<%= request.getContextPath() %>/sewa" method="get">
		<input type='hidden' name='mobil_id' value=<%=resultSet.getString("id") %> />
		<input type='hidden' name='mobil_plat' value=<%=resultSet.getString("plat") %> />
		<input type='hidden' name='mobil_nama' value=<%=resultSet.getString("nama") %> />
		<input type='hidden' name='mobil_tahun' value=<%=resultSet.getString("tahun") %> />
		<input type='hidden' name='mobil_tipe' value=<%=resultSet.getString("tipe") %> />
		<input type='hidden' name='mobil_merek' value=<%=resultSet.getString("merek") %> />
		<input type='hidden' name='mobil_kapasitas' value=<%=resultSet.getInt("kapasitas") %> />
		<input type='hidden' name='mobil_harga' value=<%=resultSet.getInt("harga") %> />
		<input type='submit' value='Pesan' />
	</form>
	</td>
	

	</tr>
	
	<% 
	}
	} catch (Exception e) {
	e.printStackTrace();
	}
	statement.close();
	connection.close();
	%>
	</table>
	
	<form action="<%= request.getContextPath() %>/reset" method="get">
		<input type='submit' value='Reset' />
	</form>

	
</body>
</html>