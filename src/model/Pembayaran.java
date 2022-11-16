package model;

public class Pembayaran {
	private String id;
	private String rekening;
	private int nominal;
	private String tanggal;
	private String sewa_id;
	
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
	public String getTanggal() {
		return tanggal;
	}
	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}
	public String getSewa_id() {
		return sewa_id;
	}
	public void setSewa_id(String sewa_id) {
		this.sewa_id = sewa_id;
	}
	
	
}
