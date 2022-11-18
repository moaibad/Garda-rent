<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/header.jsp" %>

<br />
<br />
<div class="container">
  <div class="row">
    <div class="col-sm-4">
      <div class="card">
        <div class="card-body text-center">
          <h5>Pembayaran Dapat Melalui :</h5>
          <hr />
          <p>BRI : 1011121314</p>
        </div>
      </div>
      <br />
      <div class="card">
        <div class="card-body" style="background: #ddd">
          <h5 class="card-title">${sessionScope['mobil'].nama}</h5>
        </div>
        <ul class="list-group list-group-flush">
          <li class="list-group-item bg-primary text-white">
            <i class="fa fa-check"></i> Available
          </li>
          <li class="list-group-item bg-info text-white">
            <i class="fa fa-check"></i> Free E-toll 50k
          </li>
          <li class="list-group-item bg-dark text-white">
            <i class="fa fa-money"></i> Rp. ${sessionScope['mobil'].harga}/ day
          </li>
        </ul>
      </div>
    </div>
    <div class="col-sm-8">
      <div class="card">
        <div class="card-body">
          <table class="table">
            <tr>
              <td>Kode Booking</td>
              <td>:</td>
              <td>${sessionScope['sewa'].id}</td>
            </tr>
            <tr>
              <td>KTP</td>
              <td>:</td>
              <td>${sessionScope['sewa'].ktp}</td>
            </tr>
            <tr>
              <td>Nama</td>
              <td>:</td>
              <td>${sessionScope['sewa'].nama}</td>
            </tr>
            <tr>
              <td>telepon</td>
              <td>:</td>
              <td>${sessionScope['sewa'].telepon}</td>
            </tr>
            <tr>
              <td>Tanggal Sewa</td>
              <td>:</td>
              <td>-</td>
            </tr>
            <tr>
              <td>Lama Sewa</td>
              <td>:</td>
              <td>${sessionScope['sewa'].lama_sewa} hari</td>
            </tr>
            <tr>
              <td>Total Harga</td>
              <td>:</td>
              <td>Rp. ${sessionScope['sewa'].total_bayar}</td>
            </tr>
            <tr>
              <td>Status</td>
              <td>:</td>
              <td>${sessionScope['sewa'].status}</td>
            </tr>
          </table>

          <a
            href="/Garda-rent/bayarsewa"
            class="btn btn-primary float-right"
            >Konfirmasi Pembayaran</a
          >
          <?php }?>
        </div>
      </div>
    </div>
  </div>
</div>
<br />
<br />
<br />

<%@include file="/footer.jsp" %>
