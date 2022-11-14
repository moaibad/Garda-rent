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
                    <a class="nav-link" href="index.php">Home&nbsp&nbsp<span class="sr-only">(current)</span></a>
                </li>	
                <li class="nav-item active">
                    <a class="nav-link" href="blog.php">User&nbsp&nbsp</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="kontak.php">Daftar Mobil&nbsp&nbsp</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="kontak.php">Daftar Booking&nbsp&nbsp</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="kontak.php">Peminjaman/Pengembalian</a>
                </li>
             </ul>
             <ul class="navbar-nav my-2 my-lg-0">
             <li class="nav-item">
             	<a class ="nav-link" href="#">
             		<i class="fa fa-user"></i><h1>Hallo, ${sessionScope['customer'].nama}</h1>
             	</a>
             </li>
             <li class="nav-item">
             	<a class ="nav-link" onclick="return confirm('Apakah anda ingin logout?');"href="admin/logout.jsp">Logout</a>
             </li>
             </ul>
        </div>
    </nav>