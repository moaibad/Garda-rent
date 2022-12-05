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
<div class="container mt-4">
    
        <div class="col-sm-6">
            <div class="card">
                <div class="card-header">
                    Profil Admin
                </div>
                <div class="card-body">
                    <form action="" method="post">
                    
                        <div class="form-group">
                            <label for="">Nama Pengguna</label>
                            <input type="text" class="form-control" value="${sessionScope['akun'].nama}" name="nama_pengguna" id="nama_pengguna" placeholder="" disabled/>
                        </div>
                        <div class="form-group">
                            <label for="">Username</label>
                            <input type="text" required class="form-control" value="${sessionScope['akun'].username}" name="username" id="username" placeholder="" disabled/>
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
<br>
<br>
</html>
<%@include file="/footer.jsp" %>