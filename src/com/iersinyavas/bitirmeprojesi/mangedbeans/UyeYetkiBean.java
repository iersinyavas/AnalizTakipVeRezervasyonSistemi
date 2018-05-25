package com.iersinyavas.bitirmeprojesi.mangedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.event.RowEditEvent;
import com.iersinyavas.bitirmeprojesi.entity.Rezervasyon;
import com.iersinyavas.bitirmeprojesi.entity.Uye;
import com.iersinyavas.bitirmeprojesi.helper.Database;
import com.iersinyavas.bitirmeprojesi.helper.Util;
import com.iersinyavas.bitirmeprojesi.pojolar.RezervasyonPojo;
import com.iersinyavas.bitirmeprojesi.pojolar.UyePojo;

@ManagedBean
@ViewScoped
public class UyeYetkiBean implements Serializable {
	List<UyePojo> uyeBilgileri;
	private List<String> yetkiler;
	private List<String> uyeCeza;
	
	public List<String> getYetkiler() {
		return yetkiler;
	}

	public void setYetki(List<String> yetkiler) {
		this.yetkiler = yetkiler;
	}
	
	public List<String> getUyeCeza() {
		return uyeCeza;
	}

	public void setUyeCeza(List<String> uyeCeza) {
		this.uyeCeza = uyeCeza;
	}

	public List<UyePojo> getUyeBilgileri() {
		return uyeBilgileri;
	}

	public void setUyeBilgileri(List<UyePojo> uyeBilgileri) {
		this.uyeBilgileri = uyeBilgileri;
	}
	
	@PostConstruct
	public void uyeBilgileriYetki() {
		yetkiler = new ArrayList<String>();
		yetkiler.add("Yetkili");
		yetkiler.add("Deðil");
		
		uyeCeza = new ArrayList<>();
		uyeCeza.add("Cezalý");
		uyeCeza.add("Cezalý Deðil");
		
		uyeBilgileri = new ArrayList<>();
		Session session = Database.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(
					"select u.uyeId, u.uyeAdi, u.uyeSoyadi, u.uyeEmail, u.uyeKullaniciAdi, u.uyeKullaniciParola, u.uyeTelefon, u.uyeYetki, u.uyeCeza from Uye u");
			List<Object[]> uyeBilgilerim = query.list();

			for (Object[] list : uyeBilgilerim) {
				uyeBilgileri.add(new UyePojo((int) list[0], (String) list[1], (String) list[2], (String) list[3],
						(String) list[4], (String) list[5], (String) list[6], (String) list[7], (String) list[8]));
			}
			transaction.commit();
		} catch (Exception e) {

		} finally {
			session.close();
		}
	}

	public void onRowEdit(RowEditEvent event) {

		Session session = Database.getSessionFactory().openSession();
		try {
			for (int i = 0; i < uyeBilgileri.size(); i++) {
				Transaction transaction = session.beginTransaction();
				int id = uyeBilgileri.get(i).getUyeId();
				Uye uye = (Uye) session.get(Uye.class, id);
				uye.setUyeYetki(uyeBilgileri.get(i).getUyeYetki());
				uye.setUyeCeza(uyeBilgileri.get(i).getUyeCeza());
				transaction.commit();
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
	}

	public void onRowCancel(RowEditEvent event) {

	}

}