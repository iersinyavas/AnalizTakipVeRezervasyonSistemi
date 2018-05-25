package com.iersinyavas.bitirmeprojesi.entity;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
//@SequenceGenerator
@Table
public class Rezervasyon implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int rezervasyonId;
	
	@Column
	private String rezervasyonuAlaninAdi;
	
	@Column
	private Date rezervasyonAlinanTarih;
	
	@Column
	private String analizAdi;
	
	@Column
	private Date baslamaZamani;
	
	@Column
	private Date bitisZamani;
	
	@Column
	private String rezervasyonEtiket;
	
	@Column
	private String numuneAdi;
	
	@Column
	private String rezervasyonDurum;
	
	@Column
	private String sozlesmeDosyasiYolu;
	
	@Column
	private String dosyaAdi;
	
	@ManyToOne
	private Uye uye;
	
	@ManyToOne
	private Analiz analiz;

	public Rezervasyon() {
		
	}

	public Rezervasyon(String rezervasyonuAlaninAdi, Date rezervasyonAlinanTarih, String analizAdi, Date baslamaZamani,
			Date bitisZamani, String rezervasyonEtiket, String numuneAdi, String rezervasyonDurum, Uye uye,
			Analiz analiz, String sozlesmeDosyasiYolu, String dosyaAdi) {
		this.rezervasyonuAlaninAdi = rezervasyonuAlaninAdi;
		this.rezervasyonAlinanTarih = rezervasyonAlinanTarih;
		this.analizAdi = analizAdi;
		this.baslamaZamani = baslamaZamani;
		this.bitisZamani = bitisZamani;
		this.rezervasyonEtiket = rezervasyonEtiket;
		this.numuneAdi = numuneAdi;
		this.rezervasyonDurum = rezervasyonDurum;
		this.uye = uye;
		this.analiz = analiz;
		this.sozlesmeDosyasiYolu = sozlesmeDosyasiYolu;
		this.dosyaAdi = dosyaAdi;
	}

	
	public String getSozlesmeDosyasiYolu() {
		return sozlesmeDosyasiYolu;
	}

	public void setSozlesmeDosyasiYolu(String sozlesmeDosyasiYolu) {
		this.sozlesmeDosyasiYolu = sozlesmeDosyasiYolu;
	}

	public String getNumuneAdi() {
		return numuneAdi;
	}

	public void setNumuneAdi(String numuneAdi) {
		this.numuneAdi = numuneAdi;
	}

	public Analiz getAnaliz() {
		return analiz;
	}

	public void setAnaliz(Analiz analiz) {
		this.analiz = analiz;
	}

	public Uye getUye() {
		return uye;
	}

	public void setUye(Uye uye) {
		this.uye = uye;
	}

	public String getRezervasyonDurum() {
		return rezervasyonDurum;
	}

	public void setRezervasyonDurum(String rezervasyonDurum) {
		this.rezervasyonDurum = rezervasyonDurum;
	}

	public String getRezervasyonEtiket() {
		return rezervasyonEtiket;
	}

	public void setRezervasyonEtiket(String rezervasyonEtiket) {
		this.rezervasyonEtiket = rezervasyonEtiket;
	}

	public String getRezervasyonuAlaninAdi() {
		return rezervasyonuAlaninAdi;
	}

	public void setRezervasyonuAlaninAdi(String rezervasyonuAlaninAdi) {
		this.rezervasyonuAlaninAdi = rezervasyonuAlaninAdi;
	}

	public Date getRezervasyonAlinanTarih() {
		return rezervasyonAlinanTarih;
	}

	public void setRezervasyonAlinanTarih(Date rezervasyonAlinanTarih) {
		this.rezervasyonAlinanTarih = rezervasyonAlinanTarih;
	}

	public int getRezervasyonId() {
		return rezervasyonId;
	}

	public void setRezervasyonId(int rezervasyonId) {
		this.rezervasyonId = rezervasyonId;
	}

	public Date getBaslamaZamani() {
		return baslamaZamani;
	}

	public void setBaslamaZamani(Date baslamaZamani) {
		this.baslamaZamani = baslamaZamani;
	}

	public Date getBitisZamani() {
		return bitisZamani;
	}

	public void setBitisZamani(Date bitisZamani) {
		this.bitisZamani = bitisZamani;
	}

	public String getAnalizAdi() {
		return analizAdi;
	}

	public void setAnalizAdi(String analizAdi) {
		this.analizAdi = analizAdi;
	}
}
