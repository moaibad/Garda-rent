<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@page import="model.Sewa"%>
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
        <div class="col-sm-6 mx-auto">
            <div class="card">
                <div class="card-header">
                    Kontak Kami
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-4">Nama Rental</div>
                        <div class="col-sm-8">Garda-rent</div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-sm-4">Telp</div>
                        <div class="col-sm-8">022-6632298</div>
                    </div>
                	<div class="row mt-3">
                        <div class="col-sm-4">Whatsapp</div>
                        <div class="col-sm-8">0813 6335 5015</div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-sm-4">Alamat</div>
                        <div class="col-sm-8">Jl. Gegerkalong Hilir, Ciwaruga, Kec. Parongpong, Kabupaten Bandung Barat, Jawa Barat 40559, Indonesia</div>
                    </div>
                
                    <div class="row mt-3">
                        <div class="col-sm-4">Email</div>
                        <div class="col-sm-8">gardarent@gmail.com</div>
                    </div>
                
                    <div class="row mt-3">
                        <div class="col-sm-4">No Rekening</div>
                        <div class="col-sm-8">BRI A/N Suci Awalia Gardara 0700006801322</div>
                    </div>
                </div>
            </div> 
        </div>
    </div>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<%@include file="/footer.jsp" %>
