<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.List"%>
<%@page import="model.Mobil"%>

<%
String username = (String)session.getAttribute("username");

if(username==null) { // Means session is not there
%>
<jsp:forward page="/index.jsp" />
<%}%>


<%@include file="/header.jsp" %>
<div class="container">
<div class="row">
    <div class="col-sm-12">
        <div class="row mt-3">
        <%
		List<Mobil> listMobil = (List<Mobil>)session.getAttribute("listMobil");
        for(Mobil mobil : listMobil){
		%>
            <div class="col-sm-4">
                <div class="card">
                <img src="" class="card-img-top" style="height:200px;object-fit:cover;">
                    <div class="card-body" style="background:#ddd">
                        <h5 class="card-title"><%=mobil.getNama()%></h5>
                    </div>
                    <ul class="list-group list-group-flush">
					    <li class="list-group-item bg-primary text-white">
                        	<i class="fa fa-check"></i>  Available
                        </li>       
                        
                        <li class="list-group-item bg-info text-white"><i class="fa fa-money"></i> Free E-toll 50k</li>
                        <li class="list-group-item bg-dark text-white">
                           <i class="fa fa-money"></i> Rp. <%=mobil.getHarga()%> / day
                        </li>
                    </ul>
                    <div class="card-body">
                        <center>                        
	                        <form class="btn btn-success" action="<%= request.getContextPath() %>/sewa" method="post">
								<input type='hidden' name='mobil_id' value=<%=mobil.getId()%> />
								<input type='hidden' name='mobil_plat' value=<%=mobil.getPlat()%> />
								<input type='hidden' name='mobil_nama' value=<%=mobil.getNama()%> />
								<input type='hidden' name='mobil_tahun' value=<%=mobil.getTahun()%> />
								<input type='hidden' name='mobil_tipe' value=<%=mobil.getTipe()%> />
								<input type='hidden' name='mobil_merek' value=<%=mobil.getMerek()%> />
								<input type='hidden' name='mobil_kapasitas' value=<%=mobil.getKapasitas()%> />
								<input type='hidden' name='mobil_harga' value=<%=mobil.getHarga()%> />
								<button type='submit' class="btn btn-success btn-sm">Booking Now!</button>
							</form>
                            <a href="detail.php?id=<?php echo $isi['id_mobil'];?>" class="btn btn-info">Detail</a>
                        </center>
                    </div>
                </div>
            </div>
        <% } %> 
        </div>
    </div>
</div>
</div>

<br>

<br>

<br>

<%@include file="/footer.jsp" %>
</html>