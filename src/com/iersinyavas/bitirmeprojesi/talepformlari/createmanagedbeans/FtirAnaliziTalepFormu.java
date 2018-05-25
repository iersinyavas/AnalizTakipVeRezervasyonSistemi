package com.iersinyavas.bitirmeprojesi.talepformlari.createmanagedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class FtirAnaliziTalepFormu {

	private List<String> ornekNumune;
	private String[] secilenOrnekNumune;
	
	private List<String> istenenAnaliz;
	private String[] seciliIstenenAnalizler;
	
	private List<String> spektrumCiktilari;
	private String[] seciliSpektrumCiktilari;
	
	@PostConstruct
	public void init() {
		ornekNumune = new ArrayList<String>();
		ornekNumune.add("Saf");
		ornekNumune.add("Karýþým");
		ornekNumune.add("Katý");
		ornekNumune.add("Sývý");
		
		istenenAnaliz = new ArrayList<String>();
		istenenAnaliz.add("KBr Disk");
		istenenAnaliz.add("NaCl Cell");
		istenenAnaliz.add("NaCl Disk");
		istenenAnaliz.add("ATR");
		
		spektrumCiktilari = new ArrayList<String>();
		spektrumCiktilari.add("Üst üste karþýlaþtýrmalý");
		spektrumCiktilari.add("Spektrum + Dalga boyu");
		spektrumCiktilari.add("Dalga Boyu Listesi ");
		spektrumCiktilari.add("Altalta karþýlaþtýrmalý");
		spektrumCiktilari.add("Düz Spektrum (Dalga boyu yazýlmayan)");
	}
	
	public List<String> getSpektrumCiktilari() {
		return spektrumCiktilari;
	}

	public void setSpektrumCiktilari(List<String> spektrumCiktilari) {
		this.spektrumCiktilari = spektrumCiktilari;
	}

	public String[] getSeciliSpektrumCiktilari() {
		return seciliSpektrumCiktilari;
	}

	public void setSeciliSpektrumCiktilari(String[] seciliSpektrumCiktilari) {
		this.seciliSpektrumCiktilari = seciliSpektrumCiktilari;
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

	public List<String> getOrnekNumune() {
		return ornekNumune;
	}

	public void setOrnekNumune(List<String> ornekNumune) {
		this.ornekNumune = ornekNumune;
	}

	public String[] getSecilenOrnekNumune() {
		return secilenOrnekNumune;
	}

	public void setSecilenOrnekNumune(String[] secilenOrnekNumune) {
		this.secilenOrnekNumune = secilenOrnekNumune;
	}
	
}
