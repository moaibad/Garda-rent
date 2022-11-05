<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1>Halaman Sewa Modil</h1>
  
  	<p align = "left">
	  ID 			: ${sessionScope['mobil'].id}<br>
	  Plat 			: ${sessionScope['mobil'].plat}<br>
	  Nama 			: ${sessionScope['mobil'].nama}<br>
	  Tahun 		: ${sessionScope['mobil'].tahun}<br>
	  Tipe 			: ${sessionScope['mobil'].tipe}<br>
	  Merek 		: ${sessionScope['mobil'].merek}<br>
	  Kapasitas 	: ${sessionScope['mobil'].kapasitas}<br>
	  Harga 		: ${sessionScope['mobil'].harga}<br>
	</p>
 </div>
</body>
</html>