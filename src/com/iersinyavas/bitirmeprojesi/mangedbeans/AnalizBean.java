package com.iersinyavas.bitirmeprojesi.mangedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.event.RowEditEvent;
import com.iersinyavas.bitirmeprojesi.component.mangedbeans.RezervasyonTakvim;
import com.iersinyavas.bitirmeprojesi.entity.Analiz;
import com.iersinyavas.bitirmeprojesi.entity.Rezervasyon;
import com.iersinyavas.bitirmeprojesi.helper.Database;
import com.iersinyavas.bitirmeprojesi.helper.Zaman;
import com.iersinyavas.bitirmeprojesi.pojolar.AnalizPojo;

@ManagedBean
@SessionScoped
public class AnalizBean implements Serializable {

	private List<AnalizPojo> analizler;
	private List<Integer> dakikalar;
	private List<String> aktiflik;

	@PostConstruct
	public void analizListesi() {
		dakikalar = new ArrayList<Integer>();
		dakikalar.add(0);
		dakikalar.add(30);
		aktiflik = new ArrayList<String>();
		aktiflik.add("Aktif");
		aktiflik.add("Pasif");
		
		analizler = new ArrayList<>();
		Session session = Database.getSessionFactory().openSession();

		try {
			Transaction transaction = session.beginTransaction();

			List<Object[]> analizbilgileri = (List<Object[]>) session.createQuery(
					"select analizId, analizAdi, analizSuresiSaat, analizSuresiDakika, analizFiyati, aktiflik from Analiz")
					.list();
			for (Object[] analiz : analizbilgileri) {
				analizler.add(new AnalizPojo((int) analiz[0], (String) analiz[1], (int) analiz[2], (int) analiz[3],
						(double) analiz[4], (String) analiz[5]));
			}

			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
	}
	


/*	public List<AnalizPojo> getAnalizFiyatlari() {
		return analizFiyatlari;
	}

	public void setAnalizFiyatlari(List<AnalizPojo> analizFiyatlari) {
		this.analizFiyatlari = analizFiyatlari;
	}*/

	public List<String> getAktiflik() {
		return aktiflik;
	}

	public void setAktiflik(List<String> aktiflik) {
		this.aktiflik = aktiflik;
	}

	public List<Integer> getDakikalar() {
		return dakikalar;
	}

	public void setDakikalar(List<Integer> dakikalar) {
		this.dakikalar = dakikalar;
	}

	public List<AnalizPojo> getAnalizler() {
		return analizler;
	}

	public void setAnalizler(List<AnalizPojo> analizler) {
		this.analizler = analizler;
	}

	public void onRowEdit(RowEditEvent event) {

		Date date = new Date();
		Database database = new Database();
		Zaman zaman = new Zaman();
		List<Object[]> gr = database.rezervasyonlariGetir(date);
		Transaction transaction = null;
		Session session = Database.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			for (int i = 0; i < analizler.size(); i++) {
				Analiz analiz = (Analiz) session.get(Analiz.class, i + 1);
				analiz.setAnalizSuresiSaat(analizler.get(i).getAnalizSuresiSaat());
				analiz.setAnalizSuresiDakika(analizler.get(i).getAnalizSuresiDakika());
				analiz.setAnalizFiyati(analizler.get(i).getAnalizFiyati());
				analiz.setAktiflik(analizler.get(i).getAktif());
			}
			for (int i = 0; i < gr.size(); i++) {

				Rezervasyon rezervasyon = (Rezervasyon) session.get(Rezervasyon.class, (int) gr.get(i)[0]);
				rezervasyon.setBitisZamani(
						zaman.zamanOlustur((Date) gr.get(i)[2], (int) gr.get(i)[4], (int) gr.get(i)[5], 0, new Date()));
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
	}

	public void onRowCancel(RowEditEvent event) {

	}

}