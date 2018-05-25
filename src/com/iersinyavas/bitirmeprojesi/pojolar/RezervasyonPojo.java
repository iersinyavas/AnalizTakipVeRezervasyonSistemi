package com.iersinyavas.bitirmeprojesi.pojolar;

import java.util.Date;

public class RezervasyonPojo {
	
	private int rezervasyonNo;
	private String yaptiraninAdiSoyadi;
	private String numuneAdi;
	private String analizAdi;
	private String analizinDurumu;
	private Date rezervasyonunBasBitZamani;
	private String uyeTelefon;
	private String dosyaYolu;
	private String dosyaYoluButon = "Sözleþmeyi Ýndir";
	private String dosyaAdi;
	private String analizSonucu = "Analiz Sonucu";
	
	public RezervasyonPojo(int rezervasyonNo, String yaptiraninAdiSoyadi, String numuneAdi, String analizAdi,
			String analizinDurumu, Date rezervasyonunBasBitZamani, String uyeTelefon, String dosyaYolu, String dosyaAdi) {
		this.rezervasyonNo = rezervasyonNo;
		this.yaptiraninAdiSoyadi = yaptiraninAdiSoyadi;
		this.numuneAdi = numuneAdi;
		this.analizAdi = analizAdi;
		this.analizinDurumu = analizinDurumu;
		this.rezervasyonunBasBitZamani = rezervasyonunBasBitZamani;
		this.uyeTelefon = uyeTelefon;
		this.dosyaYolu = dosyaYolu;
		this.dosyaAdi = dosyaAdi;
	}
	
	public RezervasyonPojo(int rezervasyonNo, String yaptiraninAdiSoyadi, String numuneAdi, String analizAdi,
			String analizinDurumu, Date rezervasyonunBasBitZamani) {
		this.rezervasyonNo = rezervasyonNo;
		this.yaptiraninAdiSoyadi = yaptiraninAdiSoyadi;
		this.numuneAdi = numuneAdi;
		this.analizAdi = analizAdi;
		this.analizinDurumu = analizinDurumu;
		this.rezervasyonunBasBitZamani = rezervasyonunBasBitZamani;
	}

	public String getAnalizSonucu() {
		return analizSonucu;
	}

	public void setAnalizSonucu(String analizSonucu) {
		this.analizSonucu = analizSonucu;
	}

	public String getDosyaAdi() {
		return dosyaAdi;
	}

	public void setDosyaAdi(String dosyaAdi) {
		this.dosyaAdi = dosyaAdi;
	}

	public String getDosyaYolu() {
		return dosyaYolu;
	}

	public void setDosyaYolu(String dosyaYolu) {
		this.dosyaYolu = dosyaYolu;
	}

	public String getDosyaYoluButon() {
		return dosyaYoluButon;
	}

	public void setDosyaYoluButon(String dosyaYoluButon) {
		this.dosyaYoluButon = dosyaYoluButon;
	}

	public Date getRezervasyonunBasBitZamani() {
		return rezervasyonunBasBitZamani;
	}

	public void setRezervasyonunBasBitZamani(Date rezervasyonunBasBitZamani) {
		this.rezervasyonunBasBitZamani = rezervasyonunBasBitZamani;
	}

	public String getUyeTelefon() {
		return uyeTelefon;
	}

	public void setUyeTelefon(String uyeTelefon) {
		this.uyeTelefon = uyeTelefon;
	}

	public int getRezervasyonNo() {
		return rezervasyonNo;
	}
	public void setRezervasyonNo(int rezervasyonNo) {
		this.rezervasyonNo = rezervasyonNo;
	}
	public String getYaptiraninAdiSoyadi() {
		return yaptiraninAdiSoyadi;
	}
	public void setYaptiraninAdiSoyadi(String yaptiraninAdiSoyadi) {
		this.yaptiraninAdiSoyadi = yaptiraninAdiSoyadi;
	}
	public String getNumuneAdi() {
		return numuneAdi;
	}
	public void setNumuneAdi(String numuneAdi) {
		this.numuneAdi = numuneAdi;
	}
	public String getAnalizAdi() {
		return analizAdi;
	}
	public void setAnalizAdi(String analizAdi) {
		this.analizAdi = analizAdi;
	}
	public String getAnalizinDurumu() {
		return analizinDurumu;
	}
	public void setAnalizinDurumu(String analizinDurumu) {
		this.analizinDurumu = analizinDurumu;
	}

}
