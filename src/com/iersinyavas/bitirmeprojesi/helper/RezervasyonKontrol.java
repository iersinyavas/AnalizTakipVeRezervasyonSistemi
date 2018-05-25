package com.iersinyavas.bitirmeprojesi.helper;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class RezervasyonKontrol {

	public boolean isRezervasyon(String analizAdi, Date baslamaZamani, Date bitisZamani) {
		Query query = null;
		Transaction transaction = null;
		Session session = Database.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			query = session.createQuery(
					"select r.analizAdi from Rezervasyon r inner join r.uye u where u.uyeCeza != :uyeCeza and r.analizAdi = :analizAdi and (r.analizAdi = :analizAdi and ((r.baslamaZamani < :bitisZamani and r.baslamaZamani > :baslamaZamani) or (r.baslamaZamani <= :baslamaZamani and r.bitisZamani > :baslamaZamani)))");
			query.setParameter("uyeCeza", "Cezalý");
			query.setParameter("analizAdi", analizAdi);
			query.setParameter("bitisZamani", bitisZamani);
			query.setParameter("baslamaZamani", baslamaZamani);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (query.list().isEmpty()) {
				transaction.commit();
				session.close();
				Database.getSessionFactory().close();
				return true;
			} else {
				transaction.commit();
				session.close();
				Database.getSessionFactory().close();
				return false;
			}
		}
	}
}
