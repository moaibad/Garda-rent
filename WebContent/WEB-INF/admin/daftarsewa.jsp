<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/headeradmin.jsp" %>
<%@page import="java.util.List"%>
<%@page import="model.Sewa"%>

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
            <h5 class="card-title">
            Daftar Sewa
            </h5>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-striped table-bordered table-sm">
                    <thead>
                        <tr>
                            <th>Kode Sewa</th>
                            <th>Nama</th>
                            <th>Lama Sewa</th>
                            <th>Status </th>
                            <th>Total Bayar</th>
                            <th>Aksi</th>
                        </tr>
                    <% 
                    List<Sewa> listSewa = (List<Sewa>)session.getAttribute("listSewa");
                    for(Sewa sewa : listSewa){
						%>
                        <tr>
							<td><%=sewa.getId()%></td>
							<td><%=sewa.getNama()%></td>
							<td><%=sewa.getLama_sewa()%> hari</td>
							<td><%=sewa.getStatus()%></td>
							<td>Rp. <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "<%=sewa.getTotal_bayar()%>"/>,-</td>
                            <td>
                                <a class="btn btn-primary" href="http://localhost:8081/Garda-rent/admindetailsewa?id=<%=sewa.getId()%>"
                                role="button">Detail</a>   
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

