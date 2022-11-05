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
	  ID : ${sessionScope['customer'].id}<br>
	  Email 	: ${sessionScope['customer'].email}<br>
	  Password 	: ${sessionScope['customer'].password}<br>
	  Nama 		: ${sessionScope['customer'].nama}<br>
	  KTP 		: ${sessionScope['customer'].ktp}<br>
	  SIM 		: ${sessionScope['customer'].sim}<br>
	  No Telp 	: ${sessionScope['customer'].telp}<br>
	  </p>
	  
	  <h3>Daftar Mobil yang Tersedia : </h3>
	



	<h2 align="center"><font><strong>Retrieve data from database in jsp</strong></font></h2>
	<table align="center" cellpadding="5" cellspacing="5" border="1">
	<tr>
	
	</tr>
	<tr bgcolor="#A52A2A">
	<td><b>ID</b></td>
	<td><b>NAMA</b></td>
	<td><b>PLAT</b></td>
	<td><b>PESAN</b></td>
	</tr>
	<%
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	try{ 
	connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TEST", "123");
	statement=connection.createStatement();
	String sql ="SELECT * FROM mobil";
	
	resultSet = statement.executeQuery(sql);
	while(resultSet.next()){
	%>
	<tr bgcolor="#DEB887">
	
	<td><%=resultSet.getString("id") %></td>
	<td><%=resultSet.getString("nama") %></td>
	<td><%=resultSet.getString("plat") %></td>
	<td><input type="submit" value="Pesan" /></td>
	
	</tr>
	
	<% 
	}
	
	} catch (Exception e) {
	e.printStackTrace();
	}
	%>
	</table>

	
</body>
</html>