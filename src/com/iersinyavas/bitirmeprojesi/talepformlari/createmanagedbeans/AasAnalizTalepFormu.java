package com.iersinyavas.bitirmeprojesi.talepformlari.createmanagedbeans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class AasAnalizTalepFormu {
	private List<String> elementler;
	private String[] secilenElementler;

	private List<String> numuneTipi;
	private String[] secilenNumuneTipi;

	private List<String> ornekNumune;
	private String[] secilenOrnekNumune;

	@PostConstruct
	public void init() {
		elementler = new ArrayList<String>();
		elementler.add("Hg");
		elementler.add("Ca-Mg");
		elementler.add("Ni");
		elementler.add("Fe");
		elementler.add("Zn");
		elementler.add("Ag");
		elementler.add("Cd");
		elementler.add("Al");
		elementler.add("As");
		elementler.add("Ca");
		elementler.add("Ba");
		elementler.add("Au");
		elementler.add("Pb");
		elementler.add("Cr");
		elementler.add("Se");
		elementler.add("B");
		elementler.add("Mn");
		elementler.add("Sn");
		elementler.add("Co");

		numuneTipi = new ArrayList<String>();
		numuneTipi.add("Su");
		numuneTipi.add("Toprak");
		numuneTipi.add("G�da");
		numuneTipi.add("Di�er");

		ornekNumune = new ArrayList<String>();
		ornekNumune.add("��zelti");
		ornekNumune.add("Kat�");
		ornekNumune.add("��z�c� ile birlikte");
		ornekNumune.add("��z�c�s�z");
	}

	// Elementlerin set ve getleri
	public List<String> getElementler() {
		return elementler;
	}

	public void setElementler(List<String> elementler) {
		this.elementler = elementler;
	}

	public String[] getSecilenElementler() {
		return secilenElementler;
	}

	public void setSecilenElementler(String[] secilenElementler) {
		this.secilenElementler = secilenElementler;
	}

	// Numune tipi set ve getleri
	public List<String> getNumuneTipi() {
		return numuneTipi;
	}

	public void setNumuneTipi(List<String> numuneTipi) {
		this.numuneTipi = numuneTipi;
	}

	public String[] getSecilenNumuneTipi() {
		return secilenNumuneTipi;
	}

	public void setSecilenNumuneTipi(String[] secilenNumuneTipi) {
		this.secilenNumuneTipi = secilenNumuneTipi;
	}

	// �rnek numune set ve getleri
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
