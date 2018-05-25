package com.iersinyavas.bitirmeprojesi.pojolar;

public class UyePojo{

	private int uyeId;
	private String uyeAdi;
	private String uyeSoyadi;
	private String uyeEmail;
	private String uyeKullaniciAdi;
	private String uyeKullaniciParola;
	private String uyeTelefon;
	private String uyeYetki;
	private String uyeCeza;
	
	public UyePojo() {
	}
	public UyePojo(int uyeId, String uyeAdi, String uyeSoyadi, String uyeEmail, String uyeKullaniciAdi, String uyeKullaniciParola,
			String uyeTelefon) {
		this.uyeId = uyeId;
		this.uyeAdi = uyeAdi;
		this.uyeSoyadi = uyeSoyadi;
		this.uyeEmail = uyeEmail;
		this.uyeKullaniciAdi = uyeKullaniciAdi;
		this.uyeKullaniciParola = uyeKullaniciParola;
		this.uyeTelefon = uyeTelefon;

	}

	public UyePojo(int uyeId, String uyeAdi, String uyeSoyadi, String uyeEmail, String uyeKullaniciAdi, String uyeKullaniciParola,
			String uyeTelefon,String uyeYetki) {
		this.uyeId = uyeId;
		this.uyeAdi = uyeAdi;
		this.uyeSoyadi = uyeSoyadi;
		this.uyeEmail = uyeEmail;
		this.uyeKullaniciAdi = uyeKullaniciAdi;
		this.uyeKullaniciParola = uyeKullaniciParola;
		this.uyeTelefon = uyeTelefon;
		this.uyeYetki = uyeYetki;
	}
	
	public UyePojo(int uyeId, String uyeAdi, String uyeSoyadi, String uyeEmail, String uyeKullaniciAdi, String uyeKullaniciParola,
			String uyeTelefon,String uyeYetki, String uyeCeza) {
		this.uyeId = uyeId;
		this.uyeAdi = uyeAdi;
		this.uyeSoyadi = uyeSoyadi;
		this.uyeEmail = uyeEmail;
		this.uyeKullaniciAdi = uyeKullaniciAdi;
		this.uyeKullaniciParola = uyeKullaniciParola;
		this.uyeTelefon = uyeTelefon;
		this.uyeYetki = uyeYetki;
		this.uyeCeza = uyeCeza;
	}
	
	public String getUyeCeza() {
		return uyeCeza;
	}
	
	public void setUyeCeza(String uyeCeza) {
		this.uyeCeza = uyeCeza;
	}
	
	public String getUyeYetki() {
		return uyeYetki;
	}

	public void setUyeYetki(String uyeYetki) {
		this.uyeYetki = uyeYetki;
	}

	public String getUyeSoyadi() {
		return uyeSoyadi;
	}

	public void setUyeSoyadi(String uyeSoyadi) {
		this.uyeSoyadi = uyeSoyadi;
	}

	public String getUyeKullaniciAdi() {
		return uyeKullaniciAdi;
	}

	public void setUyeKullaniciAdi(String uyeKullaniciAdi) {
		this.uyeKullaniciAdi = uyeKullaniciAdi;
	}

	public String getUyeKullaniciParola() {
		return uyeKullaniciParola;
	}

	public void setUyeKullaniciParola(String uyeKullaniciParola) {
		this.uyeKullaniciParola = uyeKullaniciParola;
	}

	public int getUyeId() {
		return uyeId;
	}

	public void setUyeId(int uyeId) {
		this.uyeId = uyeId;
	}

	public String getUyeAdi() {
		return uyeAdi;
	}

	public void setUyeAdi(String uyeAdi) {
		this.uyeAdi = uyeAdi;
	}

	public String getUyeEmail() {
		return uyeEmail;
	}

	public void setUyeEmail(String uyeEmail) {
		this.uyeEmail = uyeEmail;
	}

	public String getUyeTelefon() {
		return uyeTelefon;
	}

	public void setUyeTelefon(String uyeTelefon) {
		this.uyeTelefon = uyeTelefon;
	}
}
