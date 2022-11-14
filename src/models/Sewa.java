package models;

public class Sewa {
	
	private String id;
	private int harga;
	private int total_bayar;
	private String mobil_id;
	private String customer_id;
	private String status_penyewaan;
	private String tanggal_transaksi;
	private int lama_sewa;
	
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
	public String getStatus_penyewaan() {
		return status_penyewaan;
	}
	public void setStatus_penyewaan(String status_penyewaan) {
		this.status_penyewaan = status_penyewaan;
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
	
	
}
