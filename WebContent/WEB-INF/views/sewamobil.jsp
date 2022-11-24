<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/header.jsp" %>

<%@page import="java.util.List"%>
<%@page import="model.Supir"%>

<br />
<br />
<div class="container">
  <div class="row">
    <div class="col-sm-4">
      <div class="card">
        <img src="" class="card-img-top" style="height: 200px" />
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
          <form method="post"action="<%= request.getContextPath() %>/confirmSewa">
            <div class="form-group">
              <label for="">KTP</label>
              <input type="text" name="ktp" id="" required class="form-control" placeholder="KTP / NIK Anda" />
            </div>
            <div class="form-group">
              <label for="">Nama</label>
              <input type="text" name="nama" id=""required class="form-control" placeholder="Nama Anda" value="${sessionScope['akun'].nama}"/>
            </div>
            <div class="form-group">
              <label for="">Alamat</label>
              <input type="text" name="alamat" id=""required class="form-control" placeholder="Alamat"/>
            </div>
            <div class="form-group">
              <label for="">Telepon</label>
              <input type="text" name="no_tlp" id="" required class="form-control" placeholder="Telepon"/>
            </div>
            <div class="form-group">
              <label for="">Tanggal Sewa</label>
              <input type="date" name="tanggal" id="minDate"required class="form-control" placeholder="Nama Anda"/>
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
					  <option value = "dengan_supir">Dengan Supir</option>
					  <option value = "tanpa_supir">Tanpa Supir</option>
					</select>
				<%}%>  
				             
            </div>
            <hr />
            <button type="submit" class="btn btn-primary float-right">
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
