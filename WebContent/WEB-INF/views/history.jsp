<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@page import="model.Sewa"%>
<%@include file="/header.jsp" %>

<br>
<br>
<div class="container">
<div class="row">
    <div class="col-sm-12">
         <div class="card">
            <div class="card-header">
                Daftar Transaksi
            </div>
            <div class="card-body">
                <table class="table table-striped table-bordered table-sm">
                    <thead>
                        <tr>
                            <th>No. </th>
                            <th>Kode Booking</th>
                            <th>Merk Mobil</th>
                            <th>Nama </th>
                            <th>Tanggal Sewa </th>
                            <th>Lama Sewa </th>
                            <th>Total Harga</th>
                            <th>Konfirmasi</th>
                            <th>Aksi</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        int no = 1;
                        List<Sewa> listSewa = (List<Sewa>)session.getAttribute("listSewa");
                        for(Sewa sewa : listSewa){
                        %>
                        <tr>
                            <td><%out.print(no);%></td>
                            <td><%=sewa.getId()%></td>
                            <td><%=sewa.getNama_mobil()%></td>
                            <td><%=sewa.getNama()%></td>
                            <td></td>
                            <td><%=sewa.getLama_sewa()%> Hari</td>
                            <td>Rp. <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "<%=sewa.getTotal_bayar()%>" />,-</td>
                            <td><%=sewa.getStatus()%></td>
                            <td><a class="btn btn-primary" href="/Garda-rent/detailsewa?id=<%=sewa.getId()%>" role="button">Detail</a></td>
                        </tr>
                        <%
						no++;}
						%>
					</tbody>
                </table>
           </div>
         </div> 
    </div>
</div>
</div>

<br>

<br>

<br>

<%@include file="/footer.jsp" %>
