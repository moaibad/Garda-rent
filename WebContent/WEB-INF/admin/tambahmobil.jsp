<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/headeradmin.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<br>
<div class="container">
    <div class="card">
        <div class="card-header text-white bg-primary">
            <h4 class="card-title">
                Tambah Mobil
                <div class="float-right">
                    <a class="btn btn-warning" onclick="history.back()" role="button">Kembali</a>
                </div>
            </h4>
        </div>
        <div class="card-body">
            <div class="container">
                <form method="post" action="<%= request.getContextPath() %>/adminconfirmtambahmobil" enctype="multipart/form-data">
                    <div class="row">

                        <div class="col-sm-6">

                            <div class="form-group row">
                                <label class="col-sm-3">No Plat</label>
                                <input type="text" class="form-control col-sm-9" name="plat" placeholder="Isi No Plat">
                            </div>
							
							<div class="form-group row">
                                <label class="col-sm-3">Nama</label>
                                <input type="text" class="form-control col-sm-9" name="nama" placeholder="Isi Nama">
                            </div>
                            
                            <div class="form-group row">
                                <label class="col-sm-3">Merek</label>
                                <input type="text" class="form-control col-sm-9" name="merek" placeholder="Isi Merek">
                            </div>
                            
                            <div class="form-group row">
                                <label class="col-sm-3">Tahun</label>
                                <input type="text" class="form-control col-sm-9" name="tahun" placeholder="Isi Tahun">
                            </div>
                            
                            <div class="form-group row">
                                <label class="col-sm-3">Tipe</label>
                                <input type="text" class="form-control col-sm-9" name="tipe" placeholder="Isi Tipe">
                            </div>

                            <div class="form-group row">
                                <label class="col-sm-3">Kapasitas</label>
                                <input type="number" class="form-control col-sm-9" name="kapasitas" placeholder="Isi Kapasitas">
                            </div>

                        </div>

                        <div class="col-sm-6">
                        	<div class="form-group row">
                                <label class="col-sm-3">Harga</label>
                                <input type="number" class="form-control col-sm-9" name="harga" placeholder="Isi Harga">
                            </div>

                            <div class="form-group row">
                                <label class="col-sm-3">Deskripsi</label>
                                <input type="text" class="form-control col-sm-9" name="deskripsi" placeholder="Isi Deskripsi">
                            </div>

                            <div class="form-group row">
                                <label class="col-sm-3">Status</label>
                                <select class="form-control col-sm-9" name="status">
                                    <option value="" disabled selected>Pilih Status</option>
                                    <option value="Tersedia">Tersedia</option>
                                    <option value="Tidak Tersedia">Tidak Tersedia</option>
                                </select>
                            </div>

                            <div class="form-group row">
                                <label class="col-sm-3">Gambar</label>
                                <input type="file" accept="image/*" class="form-control col-sm-9" name="gambar" placeholder="Isi Gambar">
                                
                            </div>
                        </div>
                    </div>
                    <hr>
                    <div class="float-right">
                        <button type="submit" class="btn btn-primary">Tambah</button>
                    </div>
                </form>       
            </div>
        </div>
    </div>
</div>
</body>
</html>

<%@include file="/footer.jsp" %>