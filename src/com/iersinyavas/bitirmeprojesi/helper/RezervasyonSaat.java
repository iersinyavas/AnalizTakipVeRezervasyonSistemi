package com.iersinyavas.bitirmeprojesi.helper;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class RezervasyonSaat {

	public int saatGetir(String analizAdi) {
		List<Object[]> saat = null;
		Session session = Database.getSessionFactory().openSession();

		try {
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(
					"select analiz.analizSuresiSaat from Analiz analiz where analiz.analizAdi = :analizAdi");
			query.setParameter("analizAdi", analizAdi);
			saat = (List<Object[]>) query.list();

			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
			int sa = 0;
			for (Object s : saat) {
				sa = (int) s;
			}
			return sa;
		}
	}

	public int dakikaGetir(String analizAdi) {
		Session session = Database.getSessionFactory().openSession();
		List<Object[]> dakika = null;

		try {
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(
					"select analiz.analizSuresiDakika from Analiz analiz where analiz.analizAdi = :analizAdi");
			query.setParameter("analizAdi", analizAdi);
			dakika = (List<Object[]>) query.list();
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
			int dk = 0;
			for (Object d : dakika) {
				dk = (int) d;
			}
			return dk;
		}
	}
}
