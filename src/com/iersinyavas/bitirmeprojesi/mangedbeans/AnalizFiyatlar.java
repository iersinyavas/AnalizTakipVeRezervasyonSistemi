package com.iersinyavas.bitirmeprojesi.mangedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iersinyavas.bitirmeprojesi.helper.Database;
import com.iersinyavas.bitirmeprojesi.pojolar.AnalizPojo;

@ManagedBean
@SessionScoped
public class AnalizFiyatlar {
	
	private List<AnalizPojo> analizFiyatlari;
	
	@PostConstruct
	public void analizFiyatListesi() {
		analizFiyatlari = new ArrayList<>();
		Session session = Database.getSessionFactory().openSession();

		try {
			Transaction transaction = session.beginTransaction();

			List<Object[]> analizbilgileri = (List<Object[]>) session
					.createQuery("select analizId, analizAdi, analizFiyati from Analiz").list();
			for (Object[] analiz : analizbilgileri) {
				analizFiyatlari.add(new AnalizPojo((int) analiz[0], (String) analiz[1], (double) analiz[2]));
			}

			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
	}

	public List<AnalizPojo> getAnalizFiyatlari() {
		return analizFiyatlari;
	}

	public void setAnalizFiyatlari(List<AnalizPojo> analizFiyatlari) {
		this.analizFiyatlari = analizFiyatlari;
	}
}
