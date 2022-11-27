<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
             		<i class="fa fa-user"></i><h5>Hallo, ${sessionScope['akun'].nama}</h5>
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
<div class="container mt-4">
    <div class="row">
        <div class="col-sm-6">
            <div class="card">
                <div class="card-header">
                    Info Website
                </div>
                <div class="card-body">
                    <form action="" method="post">
                        
                        <div class="form-group">
                            <label for="">Nama rental</label>
                            <input type="text" class="form-control" value="GARDA-RENT" name="nama_rental" id="nama_rental" placeholder=""/>
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="">Email</label>
                                    <input type="text" class="form-control" value="gardarent@123.com" name="email" id="email" placeholder=""/>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="">Telp</label>
                                    <input type="text" class="form-control" value="" name="telp" id="telp" placeholder=""/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="">Alamat</label>
                            <textarea class="form-control" name="alamat" id="alamat" placeholder=""></textarea>
                        </div>
                        <div class="form-group">
                            <label for="">No rek</label>
                            <textarea class="form-control" name="no_rek" id="no_rek" placeholder=""></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">
                            Simpan
                        </button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="card">
                <div class="card-header">
                    Profil Admin
                </div>
                <div class="card-body">
                    <form action="" method="post">
                    
                        <div class="form-group">
                            <label for="">Nama Pengguna</label>
                            <input type="text" class="form-control" value="${sessionScope['akun'].nama}" name="nama_pengguna" id="nama_pengguna" placeholder=""/>
                        </div>
                        <div class="form-group">
                            <label for="">Username</label>
                            <input type="text" required class="form-control" value="${sessionScope['akun'].username}" name="username" id="username" placeholder=""/>
                        </div>
                        <div class="form-group">
                            <label for="">Password</label>
                            <input type="text" required class="form-control" value="${sessionScope['akun'].password}" name="password" id="password" placeholder=""/>
                        </div>
                        <button type="submit" class="btn btn-primary">
                            Simpan
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<%@include file="footer.jsp" %>