package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.iersinyavas.bitirmeprojesi.entity.Analiz;
import com.iersinyavas.bitirmeprojesi.helper.Database;

public class Main {

	public static void main(String[] args) {

		Analiz analiz1 = new Analiz("BACA GAZI ANAL�Z�R� ANAL�Z�", 7, 30, 100.00, "Aktif");
		Analiz analiz2 = new Analiz("BET ANAL�Z�", 2, 30, 50.00, "Aktif");
		Analiz analiz3 = new Analiz("C�VA POROZ�METRES� ANAL�Z�", 1, 0, 25.50, "Aktif");
		Analiz analiz4 = new Analiz("ELEMENTEL ANAL�Z", 8, 0, 40.00, "Aktif");
		Analiz analiz5 = new Analiz("FTIR ANAL�Z�", 3, 30, 80, "Aktif");
		Analiz analiz6 = new Analiz("GAZ P�KNOMETRES� ANAL�Z�", 10, 30, 75.00, "Aktif");
		Analiz analiz7 = new Analiz("GC-MS ANAL�Z", 2, 30, 85.50, "Aktif");
		Analiz analiz8 = new Analiz("LC-MS/MS ANAL�Z", 4, 0, 75.00, "Aktif");
		Analiz analiz9 = new Analiz("PART�K�L BOYUTU �L��M ANAL�Z�", 3, 0, 30.00, "Aktif");
		Analiz analiz10 = new Analiz("TARAMALI ELEKTRON M�KROSKOBU ANAL�Z�", 1, 30, 45.00, "Aktif");
		Analiz analiz11 = new Analiz("SERTL�K �L��M ANAL�Z�", 5, 30, 50.00, "Aktif");
		Analiz analiz12 = new Analiz("UV-VIS SPEKTROFOTOMETRES� ANAL�Z�", 12, 30, 75.00, "Aktif");
		Analiz analiz13 = new Analiz("XRD ANAL�Z�", 7, 0, 90.00, "Aktif");
		Analiz analiz14 = new Analiz("ZETA POTANS�YEL ve MOB�L�TE �L��M  ANAL�Z�", 6, 30, 100.00, "Aktif");
		Analiz analiz15 = new Analiz("TERMAL ANAL�Z", 10, 30, 45.00, "Aktif");
		Analiz analiz16 = new Analiz("STEREO M�KROSKOBU �L��M C�HAZI ANAL�Z", 2, 0, 35.00, "Aktif");

		/*Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);*/
		Session session = Database.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		/*Query query = session.createQuery("select r.analizAdi, r.rezervasyonDurum, u.uyeAdi, u.uyeEmail from Rezervasyon r inner join r.uye as u where u.uyeId=1");
		
		List<Object[]> sonuc = query.list();
		String isim, analiz, durum, email;
		for(Object[] o : sonuc) {
			analiz = (String) o[0];
			durum = (String) o[1];
			isim = (String) o[2];
			email = (String) o[3];
			System.out.println(analiz+" "+durum+" "+isim+" "+email);
		}*/
		
		session.save(analiz1);
		session.save(analiz2);
		session.save(analiz3);
		session.save(analiz4);
		session.save(analiz5);
		session.save(analiz6);
		session.save(analiz7);
		session.save(analiz8);
		session.save(analiz9);
		session.save(analiz10);
		session.save(analiz11);
		session.save(analiz12);
		session.save(analiz13);
		session.save(analiz14);
		session.save(analiz15);
		session.save(analiz16);
		
		transaction.commit();
		session.close();
		Database.getSessionFactory().close();

	}

}
