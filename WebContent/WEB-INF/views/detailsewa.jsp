<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@include file="/header.jsp" %>


<%
if(akun==null) { // Means session is not there
	session.setAttribute("login","login");%>
	<jsp:forward page="/index.jsp" />
<%}%>

<%
String booking = (String)session.getAttribute("booking");

if(booking!=null) { // Means session is not there
%>
<script>alert("Anda Sukses Booking silahkan Melakukan Pembayaran");</script>
<%session.removeAttribute("booking");
}
%>

<br />
<br />
<div class="container">
  <div class="row">
    <div class="col-sm-4">
      <div class="card">
        <div class="card-body text-center">
          <h5>Pembayaran Dapat Melalui :</h5>
          <hr />
          <p>BRI A/N Suci Awalia Gardara 0700006801322</p>
        </div>
      </div>
      <br />
      <div class="card">
      	<img src="assets/image/mobil/${sessionScope['mobil'].id}.jpg" class="card-img-top" style="height:200px;object-fit:cover;">
      	
        <div class="card-body" style="background: #ddd">
          <h5 class="card-title">${sessionScope['mobil'].nama}</h5>
        </div>
        <ul class="list-group list-group-flush">
          <li class="list-group-item bg-info text-white">
            <i class="fa fa-check"></i> Free E-toll 50k
          </li>
          <li class="list-group-item bg-dark text-white">
            <i class="fa fa-money"></i> Rp. ${sessionScope['mobil'].harga}/ day
          </li>
        </ul>
      </div>
    </div>
    <div class="col-sm-8">
      <div class="card">
        <div class="card-body">
          <table class="table">
            <tr>
              <td>Kode Booking</td>
              <td>:</td>
              <td>${sessionScope['sewa'].id}</td>
            </tr>
            <tr>
              <td>Nama</td>
              <td>:</td>
              <td>${sessionScope['sewa'].nama}</td>
            </tr>
            <tr>
              <td>Telepon</td>
              <td>:</td>
              <td>${sessionScope['sewa'].telepon}</td>
            </tr>
            <tr>
              <td>Tanggal Sewa</td>
              <td>:</td>
              <td>${sessionScope['sewa'].tgl_sewa}</td>
            </tr>
            <tr>
              <td>Lama Sewa</td>
              <td>:</td>
              <td>${sessionScope['sewa'].lama_sewa} hari</td>
            </tr>
            <tr>
              <td>Tanggal Kembali</td>
              <td>:</td>
              <td>${sessionScope['sewa'].tgl_kembali}</td>
            </tr>
            <tr>
              <td>Total Harga</td>
              <td>:</td>
              <td>Rp. <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${sessionScope['sewa'].total_bayar}"/>,-</td>
            </tr>
            <tr>
              <td>Status</td>
              <td>:</td>
              <td>${sessionScope['sewa'].status}</td>
            </tr>
          </table>
		  
		  <c:if test="${sessionScope['sewa'].status == 'Belum Bayar'}">
		  	<div class="alert alert-warning" role="alert">
			  	Silahkan selesaikan pembayaran!
			</div>
			<a href="/Garda-rent/bayarsewa" class="btn btn-primary float-right">
				Konfirmasi Pembayaran
            </a>
		  </c:if>
		  
		  <c:if test="${sessionScope['sewa'].status == 'Sedang di proses'}">
			<div class="alert alert-primary" role="alert">
			  Mohon tunggu, pembayaran akan di proses 1x24 jam
			</div>
		  </c:if>
		  
		  <c:if test="${sessionScope['sewa'].status == 'Lunas'}">
			<div class="alert alert-success" role="alert">
			  Pembayaran Lunas, silahkan datang ke kantor pada tanggal yang telah ditentukan untuk mengambil mobil
			</div>
		  </c:if>
          
          <c:if test="${sessionScope['sewa'].status == 'Denda'}">
			<div class="alert alert-danger" role="alert">
			  Anda sudah melewati jatuh tempo pengembalian, silahkan ke kantor untuk mengembalikan mobil dan membayar biaya keterlambatan !
		  </c:if>
		  
        </div>
      </div>
    </div>
  </div>
</div>
<br />
<br />
<br />

<%@include file="/footer.jsp" %>
