package com.iersinyavas.bitirmeprojesi.pojolar;

public class AnalizPojo {

	private int analizId;
	private String analizAdi;
	private int analizSuresiSaat;
	private int analizSuresiDakika;
	private double analizFiyati;
	private String aktif;

	public AnalizPojo(int analizId, String analizAdi, int analizSuresiSaat, int analizSuresiDakika, double analizFiyati,
			String aktif) {
		this.analizId = analizId;
		this.analizAdi = analizAdi;
		this.analizSuresiSaat = analizSuresiSaat;
		this.analizSuresiDakika = analizSuresiDakika;
		this.analizFiyati = analizFiyati;
		this.aktif = aktif;
	}

	public AnalizPojo(int analizId, String analizAdi, double analizFiyati) {
		this.analizId = analizId;
		this.analizAdi = analizAdi;
		this.analizFiyati = analizFiyati;
	}

	public String getAktif() {
		return aktif;
	}

	public void setAktif(String aktif) {
		this.aktif = aktif;
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

	public double getAnalizFiyati() {
		return analizFiyati;
	}

	public void setAnalizFiyati(double analizFiyati) {
		this.analizFiyati = analizFiyati;
	}

}
