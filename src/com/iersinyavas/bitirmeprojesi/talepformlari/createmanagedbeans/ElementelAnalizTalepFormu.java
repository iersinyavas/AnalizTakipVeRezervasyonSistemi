package com.iersinyavas.bitirmeprojesi.talepformlari.createmanagedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ElementelAnalizTalepFormu {

	private List<String> analizBilgileri;
	private String[] seciliAnalizBilgileri;
	
	private List<String> istenenAnaliz;
	private String[] seciliIstenenAnalizler;
	
	@PostConstruct
	public void init() {
		analizBilgileri = new ArrayList<String>();
		analizBilgileri.add("Sývý");
		analizBilgileri.add("Katý");
		
		istenenAnaliz = new ArrayList<String>();
		istenenAnaliz.add("C");
		istenenAnaliz.add("N");
		istenenAnaliz.add("H");
		istenenAnaliz.add("S");
	}

	public List<String> getAnalizBilgileri() {
		return analizBilgileri;
	}

	public void setAnalizBilgileri(List<String> analizBilgileri) {
		this.analizBilgileri = analizBilgileri;
	}

	public String[] getSeciliAnalizBilgileri() {
		return seciliAnalizBilgileri;
	}

	public void setSeciliAnalizBilgileri(String[] seciliAnalizBilgileri) {
		this.seciliAnalizBilgileri = seciliAnalizBilgileri;
	}

	public List<String> getIstenenAnaliz() {
		return istenenAnaliz;
	}

	public void setIstenenAnaliz(List<String> istenenAnaliz) {
		this.istenenAnaliz = istenenAnaliz;
	}

	public String[] getSeciliIstenenAnalizler() {
		return seciliIstenenAnalizler;
	}

	public void setSeciliIstenenAnalizler(String[] seciliIstenenAnalizler) {
		this.seciliIstenenAnalizler = seciliIstenenAnalizler;
	}
	
	
	
}
