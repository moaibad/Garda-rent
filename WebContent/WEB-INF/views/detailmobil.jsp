<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@include file="/header.jsp" %>

<%@page import="model.Mobil"%>

<%
if(akun==null) { // Means session is not there
	session.setAttribute("login","login");%>
	<jsp:forward page="/index.jsp" />
<%}%>

<div class="container mt-5">
	<div class="row">
    	<div class="col-sm-6">
        	<img class="card-img-top w-100" 
            	style="object-fit:cover;" 
            	src="assets/image/mobil/${sessionScope['mobil'].id}.jpg" alt="">
    	</div>
    	<div class="col-sm-6">
        	<div class="card">
            	<div class="card-body">
	                <h4 class="card-title">${sessionScope['mobil'].nama}</h4>
	                <p class="card-text">
	                    Merek : ${sessionScope['mobil'].merek}
	                </p>
	                <p class="card-text">
	                    Tipe : ${sessionScope['mobil'].tipe}
	                </p>
	                <p class="card-text">
	                    Tahun : ${sessionScope['mobil'].tahun}
	                </p>
	                <p class="card-text">
	                    Warna : ${sessionScope['mobil'].warna}
	                </p>
	                <p class="card-text">
	                    Kapasitas : ${sessionScope['mobil'].kapasitas} orang
	                </p>
	                <p class="card-text">
	                    Kilometer : ${sessionScope['mobil'].km} km
	                </p>
	                <ul class="list-group list-group-flush">
	                
	              		<% 
	              		String status_mobil = (String)session.getAttribute("status_mobil");
	              		if(status_mobil.equals("Tersedia")) {%>
					    <li class="list-group-item bg-primary text-white">
                        	<i class="fa fa-check"></i>  Available
                        </li>
                        <%}else{%>
                        	<li class="list-group-item bg-danger text-white">
                                <i class="fa fa-close"></i> Not Available
                            </li>
                        <%}%>
	                    
	                    <li class="list-group-item bg-info text-white"><i class="fa fa-check"></i> Free E-toll 50k</li>
	                    <li class="list-group-item bg-dark text-white">
	                        <i class="fa fa-money"></i> Rp. ${sessionScope['mobil'].harga} / day
	                    </li>
	                </ul>
	                
	                <hr/>
	                <center>
	                
						<% if(status_mobil.equals("Tersedia")) {%>
							<a href="/Garda-rent/sewa?id=${sessionScope['mobil'].id}" class="btn btn-success">Booking now!</a>
						<%}%>
	                    <a href="/Garda-rent/home" class="btn btn-info">Back</a>
                 
	                </center>
            	</div>
         	</div> 
    	</div>
	</div>
</div>

<%@include file="/footer.jsp" %>
</html>