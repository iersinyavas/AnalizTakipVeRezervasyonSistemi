package com.iersinyavas.bitirmeprojesi.talepformlari.createmanagedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class GazPiknometresiAnalizTalepFormu {
	
	private List<String> istenenAnaliz;
	private String[] seciliIstenenAnalizler;
	
	private List<String> analizBilgileriOrnekHacmi;
	private String[] seciliAnalizBilgileriOrnekHacmi;
	
	private List<String> ornekYapisiVeAtmosfer;
	private String[] seciliOrnekYapisiVeAtmosfer;
	
	@PostConstruct
	public void init() {
		
		istenenAnaliz = new ArrayList<String>();
		istenenAnaliz.add("Gerçek Hacim");
		istenenAnaliz.add("Gerçek Yoðunluk");
		istenenAnaliz.add("Diðer");
		
		analizBilgileriOrnekHacmi = new ArrayList<String>();
		analizBilgileriOrnekHacmi.add("10 cc");
		analizBilgileriOrnekHacmi.add("35 cc");
		analizBilgileriOrnekHacmi.add("10 cc");
		analizBilgileriOrnekHacmi.add("35 cc");
		
		ornekYapisiVeAtmosfer = new ArrayList<String>();
		ornekYapisiVeAtmosfer.add("Toz");
		ornekYapisiVeAtmosfer.add("Katý");
		ornekYapisiVeAtmosfer.add("Pelet");
		ornekYapisiVeAtmosfer.add("Helyum");
		ornekYapisiVeAtmosfer.add("Azot");
	}
	
	public List<String> getOrnekYapisiVeAtmosfer() {
		return ornekYapisiVeAtmosfer;
	}

	public void setOrnekYapisiVeAtmosfer(List<String> ornekYapisiVeAtmosfer) {
		this.ornekYapisiVeAtmosfer = ornekYapisiVeAtmosfer;
	}

	public String[] getSeciliOrnekYapisiVeAtmosfer() {
		return seciliOrnekYapisiVeAtmosfer;
	}

	public void setSeciliOrnekYapisiVeAtmosfer(String[] seciliOrnekYapisiVeAtmosfer) {
		this.seciliOrnekYapisiVeAtmosfer = seciliOrnekYapisiVeAtmosfer;
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

	public List<String> getAnalizBilgileriOrnekHacmi() {
		return analizBilgileriOrnekHacmi;
	}

	public void setAnalizBilgileriOrnekHacmi(List<String> analizBilgileriOrnekHacmi) {
		this.analizBilgileriOrnekHacmi = analizBilgileriOrnekHacmi;
	}

	public String[] getSeciliAnalizBilgileriOrnekHacmi() {
		return seciliAnalizBilgileriOrnekHacmi;
	}

	public void setSeciliAnalizBilgileriOrnekHacmi(String[] seciliAnalizBilgileriOrnekHacmi) {
		this.seciliAnalizBilgileriOrnekHacmi = seciliAnalizBilgileriOrnekHacmi;
	}

}