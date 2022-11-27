<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/headeradmin.jsp" %>
<%@page import="java.util.List"%>
<%@page import="model.Sewa"%>
<%@page import="model.Pembayaran"%>

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
    <div class="col-sm-4">
        <div class="card">
            <div class="card-header">
                <h5> Detail Pembayaran</h5>
            </div>
            <div class="card-body">
            
            <% Pembayaran pembayaran = (Pembayaran)session.getAttribute("pembayaran");
            
            	if(pembayaran != null){ // means session is not there
            		%>
            		<table class="table">
                    <tr>
                        <td>No Rekening</td>
                        <td> :</td>
                        <td>${sessionScope['pembayaran'].rekening}</td>
                    </tr>
                    <tr>
                        <td>Atas Nama </td>
                        <td> :</td>
                        <td>${sessionScope['sewa'].nama}</td>
                    </tr>
                    <tr>
                        <td>Nominal  </td>
                        <td> :</td>
                        <td>Rp. <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${sessionScope['pembayaran'].nominal}"/>,-</td>
                    </tr>
                    <tr>
                        <td>Tgl  Transfer</td>
                        <td> :</td>
                        <td>${sessionScope['pembayaran'].tanggal}</td>
                    </tr>
            		</table>
					<%}else{%>
					<h4>Belum di bayar</h4>
            		
            	<%}%> 
           
                
            </div>
        </div>
        <br/>
        <div class="card">
            <div class="card-header">
                <h5 class="card-title">${sessionScope['mobil'].nama}</h5>
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
            <div class="card-footer">
                <a href="<?php echo $url;?>admin/peminjaman/peminjaman.php?id=<?php echo $hasil['kode_booking'];?>" 
                    class="btn btn-success btn-md">Ubah Status Peminjaman</a>
            </div>
        </div>
    </div>
    <div class="col-sm-8">
         <div class="card">
            <div class="card-header">
                <h5> Detail booking</h5>
            </div>
           <div class="card-body">
               <form method="post" action="">
                    <table class="table">
                        <tr>
                            <td>Kode Booking  </td>
                            <td> :</td>
                            <td>${sessionScope['sewa'].id}</td>
                        </tr>
                        <tr>
                            <td>KTP  </td>
                            <td> :</td>
                            <td>${sessionScope['sewa'].ktp}</td>
                        </tr>
                        <tr>
                            <td>Nama  </td>
                            <td> :</td>
                            <td>${sessionScope['sewa'].nama}</td>
                        </tr>
                        <tr>
                            <td>Telepon  </td>
                            <td> :</td>
                            <td>${sessionScope['sewa'].telepon}</td>
                        </tr>
                        <tr>
                            <td>Tanggal Sewa </td>
                            <td> :</td>
                            <td>${sessionScope['sewa'].tgl_sewa}</td>
                        </tr>
                        <tr>
                            <td>Lama Sewa </td>
                            <td> :</td>
                            <td>${sessionScope['sewa'].lama_sewa} hari</td>
                        </tr>
                        <tr>
                            <td>Total Harga </td>
                            <td> :</td>
                            <td>Rp. <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${sessionScope['sewa'].total_bayar}"/>,-</td>
                        </tr>
                        <tr>
                            <td>Status </td>
                            <td> :</td>
                            <td>
                                <select class="form-control" name="status">
                                   	<option value = "iya">${sessionScope['sewa'].status}</option>
					  				<option value = "tidak">Lunas</option>
					  				<option value = "tidak">Pembayaran Ditolak</option>
					  				<option value = "tidak">Berjalan</option>
					  				<option value = "tidak">Selesai</option>
                                </select>    
                            </td>
                        </tr>
                    </table>
                    <input type="hidden" name="id_booking" value="<?php echo $hasil['id_booking'];?>">
                    <button type="submit" class="btn btn-primary float-right">
                        Ubah Status
                    </button>
            </form>
               
           </div>
         </div> 
    </div>
</div>
</div>
<br>
<br>
<br>
</body>
</html>