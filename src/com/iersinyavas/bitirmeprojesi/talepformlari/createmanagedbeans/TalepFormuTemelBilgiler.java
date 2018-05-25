package com.iersinyavas.bitirmeprojesi.talepformlari.createmanagedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class TalepFormuTemelBilgiler {
	
	private List<String> kisiKurulusKategori;
	private String[] seciliKisiKurulusKategori;
	
	private List<String> guvenlikBilgileriVarYok;
	private String[] secilenguvenlikBilgisiVarYok;
	
	private List<String> guvenlikBilgileriMSDS;
	private String[] secilenguvenlikBilgisiMSDS;
	
	private List<String> numuneBilgileri;
	private String[] secilenNumuneBilgileri;
	
	private String telefon;
	
	@PostConstruct
	public void init() {
		kisiKurulusKategori = new ArrayList<String>();
		kisiKurulusKategori.add("Bilecik Þeyh Edebali Üni.");
		kisiKurulusKategori.add("Üniversite");
		kisiKurulusKategori.add("Kamu Kurumu");
		kisiKurulusKategori.add("Sanayi");
		kisiKurulusKategori.add("Üniversite kanalýyla gelen özel sektör");
		kisiKurulusKategori.add("Diðer");
		
		guvenlikBilgileriVarYok = new ArrayList<String>();
		guvenlikBilgileriVarYok.add("Vardýr");
		guvenlikBilgileriVarYok.add("Yoktur");
		
		guvenlikBilgileriMSDS = new ArrayList<String>();
		guvenlikBilgileriMSDS.add("Solunum");
		guvenlikBilgileriMSDS.add("Deri");
		guvenlikBilgileriMSDS.add("Göz");
		
		numuneBilgileri = new ArrayList<String>();
		numuneBilgileri.add("Numune geri isteniyor");
		numuneBilgileri.add("Yedek numune mevcut");
		numuneBilgileri.add("Yedek numune alýnmamýþ");
	}

	
	
	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public List<String> getNumuneBilgileri() {
		return numuneBilgileri;
	}

	public void setNumuneBilgileri(List<String> numuneBilgileri) {
		this.numuneBilgileri = numuneBilgileri;
	}

	public String[] getSecilenNumuneBilgileri() {
		return secilenNumuneBilgileri;
	}

	public void setSecilenNumuneBilgileri(String[] secilenNumuneBilgileri) {
		this.secilenNumuneBilgileri = secilenNumuneBilgileri;
	}

	public List<String> getGuvenlikBilgileriVarYok() {
		return guvenlikBilgileriVarYok;
	}

	public void setGuvenlikBilgileriVarYok(List<String> guvenlikBilgileriVarYok) {
		this.guvenlikBilgileriVarYok = guvenlikBilgileriVarYok;
	}

	public String[] getSecilenguvenlikBilgisiVarYok() {
		return secilenguvenlikBilgisiVarYok;
	}

	public void setSecilenguvenlikBilgisiVarYok(String[] secilenguvenlikBilgisiVarYok) {
		this.secilenguvenlikBilgisiVarYok = secilenguvenlikBilgisiVarYok;
	}

	public List<String> getGuvenlikBilgileriMSDS() {
		return guvenlikBilgileriMSDS;
	}

	public void setGuvenlikBilgileriMSDS(List<String> guvenlikBilgileriMSDS) {
		this.guvenlikBilgileriMSDS = guvenlikBilgileriMSDS;
	}

	public String[] getSecilenguvenlikBilgisiMSDS() {
		return secilenguvenlikBilgisiMSDS;
	}

	public void setSecilenguvenlikBilgisiMSDS(String[] secilenguvenlikBilgisiMSDS) {
		this.secilenguvenlikBilgisiMSDS = secilenguvenlikBilgisiMSDS;
	}

	public List<String> getKisiKurulusKategori() {
		return kisiKurulusKategori;
	}

	public void setKisiKurulusKategori(List<String> kisiKurulusKategori) {
		this.kisiKurulusKategori = kisiKurulusKategori;
	}

	public String[] getSeciliKisiKurulusKategori() {
		return seciliKisiKurulusKategori;
	}

	public void setSeciliKisiKurulusKategori(String[] seciliKisiKurulusKategori) {
		this.seciliKisiKurulusKategori = seciliKisiKurulusKategori;
	}

}
