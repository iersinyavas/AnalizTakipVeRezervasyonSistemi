package com.iersinyavas.bitirmeprojesi.helper;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Database {
	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure();

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();

		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Database.sessionFactory = sessionFactory;
		return Database.sessionFactory;
	}

	public List<Object[]> rezervasyonlariGetir(Date baslamaZamani) {
		List<Object[]> rezervasyonlar = null;
		Session session = getSessionFactory().openSession();

		try {
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(
					"select rezervasyon.rezervasyonId, rezervasyon.rezervasyonEtiket, rezervasyon.baslamaZamani, rezervasyon.bitisZamani, analiz.analizSuresiSaat, analiz.analizSuresiDakika from Rezervasyon rezervasyon inner join rezervasyon.analiz analiz inner join rezervasyon.uye u where rezervasyon.baslamaZamani >= :baslamaZamani and u.uyeCeza != :uyeCeza");
			query.setParameter("uyeCeza", "Cezalý");
			query.setParameter("baslamaZamani", baslamaZamani);
			rezervasyonlar = (List<Object[]>) query.list();
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
			return rezervasyonlar;
		}
	}

	public List<Object[]> kayitGetir(String uyeKullaniciAdi, String uyeKullaniciParola) {
		List<Object[]> kayit = null;
		Session session = getSessionFactory().openSession();

		try {
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(
					"select uye.uyeId, uye.uyeKullaniciAdi, uye.uyeKullaniciParola, uye.uyeAdi, uye.uyeSoyadi from Uye uye where uye.uyeKullaniciAdi = :uyeKullaniciAdi and uye.uyeKullaniciParola = :uyeKullaniciParola");
			query.setParameter("uyeKullaniciAdi", uyeKullaniciAdi);
			query.setParameter("uyeKullaniciParola", uyeKullaniciParola);

			kayit = (List<Object[]>) query.list();
			transaction.commit();
		} catch (Exception e) {

		} finally {
			session.close();
			return kayit;
		}
	}

	public boolean isKayit(String uyeKullaniciAdi, String uyeEmail) {
		List<Object[]> kayit;
		String kullaniciAd = null, kullaniciEmail = null;
		Session session = getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();

			Query query = session.createQuery(
					"select uye.uyeKullaniciAdi, uye.uyeEmail from Uye uye where uye.uyeKullaniciAdi = :uyeKullaniciAdi or uye.uyeEmail = :uyeEmail");
			query.setParameter("uyeKullaniciAdi", uyeKullaniciAdi);
			query.setParameter("uyeEmail", uyeEmail);

			kayit = (List<Object[]>) query.list();
			for (Object[] kullaniciObj : kayit) {
				kullaniciAd = (String) kullaniciObj[0];
				kullaniciEmail = (String) kullaniciObj[1];
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
			if ((uyeEmail.equals(kullaniciEmail) || uyeKullaniciAdi.equals(kullaniciAd))) {
				return false;
			} else {
				return true;
			}
		}
	}
}
