<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/header.jsp" %>


<%
if(akun==null) { // Means session is not there
	session.setAttribute("login","login");%>
	<jsp:forward page="/index.jsp" />
<%}%>

<br>
<br>
<div class="container">
<div class="row">
    <div class="col-sm-4">
        <div class="card">
            <div class="card-body">

                <center><h3>Pembayaran Dapat Melalui :</h3>
                <hr/>
                <p> BRI 2132131246 A/N Rental Suci </p></center>

            </div>
        </div>
    </div>
    <div class="col-sm-8">
         <div class="card">
           <div class="card-body">
               <form method="post" action="<%= request.getContextPath() %>/confirmbayar">
                    <table class="table">
                        <tr>
                            <td>Kode Booking  </td>
                            <td> :</td>
                            <td>${sessionScope['sewa'].id}</td>
                        </tr>
                        <tr>
                            <td>No Rekening   </td>
                            <td> :</td>
                            <td><input type="text" name="rekening" required class="form-control"></td>
                        </tr>
                        <tr>
                            <td>Atas Nama </td>
                            <td> :</td>
                            <td><input type="text" name="nama_rekening" required class="form-control"></td>
                        </tr>
                        <tr>
                            <td>Nominal  </td>
                            <td> :</td>
                            <td><input type="number" name="nominal" required class="form-control"></td>
                        </tr>
                        <tr>
                            <td>Tanggal  Transfer</td>
                            <td> :</td>
                            <td><input type="date" name="tanggal_transfer" id=""required class="form-control"></td>
                        </tr>
                        <tr>
                            <td>Total yg Harus di Bayar </td>
                            <td> :</td>
                            <td>Rp. <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${sessionScope['sewa'].total_bayar}" />,-</td>
                        </tr>
                    </table>
                    <input type="hidden" name="sewa_id" value="${sessionScope['sewa'].id}">
                    <button type="submit" class="btn btn-primary float-right" onclick="return confirm('Apakah anda ingin konfirmasi pembayaran?');">Kirim</button>
               </form>
           </div>
         </div> 
    </div>
</div>
</div>
<br>
<br>
<br>

<%@include file="/footer.jsp" %>
