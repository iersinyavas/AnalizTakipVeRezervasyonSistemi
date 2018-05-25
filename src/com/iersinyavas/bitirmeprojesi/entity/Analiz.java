package com.iersinyavas.bitirmeprojesi.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Analiz{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int analizId;
	
	@Column
	private String analizAdi;
	
	@Column
	private int analizSuresiSaat;
	
	@Column
	private int analizSuresiDakika;

	@Column
	private double analizFiyati;
	
	@Column
	private String aktiflik;	
	
	@OneToMany(mappedBy="analiz", cascade=CascadeType.ALL)
	private List<Rezervasyon> rezervasyonlar = new ArrayList<Rezervasyon>();

	public Analiz() {
	
	}

	public Analiz(String analizAdi, int analizSuresiSaat, int analizSuresiDakika, double analizFiyati, String aktiflik) {
		super();
		this.analizAdi = analizAdi;
		this.analizSuresiSaat = analizSuresiSaat;
		this.analizSuresiDakika = analizSuresiDakika;
		this.analizFiyati = analizFiyati;
		this.aktiflik = aktiflik;
	}



	public String getAktiflik() {
		return aktiflik;
	}

	public void setAktiflik(String aktiflik) {
		this.aktiflik = aktiflik;
	}

	public List<Rezervasyon> getRezervasyonlar() {
		return rezervasyonlar;
	}

	public void setRezervasyonlar(List<Rezervasyon> rezervasyonlar) {
		this.rezervasyonlar = rezervasyonlar;
	}

	public double getAnalizFiyati() {
		return analizFiyati;
	}

	public void setAnalizFiyati(double analizFiyati) {
		this.analizFiyati = analizFiyati;
	}

	public int getAnalizId() {
		return analizId;
	}

	public void setAnalizId(int analizId) {
		this.analizId = analizId;
	}

	public String getAnalizAdi() {
		return analizAdi;
	}

	public void setAnalizAdi(String analizAdi) {
		this.analizAdi = analizAdi;
	}

	public int getAnalizSuresiSaat() {
		return analizSuresiSaat;
	}

	public void setAnalizSuresiSaat(int analizSuresiSaat) {
		this.analizSuresiSaat = analizSuresiSaat;
	}

	public int getAnalizSuresiDakika() {
		return analizSuresiDakika;
	}

	public void setAnalizSuresiDakika(int analizSuresiDakika) {
		this.analizSuresiDakika = analizSuresiDakika;
	}
}
