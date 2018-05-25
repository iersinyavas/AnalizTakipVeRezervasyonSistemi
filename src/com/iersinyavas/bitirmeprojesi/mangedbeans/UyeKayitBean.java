package com.iersinyavas.bitirmeprojesi.mangedbeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.iersinyavas.bitirmeprojesi.entity.Uye;
import com.iersinyavas.bitirmeprojesi.helper.Database;

@ManagedBean
public class UyeKayitBean {

	private String uyeAdi;
	private String uyeSoyadi;
	private String uyeEmail;
	private String uyeKullaniciAdi;
	private String uyeKullaniciParola;
	private String uyeTelefon;
	private String yetkili;
	
	public void uyeKayitEkle() {
		Database database = new Database();
		if (database.isKayit(uyeKullaniciAdi, uyeEmail)) {
			Uye uye = new Uye(uyeAdi, uyeSoyadi, uyeEmail, uyeKullaniciAdi, uyeKullaniciParola, uyeTelefon, "Deðil");
			Session session = Database.getSessionFactory().openSession();
			try {
				Transaction transaction = session.beginTransaction();
				session.save(uye);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Kayýt Baþarýlý.", "Kayýt Baþarýlý."));
				transaction.commit();
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				session.close();
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Bu hesap zaten mevcut!", "Bu hesap zaten mevcut"));
		}
	}

	
	public String getYetkili() {
		return yetkili;
	}

	public void setYetkili(String yetkili) {
		this.yetkili = yetkili;
	}

	public String getUyeTelefon() {
		return uyeTelefon;
	}

	public void setUyeTelefon(String uyeTelefon) {
		this.uyeTelefon = uyeTelefon;
	}

	public String getUyeAdi() {
		return uyeAdi;
	}

	public void setUyeAdi(String uyeAdi) {
		this.uyeAdi = uyeAdi;
	}

	public String getUyeSoyadi() {
		return uyeSoyadi;
	}

	public void setUyeSoyadi(String uyeSoyadi) {
		this.uyeSoyadi = uyeSoyadi;
	}

	public String getUyeEmail() {
		return uyeEmail;
	}

	public void setUyeEmail(String uyeEmail) {
		this.uyeEmail = uyeEmail;
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

}
