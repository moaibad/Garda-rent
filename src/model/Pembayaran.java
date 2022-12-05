package model;

public class Pembayaran {
	private String id;
	private String rekening;
	private int nominal;
	private String tgl_transfer;
	private java.sql.Date tanggal_transfer;
	private String sewa_id;
	private String nama_rekening;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRekening() {
		return rekening;
	}
	public void setRekening(String rekening) {
		this.rekening = rekening;
	}
	public int getNominal() {
		return nominal;
	}
	public void setNominal(int nominal) {
		this.nominal = nominal;
	}
	public String getTgl_transfer() {
		return tgl_transfer;
	}
	public void setTgl_transfer(String tgl_transfer) {
		this.tgl_transfer = tgl_transfer;
	}
	public java.sql.Date getTanggal_transfer() {
		return tanggal_transfer;
	}
	public void setTanggal_transfer(java.sql.Date tanggal_transfer) {
		this.tanggal_transfer = tanggal_transfer;
	}
	public String getSewa_id() {
		return sewa_id;
	}
	public void setSewa_id(String sewa_id) {
		this.sewa_id = sewa_id;
	}
	public String getNama_rekening() {
		return nama_rekening;
	}
	public void setNama_rekening(String nama_rekening) {
		this.nama_rekening = nama_rekening;
	}
	
	
	
	
}
