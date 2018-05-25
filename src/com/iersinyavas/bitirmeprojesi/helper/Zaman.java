package com.iersinyavas.bitirmeprojesi.helper;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Zaman {

	private int dakika;
	private int saat;
	Date date;
	
	
	public Zaman() {

	}
	public Date zamanOlustur(Date startdate, int saat, int dakika, int saniye, Date returndate) {
		returndate.setYear(startdate.getYear());
		returndate.setMonth(startdate.getMonth());
		returndate.setDate(startdate.getDate());
		returndate.setHours(startdate.getHours() + saat);
		returndate.setMinutes(startdate.getMinutes() + dakika);
		returndate.setSeconds(saniye);
		
		return returndate;
	}
	public int getDakika() {
		return dakika;
	}
	public void setDakika(int dakika) {
		this.dakika = dakika;
	}
	public int getSaat() {
		return saat;
	}
	public void setSaat(int saat) {
		this.saat = saat;
	}
	
	
}
