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
<br>
<div class="container">
<div class="row">
    <div class="col-sm-12">
        <div class="card">
            <div class="card-header">
                <h5> Cari Booking</h5>
            </div>
            <div class="card-body">
                <form method="get" action="peminjaman.php">
                    <input type="text" class="form-control" 
                    value="<?php if(!empty($_GET['id'])){ echo $_GET['id']; }?>" name="id" placeholder="Tulis Kode Booking [ ENTER ]">
                </form>
            </div>
        </div>
        <br>
    </div>
    <?php if(!empty($_GET['id'])){?>
    <div class="col-sm-4">
        <div class="card">
            <div class="card-header">
                <h5> Detail Pembayaran</h5>
            </div>
            <div class="card-body">
                <table class="table">
                    <tr>
                        <td>No Rekening</td>
                        <td> :</td>
                        <td><?= $hsl['no_rekening'];?></td>
                    </tr>
                    <tr>
                        <td>Atas Nama </td>
                        <td> :</td>
                        <td><?= $hsl['nama_rekening'];?></td>
                    </tr>
                    <tr>
                        <td>Nominal  </td>
                        <td> :</td>
                        <td>Rp. <?= number_format($hsl['nominal']);?></td>
                    </tr>
                    <tr>
                        <td>Tgl  Transfer</td>
                        <td> :</td>
                        <td><?= $hsl['tanggal'];?></td>
                    </tr>
                </table>
            </div>
        </div>
        <br/>
        <div class="card">
            <div class="card-header">
                <h5 class="card-title"><?php echo $isi['merk'];?></h5>
            </div>
                <ul class="list-group list-group-flush">
                <?php if($isi['status'] == 'Tersedia'){?>
                    <li class="list-group-item bg-primary text-white">
                        <i class="fa fa-check"></i> Available
                    </li>
                <?php }else{?>
                    <li class="list-group-item bg-danger text-white">
                        <i class="fa fa-close"></i> Not Available
                    </li>
                <?php }?>
                <li class="list-group-item bg-info text-white"><i class="fa fa-check"></i> Free E-toll 50k</li>
                <li class="list-group-item bg-dark text-white">
                    <i class="fa fa-money"></i> Rp. <?php echo number_format($isi['harga']);?>/ day
                </li>
            </ul>
        </div>
    </div>
    <div class="col-sm-8">
         <div class="card">
            <div class="card-header">
                <h5 class="card-title">Detail Booking & Status Mobil</h5>
            </div>
           <div class="card-body">
               <form method="post" action="proses.php?id=konfirmasi">
                    <table class="table">
                        <tr>
                            <td>Kode Booking  </td>
                            <td> :</td>
                            <td><?php echo $hasil['kode_booking'];?></td>
                        </tr>
                        <tr>
                            <td>KTP  </td>
                            <td> :</td>
                            <td><?php echo $hasil['ktp'];?></td>
                        </tr>
                        <tr>
                            <td>Nama  </td>
                            <td> :</td>
                            <td><?php echo $hasil['nama'];?></td>
                        </tr>
                        <tr>
                            <td>telepon  </td>
                            <td> :</td>
                            <td><?php echo $hasil['no_tlp'];?></td>
                        </tr>
                        <tr>
                            <td>Tanggal Sewa </td>
                            <td> :</td>
                            <td><?php echo $hasil['tanggal'];?></td>
                        </tr>
                        <tr>
                            <td>Lama Sewa </td>
                            <td> :</td>
                            <td><?php echo $hasil['lama_sewa'];?> hari</td>
                        </tr>
                        <tr>
                            <td>Total Harga </td>
                            <td> :</td>
                            <td>Rp. <?php echo number_format($hasil['total_harga']);?></td>
                        </tr>
                        <tr>
                            <td>Status Mobil</td>
                            <td> :</td>
                            <td>
                                <select class="form-control" name="status">
                                  
                                </select>    
                            </td>
                        </tr>
                    </table>
                    <input type="hidden" name="id_mobil" value="<?php echo $isi['id_mobil'];?>">
                    <button type="submit" class="btn btn-primary float-right">
                        Ubah Status
                    </button>
            </form>
               
           </div>
         </div> 
    </div>
    <?php }?>
</div>
</div>
<br>
<br>
<br>
</body>
</html>
<%@include file="footer.jsp" %>