package model;

public class Sewa {

  private String id;
  private int harga;
  private int total_bayar;
  private String mobil_id;
  private String customer_id;
  private String supir_id;
  private String tanggal_transaksi;
  private int lama_sewa;
  private String ktp;
  private String sim;
  private String nama;
  private String alamat;
  private String telepon;
  private String status;
  private String nama_mobil;
  private String tgl_sewa;
  private java.sql.Date tanggal_sewa;
  private String estimasi_selesai;
  

  
public String getSim() {
	return sim;
}

public void setSim(String sim) {
	this.sim = sim;
}

public String getEstimasi_selesai() {
	return estimasi_selesai;
}

public void setEstimasi_selesai(String estimasi_selesai) {
	this.estimasi_selesai = estimasi_selesai;
}

public String getSupir_id() {
	return supir_id;
}

public void setSupir_id(String supir_id) {
	this.supir_id = supir_id;
}

public String getTgl_sewa() {
	return tgl_sewa;
}

public void setTgl_sewa(String tgl_sewa) {
	this.tgl_sewa = tgl_sewa;
}

public java.sql.Date getTanggal_sewa() {
	return tanggal_sewa;
}

public void setTanggal_sewa(java.sql.Date tanggal_sewa) {
	this.tanggal_sewa = tanggal_sewa;
}

public String getNama_mobil() {
	return nama_mobil;
}

public void setNama_mobil(String nama_mobil) {
	this.nama_mobil = nama_mobil;
}

public String getStatus() {
	return status;
  }

public void setStatus(String status) {
	this.status = status;
	}

public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getHarga() {
    return harga;
  }

  public void setHarga(int harga) {
    this.harga = harga;
  }

  public int getTotal_bayar() {
    return total_bayar;
  }

  public void setTotal_bayar(int total_bayar) {
    this.total_bayar = total_bayar;
  }

  public String getMobil_id() {
    return mobil_id;
  }

  public void setMobil_id(String mobil_id) {
    this.mobil_id = mobil_id;
  }

  public String getCustomer_id() {
    return customer_id;
  }

  public void setCustomer_id(String customer_id) {
    this.customer_id = customer_id;
  }

  public String getTanggal_transaksi() {
    return tanggal_transaksi;
  }

  public void setTanggal_transaksi(String tanggal_transaksi) {
    this.tanggal_transaksi = tanggal_transaksi;
  }

  public int getLama_sewa() {
    return lama_sewa;
  }

  public void setLama_sewa(int lama_sewa) {
    this.lama_sewa = lama_sewa;
  }

  public String getKtp() {
    return ktp;
  }

  public void setKtp(String ktp) {
    this.ktp = ktp;
  }

  public String getNama() {
    return nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public String getAlamat() {
    return alamat;
  }

  public void setAlamat(String alamat) {
    this.alamat = alamat;
  }

  public String getTelepon() {
    return telepon;
  }

  public void setTelepon(String telepon) {
    this.telepon = telepon;
  }
}
