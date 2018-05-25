package com.iersinyavas.bitirmeprojesi.talepformlari.createmanagedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class BetAnaliziTalepFormu {

	private List<String> istenenAnaliz;
	private String[] seciliIstenenAnalizler;

	@PostConstruct
	public void init() {
		istenenAnaliz = new ArrayList<String>();
		istenenAnaliz.add("Tek noktal� BET analizi + G�zenek boyutu");
		istenenAnaliz.add("�ok noktal� BET analizi");
		istenenAnaliz.add("�ok noktal� BET analizi + Mikro g�zenek boyutu");
		istenenAnaliz.add("Tek noktal� BET analizi");
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
