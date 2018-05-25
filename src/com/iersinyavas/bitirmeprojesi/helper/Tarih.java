package com.iersinyavas.bitirmeprojesi.helper;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;

public class Tarih extends Date{

	private String[] aylar = {"Ocak","Þubat","Mart","Nisan","Mayýs","Haziran","Temmuz","Aðustos","Eylül","Ekim","Ekim","Kasým","Aralýk"};
	private String[] gunler = {"Pazar","Pazartesi","Salý","Çarþamba","Perþembe","Cuma","Cumartesi"};
	
	private String ay;
	private String gun;
	private int saat;
	private String dakika; // 0 dakikanýn 00 görünebilmesi için String tipinde
	
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
