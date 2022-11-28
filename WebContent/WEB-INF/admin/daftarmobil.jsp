<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/headeradmin.jsp" %>
<%@page import="java.util.List"%>
<%@page import="model.Mobil"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<div class="container">
    <div class="card">
        <div class="card-header text-white bg-primary">
            <h4 class="card-title">
                Daftar Mobil
                <div class="float-right">
                    <a class="btn btn-success" href="tambahmobil.jsp" role="button">Tambah</a>
                </div>
            </h4>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Gambar</th>
                            <th>Merk Mobil</th>
                            <th>No Plat</th>
                            <th>Harga</th>
                            <th>Status</th>
                            <th>Tahun</th>
                            <th>Aksi</th>
                        </tr>
                        <% 
                        List<Mobil> listMobil = (List<Mobil>)session.getAttribute("listMobil");
                        for(Mobil mobil : listMobil){
						%>
                        <tr>
                            <td><%=mobil.getId()%></td>
							<td><%=mobil.getPlat()%></td>
							<td><%=mobil.getMerek()%></td>
							<td><%=mobil.getPlat()%></td>
							<td>Rp. <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "<%=mobil.getHarga()%>"/>,-</td>
							<td><%=mobil.getStatus()%></td>
							<td><%=mobil.getTahun()%></td>
                            <td>
                                <a class="btn btn-primary btn-sm" href="http://localhost:8081/Garda-rent/admineditmobil?id=<%=mobil.getId()%>" role="button">Edit</a>  
                                <a class="btn btn-danger  btn-sm" href="" role="button">Hapus</a>  
                            </td>
                        </tr>
                        <%}%>
                       
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<%@include file="/footer.jsp" %>