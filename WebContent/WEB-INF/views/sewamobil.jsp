<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/header.jsp" %>

<%@page import="java.util.List"%>
<%@page import="model.Supir"%>


<%
if(akun==null) { // Means session is not there
	session.setAttribute("login","login");%>
	<jsp:forward page="/index.jsp" />
<%}%>


<%
String tanggal = (String)session.getAttribute("tanggal");

if(tanggal!=null) { // Means session is not there
%>
<script>alert("Silahkan masukan tanggal yang sesuai!");</script>
<%session.removeAttribute("tanggal");
}
%>


<br />
<br />
<div class="container">
  <div class="row">
    <div class="col-sm-4">
      <div class="card">
        <img src="assets/image/mobil/${sessionScope['mobil'].id}.jpg" class="card-img-top" style="height: 200px" />
        <div class="card-body" style="background: #ddd">
          <h5 class="card-title">${sessionScope['mobil'].nama}</h5>
        </div>
        <ul class="list-group list-group-flush">
          <li class="list-group-item bg-primary text-white">
            <i class="fa fa-check"></i> Available
          </li>
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
          <form method="post" action="<%= request.getContextPath() %>/confirmSewa" enctype="multipart/form-data">
            <div class="form-group">
              <label for="">KTP</label>
              <input type="file" accept="image/*" class="form-control" name="ktp" placeholder="Isi KTP">
            </div>
            <div class="form-group">
              <label for="">SIM</label>
              <input type="file" accept="image/*" class="form-control" name="sim" placeholder="Isi SIM">
            </div>
            <div class="form-group">
              <label for="">Alamat</label>
              <input type="text" name="alamat" id=""required class="form-control" placeholder="Alamat"/>
            </div>
            <div class="form-group">
              <label for="">Telepon</label>
              <input type="text" name="telp" id="" required class="form-control" placeholder="Telepon"/>
            </div>
            <div class="form-group">
              <label for="">Tanggal Sewa</label>
              <input type="date" name="tanggal" id=""required class="form-control"/>
            </div>
            <div class="form-group">
              <label for="">Lama Sewa</label>
              <input type="number" name="lama_sewa" id=""required class="form-control" placeholder="Lama Sewa"/>
            </div>
            <div class="form-group">
	            <label for="">Supir</label> 	            
	            
	            <%
					Supir supir = (Supir)session.getAttribute("supir");
					
					if(supir==null) { // Means session is not there
					%>
					<div class="alert alert-danger" role="alert">
					  Maaf supir tidak tersedia saat ini !
					</div>
				<%}else {%>
					<select id="supir" name="supir" class="form-control">
					  <option value = "iya">Dengan Supir</option>
					  <option value = "tidak">Tanpa Supir</option>
					</select>
				<%}%>  
				             
            </div>
            <hr />
            <button type="submit" class="btn btn-primary float-right" onclick="return confirm('Apakah anda ingin konfirmasi sewa ?');"/>
              Booking Now
            </button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>

<br />

<br />

<%@include file="/footer.jsp" %>
