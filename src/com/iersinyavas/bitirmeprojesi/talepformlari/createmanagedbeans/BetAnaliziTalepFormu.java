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
		istenenAnaliz.add("Tek noktalý BET analizi + Gözenek boyutu");
		istenenAnaliz.add("Çok noktalý BET analizi");
		istenenAnaliz.add("Çok noktalý BET analizi + Mikro gözenek boyutu");
		istenenAnaliz.add("Tek noktalý BET analizi");
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
