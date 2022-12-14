<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/headeradmin.jsp" %>

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
                Edit Mobil - ${sessionScope['mobil'].nama}
                <div class="float-right">
                    <a class="btn btn-warning" onclick="history.back()" role="button">Kembali</a>
                </div>
            </h4>
        </div>
        <div class="card-body">
            <div class="container">
                <form method="post" action="<%= request.getContextPath() %>/adminconfirmeditmobil">
                    <div class="row">

                        <div class="col-sm-6">

                            <div class="form-group row">
                                <label class="col-sm-3">No Plat</label>
                                <input type="text" class="form-control col-sm-9" value="${sessionScope['mobil'].plat}" name="no_plat" placeholder="Isi No Plat">
                            </div>

                            <div class="form-group row">
                                <label class="col-sm-3">Merk Mobil</label>
                                <input type="text" class="form-control col-sm-9"  value="${sessionScope['mobil'].merek}" name="merk" placeholder="Isi Merk">
                            </div>
                            
                            <div class="form-group row">
                                <label class="col-sm-3">Tahun</label>
                                <input type="text" class="form-control col-sm-9"  value="${sessionScope['mobil'].tahun}" name="tahun" placeholder="Isi Merk">
                            </div>
                            
                            <div class="form-group row">
                                <label class="col-sm-3">Warna</label>
                                <input type="text" class="form-control col-sm-9"  value="${sessionScope['mobil'].warna}" name="warna" placeholder="Isi Merk">
                            </div>

                            <div class="form-group row">
                                <label class="col-sm-3">Harga</label>
                                <input type="number" class="form-control col-sm-9"  value="${sessionScope['mobil'].harga}" name="harga" placeholder="Isi Harga">
                            </div>
                            
                            <div class="form-group row">
                                <label class="col-sm-3">Kapasitas</label>
                                <input type="number" class="form-control col-sm-9"  value="${sessionScope['mobil'].kapasitas}" name="kapasitas" placeholder="Isi Harga">
                            </div>
                            
                            <div class="form-group row">
                                <label class="col-sm-3">Kilometer</label>
                                <input type="number" class="form-control col-sm-9"  value="${sessionScope['mobil'].km}" name="km" placeholder="Isi Harga">
                            </div>

                        </div>

                        <div class="col-sm-6">

           
                            <div class="form-group row">
                                <label class="col-sm-3">Status</label>
                                <select class="form-control col-sm-9" name="status">
                                    <option value="${sessionScope['mobil'].status}" disabled selected>${sessionScope['mobil'].status}</option>
                                   	<option value="Tersedia" >Tersedia</option>
                                   	<option value="Tidak Tersedia" >Tidak Tersedia</option>
                                </select>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3">Penampakan</label>
                                <img src="assets/image/mobil/${sessionScope['mobil'].id}.jpg" class="img-fluid" style="width:200px;">                               
                            </div>
                            <input type="hidden" value="" name="gambar_cek">
                        </div>
                    </div>
                    <hr>
                    <div class="float-right">
                    	<input type="hidden" name="mobil_id" value="${sessionScope['mobil'].id}">
                        <button class="btn btn-primary" role="button" type="submit">
                            Simpan
                        </button>
                    </div>
                </form>       
            </div>
        </div>
    </div>
</div>
</body>
</html>

<%@include file="/footer.jsp" %>