<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<!doctype html>
<html lang="en">
  <head>
    <title>Rental Mobil</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->

    <link rel="stylesheet" href="assets/css/bootstrap.css" >
    <link rel="stylesheet" href="assets/css/font-awesome.css" >
   
    
  </head>
  <body>
    <div class="jumbotron pt-4 pb-4">
        <div class="row">
            <div class="col-sm-8">
                <h2><b style="text-transform:uppercase;">GARDA-RENT</b></h2>
            </div>
        </div>
    </div>
    <div style="margin-top:-2pc"></div>
    <nav class="navbar navbar-expand-lg navbar-dark" style = "background-color: #333;">
    <a class = "navbar-brand" href ="<adminhome.jsp"><b>Admin Panel</b></a>
        <button class="navbar-toggler text-white d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false" aria-label="Toggle navigation" style="color:#fff;">
        <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavId">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
 		       <li class="nav-item active">
                    <a class="nav-link" href="admin.jsp">Home<span class="sr-only">(current)</span></a>
                </li>	
                <li class="nav-item active">
                    <a class="nav-link" href="user.jsp">User</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="daftarmobil.jsp">Daftar Mobil</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="booking.jsp">Daftar Booking</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="peminjaman.jsp">Peminjaman/Pengembalian</a>
                </li>
             </ul>
             <ul class="navbar-nav my-2 my-lg-0">
             <li class="nav-item">
             	<a class ="nav-link" href="#">
             		<i class="fa fa-user"></i><h1>Hallo, ${sessionScope['akun'].nama}</h1>
             	</a>
             </li>
             <li class="nav-item">
             	<a class ="nav-link" onclick="return confirm('Apakah anda ingin logout?');"href="admin/logout.jsp">Logout</a>
             </li>
             </ul>
        </div>
    </nav>
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
            <h5 class="card-title">
            Daftar Booking
            </h5>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-striped table-bordered table-sm">
                    <thead>
                        <tr>
                            <th>Kode Booking</th>
                            <th>Nama</th>
                            <th>Harga Mobil</th>
                            <th>Lama Sewa</th>
                            <th>Status </th>
                            <th>Total Bayar</th>
                            <th>Aksi</th>
                        </tr>
                    <% 
						Connection connection = null;
						Statement statement = null;
						ResultSet resultSet = null;
						try{ 
						connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TUBES", "tubes");
						statement=connection.createStatement();
						String sql ="select * from sewa";
	
						resultSet = statement.executeQuery(sql);
						System.out.println(statement);
						while(resultSet.next()){
						%>
                        <tr>
							<td><%=resultSet.getString("id") %></td>
							<td><%=resultSet.getString("nama") %></td>
							<td><%=resultSet.getInt("harga") %></td>
							<td><%=resultSet.getInt("lama_sewa") %></td>
							<td><%=resultSet.getString("status") %></td>
							<td><%=resultSet.getInt("total_bayar") %></td>
                            <td>
                                <a class="btn btn-primary" href="bayar.jsp"
                                role="button">Detail</a>   
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
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<%@include file="footer.jsp" %>