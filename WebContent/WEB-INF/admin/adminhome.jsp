<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container mt-4">
    <div class="row">
        <div class="col-sm-6">
            <div class="card">
                <div class="card-header">
                    Info Website
                </div>
                <div class="card-body">
                    <form action="" method="post">
                        
                        <div class="form-group">
                            <label for="">Nama rental</label>
                            <input type="text" class="form-control" value="GARDA-RENT" name="nama_rental" id="nama_rental" placeholder=""/>
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="">Email</label>
                                    <input type="text" class="form-control" value="gardarent@123.com" name="email" id="email" placeholder=""/>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="">Telp</label>
                                    <input type="text" class="form-control" value="" name="telp" id="telp" placeholder=""/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="">Alamat</label>
                            <textarea class="form-control" name="alamat" id="alamat" placeholder=""></textarea>
                        </div>
                        <div class="form-group">
                            <label for="">No rek</label>
                            <textarea class="form-control" name="no_rek" id="no_rek" placeholder=""></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">
                            Simpan
                        </button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="card">
                <div class="card-header">
                    Profil Admin
                </div>
                <div class="card-body">
                    <form action="" method="post">
                    
                        <div class="form-group">
                            <label for="">Nama Pengguna</label>
                            <input type="text" class="form-control" value="${sessionScope['akun'].nama}" name="nama_pengguna" id="nama_pengguna" placeholder=""/>
                        </div>
                        <div class="form-group">
                            <label for="">Username</label>
                            <input type="text" required class="form-control" value="${sessionScope['akun'].username}" name="username" id="username" placeholder=""/>
                        </div>
                        <div class="form-group">
                            <label for="">Password</label>
                            <input type="text" required class="form-control" value="${sessionScope['akun'].password}" name="password" id="password" placeholder=""/>
                        </div>
                        <button type="submit" class="btn btn-primary">
                            Simpan
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<%@include file="footer.jsp" %>