package com.iersinyavas.bitirmeprojesi.mangedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.event.RowEditEvent;

import com.iersinyavas.bitirmeprojesi.entity.Analiz;
import com.iersinyavas.bitirmeprojesi.entity.Rezervasyon;
import com.iersinyavas.bitirmeprojesi.entity.Uye;
import com.iersinyavas.bitirmeprojesi.helper.Database;
import com.iersinyavas.bitirmeprojesi.helper.Util;
import com.iersinyavas.bitirmeprojesi.helper.Zaman;
import com.iersinyavas.bitirmeprojesi.pojolar.UyePojo;

@ManagedBean
@SessionScoped
public class UyeBean implements Serializable{
	List<UyePojo> uyeBilgileri;

	public List<UyePojo> getUyeBilgileri() {
		return uyeBilgileri;
	}

	public void setUyeBilgileri(List<UyePojo> uyeBilgileri) {
		this.uyeBilgileri = uyeBilgileri;
	}

	@PostConstruct
	public void uyeBilgileri() {
		uyeBilgileri = new ArrayList<>();
		Session session = Database.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();
			int kullaniciId = Integer.parseInt(Util.getSession().getAttribute("kullaniciId").toString());

			Query query = session.createQuery(
					"select u.uyeId, u.uyeAdi, u.uyeSoyadi, u.uyeEmail, u.uyeKullaniciAdi, u.uyeKullaniciParola, u.uyeTelefon from Uye u where u.uyeId = :kullaniciId");
			query.setParameter("kullaniciId", kullaniciId);
			List<Object[]> uyeBilgilerim = query.list();

			for (Object[] list : uyeBilgilerim) {
				uyeBilgileri.add(new UyePojo((int) list[0], (String) list[1], (String) list[2], (String) list[3],
						(String) list[4], (String) list[5], (String) list[6]));
			}
			transaction.commit();
		} catch (Exception e) {

		} finally {
			session.close();
		}
	}

	public void onRowEdit(RowEditEvent event) {

		Transaction transaction = null;
		Session session = Database.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			for (int i = 0; i < uyeBilgileri.size(); i++) {
				int id = uyeBilgileri.get(i).getUyeId();
				Uye uye = (Uye) session.get(Uye.class, id);
				uye.setUyeEmail(uyeBilgileri.get(i).getUyeEmail());
				uye.setUyeKullaniciAdi(uyeBilgileri.get(i).getUyeKullaniciAdi());
				uye.setUyeKullaniciParola(uyeBilgileri.get(i).getUyeKullaniciParola());
				uye.setUyeTelefon(uyeBilgileri.get(i).getUyeTelefon());
			}
			transaction.commit();
		} catch (Exception e) {

		} finally {
			session.close();
		}
	}

	public void onRowCancel(RowEditEvent event) {

	}
}
