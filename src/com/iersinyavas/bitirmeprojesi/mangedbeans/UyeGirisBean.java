package com.iersinyavas.bitirmeprojesi.mangedbeans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iersinyavas.bitirmeprojesi.helper.Database;
import com.iersinyavas.bitirmeprojesi.helper.Util;

@ManagedBean
@ApplicationScoped
public class UyeGirisBean {
	private List<String> yetkilikullanicilar;
	//private static final String[] yetkilikullanicilar = { "fapaydin:1234","asli:1234" };
	private List<String> cezalikullanicilar;
	private String uyeKullaniciAdi;
	private String uyeKullaniciParola;
	private String kullanicihosgeldin;
	private String cezalikullanicihosgeldin;
	private String yetkilikullaniciadi;
	private String yetkilisifre;
	private String cezalikullaniciadi;
	private String cezalisifre;

	public void yetkiliKullanicilar(String uyeYetki) {

		yetkilikullanicilar = new ArrayList<String>();
		Session session = Database.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(
					"select u.uyeKullaniciAdi, u.uyeKullaniciParola from Uye u where u.uyeYetki = :uyeYetki");
			query.setParameter("uyeYetki", uyeYetki);
			List<Object[]> list = query.list();
			for (Object[] o : list)
				yetkilikullanicilar.add(o[0] + ":" + o[1]);
			transaction.commit();
		} catch (Exception e) {

		} finally {
			session.close();

		}
	}

	public void cezaliKullanicilar(String uyeCeza) {
		cezalikullanicilar = new ArrayList<String>();
		Session session = Database.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(
					"select u.uyeKullaniciAdi, u.uyeKullaniciParola from Uye u where u.uyeCeza = :uyeCeza");
			query.setParameter("uyeCeza", uyeCeza);
			List<Object[]> list = query.list();
			for (Object[] o : list)
				cezalikullanicilar.add(o[0] + ":" + o[1]);
			transaction.commit();
		} catch (Exception e) {

		} finally {
			session.close();

		}
	}

	public String getCezalikullanicihosgeldin() {
		return cezalikullanicihosgeldin;
	}

	public void setCezalikullanicihosgeldin(String cezalikullanicihosgeldin) {
		this.cezalikullanicihosgeldin = cezalikullanicihosgeldin;
	}

	public String getKullanicihosgeldin() {
		return kullanicihosgeldin;
	}

	public void setKullanicihosgeldin(String kullanicihosgeldin) {
		this.kullanicihosgeldin = kullanicihosgeldin;
	}

	public String getUyeKullaniciAdi() {
		return uyeKullaniciAdi;
	}

	public void setUyeKullaniciAdi(String uyeKullaniciAdi) {
		this.uyeKullaniciAdi = uyeKullaniciAdi;
	}

	public String getUyeKullaniciParola() {
		return uyeKullaniciParola;
	}

	public void setUyeKullaniciParola(String uyeKullaniciParola) {
		this.uyeKullaniciParola = uyeKullaniciParola;
	}

	public String girisYap() {	
		
		yetkiliKullanicilar("Yetkili");
		cezaliKullanicilar("Cezalý");
		Database database = new Database();
		List<Object[]> kayit = database.kayitGetir(uyeKullaniciAdi, uyeKullaniciParola);

		int kullaniciId = 0;
		String kullaniciAd = null, kullaniciSifre = null, kullaniciAdiSoyadi = null;
		for (Object[] kullaniciObj : kayit) {
			kullaniciId = (int) kullaniciObj[0];
			kullaniciAd = (String) kullaniciObj[1];
			kullaniciSifre = (String) kullaniciObj[2];
			kullaniciAdiSoyadi = (String) kullaniciObj[3] + " " + (String) kullaniciObj[4];
		}

		if (getUyeKullaniciAdi().equals(kullaniciAd) && getUyeKullaniciParola().equals(kullaniciSifre)) {

			for (String cezalikullanici : cezalikullanicilar) {
				cezalikullaniciadi = cezalikullanici.split(":")[0];
				cezalisifre = cezalikullanici.split(":")[1];

				if (getUyeKullaniciAdi().equals(cezalikullaniciadi) && getUyeKullaniciParola().equals(cezalisifre)) {
					HttpSession httpSession = Util.getSession();
					httpSession.setAttribute("kullaniciId", kullaniciId);
					httpSession.setAttribute("kullaniciAd", kullaniciAd);
					httpSession.setAttribute("kullaniciAdiSoyadi", kullaniciAdiSoyadi);
					httpSession.setAttribute("yonlendir", "cezalikullanicisayfasi.xhtml?faces-redirect=true");
					httpSession.getAttribute("kullaniciAdiSoyadi").toString();
					cezalikullanicihosgeldin = "Sayýn, " + kullaniciAdiSoyadi
							+ " ayýrtýlan rezervasyon için iþlem yapmadýðýnýzdan dolayý 2 aylýðýna sisteme giriþ yapamanýz engellenmiþtir.";
					HttpSession httpSession1 = Util.getSession();
					httpSession1.invalidate();
					Database.getSessionFactory().close();
					return "cezalikullanicisayfasi.xhtml?faces-redirect=true";
				}
			}
			
			for (String yetkilikullanici : yetkilikullanicilar) {
				yetkilikullaniciadi = yetkilikullanici.split(":")[0];
				yetkilisifre = yetkilikullanici.split(":")[1];

				if (getUyeKullaniciAdi().equals(yetkilikullaniciadi) && getUyeKullaniciParola().equals(yetkilisifre)) {
					HttpSession httpSession = Util.getSession();
					httpSession.setAttribute("kullaniciId", kullaniciId);
					httpSession.setAttribute("kullaniciAd", kullaniciAd);
					httpSession.setAttribute("kullaniciAdiSoyadi", kullaniciAdiSoyadi);
					httpSession.setAttribute("yonlendir", "yetkilikullanicianasayfa.xhtml?faces-redirect=true");
					kullanicihosgeldin = "Sayýn, " + httpSession.getAttribute("kullaniciAdiSoyadi").toString()
							+ " yetkili olarak sisteme giriþ yaptýnýz. Hoþgeldiniz.";

					return "yetkilikullanicianasayfa.xhtml?faces-redirect=true";
				}
			}
			
			HttpSession httpSession = Util.getSession();
			httpSession.setAttribute("kullaniciId", kullaniciId);
			httpSession.setAttribute("kullaniciAd", kullaniciAd);
			httpSession.setAttribute("kullaniciAdiSoyadi", kullaniciAdiSoyadi);
			httpSession.setAttribute("yonlendir", "anasayfa.xhtml?faces-redirect=true");
			kullanicihosgeldin = "Sayýn, " + httpSession.getAttribute("kullaniciAdiSoyadi").toString()
					+ " sisteme hoþgeldiniz.";

			return "anasayfa.xhtml?faces-redirect=true";
		}

		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Kullanýcý adý veya þifre yanlýþ.", "Kullanýcý adý veya þifre yanlýþ."));
			return "login.xhtml";
		}
	}

	public String cikisYap() {
		HttpSession httpSession = Util.getSession();
		httpSession.invalidate();
		Database.getSessionFactory().close();
		return "login.xhtml?faces-redirect=true";
	}

}
