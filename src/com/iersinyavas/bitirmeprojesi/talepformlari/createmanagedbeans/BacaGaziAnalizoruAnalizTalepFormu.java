package com.iersinyavas.bitirmeprojesi.talepformlari.createmanagedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class BacaGaziAnalizoruAnalizTalepFormu {
	
	private List<String> istenenAnaliz;
	private String[] seciliIstenenAnalizler;
	
	@PostConstruct
	public void init() {
		
		istenenAnaliz = new ArrayList<String>();
		istenenAnaliz.add("CO");
		istenenAnaliz.add("NOx");
		istenenAnaliz.add("SOx");
		istenenAnaliz.add("O2");
	}

	//Ýstenen analiz set ve getleri
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
