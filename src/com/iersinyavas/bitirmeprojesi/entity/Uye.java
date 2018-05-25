package com.iersinyavas.bitirmeprojesi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Uye implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int uyeId;

	@Column
	private String uyeAdi;

	@Column
	private String uyeSoyadi;

	@Column
	private String uyeEmail;

	@Column
	private String uyeKullaniciAdi;

	@Column
	private String uyeKullaniciParola;
	
	@Column
	private String uyeTelefon;
	
	@Column
	private String uyeYetki;
	
	@Column
	private String uyeCeza;
	
	@OneToMany(mappedBy="uye",cascade = CascadeType.ALL)
	private List<Rezervasyon> rezervasyonlar = new ArrayList<Rezervasyon>();

	public Uye() {
	}
	
	public Uye(String uyeAdi, String uyeSoyadi, String uyeEmail, String uyeKullaniciAdi, String uyeKullaniciParola,
			String uyeTelefon, String uyeYetki) {
		this.uyeAdi = uyeAdi;
		this.uyeSoyadi = uyeSoyadi;
		this.uyeEmail = uyeEmail;
		this.uyeKullaniciAdi = uyeKullaniciAdi;
		this.uyeKullaniciParola = uyeKullaniciParola;
		this.uyeTelefon = uyeTelefon;
		this.uyeYetki = uyeYetki;
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

	public List<Rezervasyon> getRezervasyonlar() {
		return rezervasyonlar;
	}

	public void setRezervasyonlar(List<Rezervasyon> rezervasyonlar) {
		this.rezervasyonlar = rezervasyonlar;
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
