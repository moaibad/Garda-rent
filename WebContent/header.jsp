<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="model.Akun"%>

<!doctype html>
<html>
  <head>
  	<meta charset="ISO-8859-1">
    <title>Rental Mobil</title>
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="assets/css/bootstrap.css" >
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
  </head>
  <body>
    <div class="jumbotron pt-4 pb-4">
        <div class="row">
            <div class="col-sm-8">
                <h2><b style="text-transform:uppercase;">GARDA-RENT</b></h2>
            </div>
        </div>
    </div>
    <div style="margin-top:-2pc"></div>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
            <a class="navbar-brand" href="#"></a>
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="nav-link" href="http://localhost:8081/Garda-rent/home">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="http://localhost:8081/Garda-rent/daftarmobil">Daftar Mobil</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="http://localhost:8081/Garda-rent/kontak">Kontak Kami</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="http://localhost:8081/Garda-rent/history?id=${sessionScope['akun'].id}">History</a>
                </li>
              </ul>
                <% Akun akun = (Akun)session.getAttribute("akun");
                if(akun != null){%>
	            <ul class="navbar-nav my-2 my-lg-0">
	                <li class="nav-item">
	                    <a class="nav-link" href="#">
	                        <i class="fa fa-user"> </i> Hallo, ${sessionScope['akun'].nama}
	                    </a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" onclick="return confirm('Apakah anda ingin logout ?');" href="http://localhost:8081/Garda-rent/logout">Logout</a>
	                </li>
	            </ul>
	            <% }%>
        </div>
    </nav>