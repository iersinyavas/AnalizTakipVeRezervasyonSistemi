package com.iersinyavas.bitirmeprojesi.component.mangedbeans;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedProperty;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iersinyavas.bitirmeprojesi.helper.Database;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String numuneAdi;

	public String getNumuneAdi() {
		return numuneAdi;
	}

	public void setNumuneAdi(String numuneAdi) {
		this.numuneAdi = numuneAdi;
	}
}