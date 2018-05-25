package com.iersinyavas.bitirmeprojesi.helper;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;

public class Tarih extends Date{

	private String[] aylar = {"Ocak","�ubat","Mart","Nisan","May�s","Haziran","Temmuz","A�ustos","Eyl�l","Ekim","Ekim","Kas�m","Aral�k"};
	private String[] gunler = {"Pazar","Pazartesi","Sal�","�ar�amba","Per�embe","Cuma","Cumartesi"};
	
	private String ay;
	private String gun;
	private int saat;
	private String dakika; // 0 dakikan�n 00 g�r�nebilmesi i�in String tipinde
	
	public String ayAdi(int ayindex) {
		return aylar[ayindex];
	}
	
	public String gunAdi(int gunindex) {
		return gunler[gunindex];
	}
	
	public String getAy() {
		return ay;
	}

	public void setAy(String ay) {
		this.ay = ay;
	}

	public String getGun() {
		return gun;
	}

	public void setGun(String gun) {
		this.gun = gun;
	}

	public int getSaat() {
		return saat;
	}

	public void setSaat(int saat) {
		this.saat = saat;
	}

	public String getDakika() {
		return dakika;
	}

	public void setDakika(int dakika) {
		if(dakika==0) this.dakika = "00";
		else this.dakika = Integer.toString(dakika);
	}


	
}
