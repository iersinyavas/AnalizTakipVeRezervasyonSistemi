package com.iersinyavas.bitirmeprojesi.mangedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iersinyavas.bitirmeprojesi.entity.Rezervasyon;
import com.iersinyavas.bitirmeprojesi.helper.Database;
import com.iersinyavas.bitirmeprojesi.helper.Util;
import com.iersinyavas.bitirmeprojesi.pojolar.RezervasyonPojo;

@ManagedBean
@SessionScoped
public class RezervasyonBean implements Serializable {

	List<RezervasyonPojo> rezervasyonlar;

	public List<RezervasyonPojo> rezervasyonListesi() {
		rezervasyonlar = new ArrayList<>();
		Date date = new Date();
		Session session = Database.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();
			int kullaniciId = Integer.parseInt(Util.getSession().getAttribute("kullaniciId").toString());

			Query query = session.createQuery(
					"select r.rezervasyonId, u.uyeAdi, u.uyeSoyadi, r.numuneAdi, r.analizAdi, r.rezervasyonDurum, r.baslamaZamani from Rezervasyon r inner join r.uye as u where u.uyeId = :kullaniciId and r.bitisZamani >= :date order by r.baslamaZamani");
			query.setParameter("kullaniciId", kullaniciId);
			query.setParameter("date", date);
			List<Object[]> rezervasyonlarim = query.list();

			for (Object[] list : rezervasyonlarim) {
				rezervasyonlar.add(new RezervasyonPojo((int) list[0], (String) list[1] + " " + (String) list[2],
						(String) list[3], (String) list[4], (String) list[5], (Date) list[6]));
			}
			transaction.commit();
		} catch (Exception e) {

		} finally {
			session.close();
			return rezervasyonlar;
		}
	}

	public List<RezervasyonPojo> zamaniGecenler() {
		Date date = new Date();
		rezervasyonlar = new ArrayList<>();
		Session session = Database.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();
			int kullaniciId = Integer.parseInt(Util.getSession().getAttribute("kullaniciId").toString());

			Query query = session.createQuery(
					"select r.rezervasyonId, u.uyeAdi, u.uyeSoyadi, r.numuneAdi, r.analizAdi, r.rezervasyonDurum, r.bitisZamani from Rezervasyon r inner join r.uye as u where u.uyeId = :kullaniciId and r.bitisZamani < :date order by r.bitisZamani desc");
			query.setParameter("kullaniciId", kullaniciId);
			query.setParameter("date", date);
			List<Object[]> rezervasyonlarim = query.list();

			for (Object[] list : rezervasyonlarim) {
				rezervasyonlar.add(new RezervasyonPojo((int) list[0], (String) list[1] + " " + (String) list[2],
						(String) list[3], (String) list[4], (String) list[5], (Date) list[6]));
			}

			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
			return rezervasyonlar;
		}
	}

	public List<RezervasyonPojo> zamaniGecenleriGuncelle() {
		Date date = new Date();
		rezervasyonlar = new ArrayList<>();
		Session session = Database.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();

			Query query = session.createQuery(
					"select r.rezervasyonId, u.uyeAdi, u.uyeSoyadi, r.numuneAdi, r.analizAdi, r.rezervasyonDurum, r.bitisZamani from Rezervasyon r inner join r.uye as u where r.bitisZamani < :date order by r.bitisZamani desc");

			query.setParameter("date", date);
			List<Object[]> rezervasyonlarim = query.list();

			for (Object[] list : rezervasyonlarim) {
				rezervasyonlar.add(new RezervasyonPojo((int) list[0], (String) list[1] + " " + (String) list[2],
						(String) list[3], (String) list[4], (String) list[5], (Date) list[6]));
			}

			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
			return rezervasyonlar;
		}
	}

	public List<RezervasyonPojo> baslayanAnalizler() {
		Date date = new Date();
		rezervasyonlar = new ArrayList<>();
		Session session = Database.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();
			int kullaniciId = Integer.parseInt(Util.getSession().getAttribute("kullaniciId").toString());

			Query query = session.createQuery(
					"select r.rezervasyonId, u.uyeAdi, u.uyeSoyadi, r.numuneAdi, r.analizAdi, r.rezervasyonDurum, r.baslamaZamani from Rezervasyon r inner join r.uye as u where u.uyeId = :kullaniciId and r.bitisZamani > :date and r.baslamaZamani < :date order by r.baslamaZamani");
			query.setParameter("kullaniciId", kullaniciId);
			query.setParameter("date", date);
			List<Object[]> rezervasyonlarim = query.list();

			for (Object[] list : rezervasyonlarim) {
				rezervasyonlar.add(new RezervasyonPojo((int) list[0], (String) list[1] + " " + (String) list[2],
						(String) list[3], (String) list[4], (String) list[5], (Date) list[6]));
			}

			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
			return rezervasyonlar;
		}
	}
}
