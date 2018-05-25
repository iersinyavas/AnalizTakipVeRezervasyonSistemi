package com.iersinyavas.bitirmeprojesi.mangedbeans;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.iersinyavas.bitirmeprojesi.component.mangedbeans.RezervasyonTakvim;
import com.iersinyavas.bitirmeprojesi.entity.Rezervasyon;
import com.iersinyavas.bitirmeprojesi.helper.Database;
import com.iersinyavas.bitirmeprojesi.pojolar.RezervasyonPojo;

@ManagedBean
@ViewScoped
public class AnalizDurumBean implements Serializable {

	private List<RezervasyonPojo> rezervasyonlar;
	private List<RezervasyonPojo> gecmisrezervasyonlar;
	private List<String> analizDurum;
	private StreamedContent file;
	
	@PostConstruct
	public void rezervasyonListesi() {
		analizDurum = new ArrayList<>();
		analizDurum.add("Zamanýný bekliyor");
		analizDurum.add("Baþladý");
		analizDurum.add("Bitti");

		rezervasyonlar = new ArrayList<>();
		gecmisrezervasyonlar = new ArrayList<>();
		Date date = new Date();
		Session session = Database.getSessionFactory().openSession();

		try {
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(
					"select r.rezervasyonId, u.uyeAdi, u.uyeSoyadi, r.numuneAdi, r.analizAdi, r.rezervasyonDurum, r.baslamaZamani, u.uyeTelefon, r.sozlesmeDosyasiYolu, r.dosyaAdi from Rezervasyon r inner join r.uye as u where r.bitisZamani >= :date order by r.bitisZamani");
			query.setParameter("date", date);
			List<Object[]> rezervasyonlarim = query.list();

			for (Object[] list : rezervasyonlarim) {
				rezervasyonlar.add(new RezervasyonPojo((int) list[0], (String) list[1] + " " + (String) list[2],
						(String) list[3], (String) list[4], (String) list[5], (Date) list[6], (String) list[7],
						(String) list[8], (String) list[9]));
			}

			Query query1 = session.createQuery(
					"select r.rezervasyonId, u.uyeAdi, u.uyeSoyadi, r.numuneAdi, r.analizAdi, r.rezervasyonDurum, r.baslamaZamani, u.uyeTelefon, r.sozlesmeDosyasiYolu, r.dosyaAdi from Rezervasyon r inner join r.uye as u where r.bitisZamani < :date order by r.bitisZamani desc");
			query1.setParameter("date", date);
			List<Object[]> gecmisrezervasyonlarim = query1.list();

			for (Object[] list : gecmisrezervasyonlarim) {
				gecmisrezervasyonlar.add(new RezervasyonPojo((int) list[0], (String) list[1] + " " + (String) list[2],
						(String) list[3], (String) list[4], (String) list[5], (Date) list[6], (String) list[7],
						(String) list[8], (String) list[9]));
			}
			transaction.commit();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
	}

	@ManagedProperty(value="#{rezervasyonTakvim}")
	RezervasyonTakvim rezervasyonTakvim;
	
	public RezervasyonTakvim getRezervasyonTakvim() {
		return rezervasyonTakvim;
	}

	public void setRezervasyonTakvim(RezervasyonTakvim rezervasyonTakvim) {
		this.rezervasyonTakvim = rezervasyonTakvim;
	}

	public void dosyaIndir() {
		Map<String, String>  params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String dosyayolu = params.get("dosyayolu");
		String dosyaadi = params.get("dosyaadi");
		
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ExternalContext externalContext = facesContext.getExternalContext();
			externalContext.responseReset();
			externalContext.setResponseContentType("application/pdf");
			externalContext.setResponseHeader("Content-Disposition", "attachment;filename=\"sozlesme_"+dosyaadi+".pdf\"");
			
			FileInputStream fileInputStream = new FileInputStream(new File(dosyayolu));
			OutputStream outputStream = externalContext.getResponseOutputStream();
			
			byte[] buffer = new byte[1024];
			int length;
			while((length = fileInputStream.read(buffer))>0) {
				outputStream.write(buffer, 0, length);
			}
			fileInputStream.close();
			facesContext.responseComplete();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		  
	}

	public List<RezervasyonPojo> getGecmisrezervasyonlar() {
		return gecmisrezervasyonlar;
	}

	public void setGecmisrezervasyonlar(List<RezervasyonPojo> gecmisrezervasyonlar) {
		this.gecmisrezervasyonlar = gecmisrezervasyonlar;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

	public List<String> getAnalizDurum() {
		return analizDurum;
	}

	public void setAnalizDurum(List<String> analizDurum) {
		this.analizDurum = analizDurum;
	}

	public List<RezervasyonPojo> getRezervasyonlar() {
		return rezervasyonlar;
	}

	public void setRezervasyonlar(List<RezervasyonPojo> rezervasyonlar) {
		this.rezervasyonlar = rezervasyonlar;
	}

	public void onRowEdit(RowEditEvent event) {

		Session session = Database.getSessionFactory().openSession();
		try {
			for (int i = 0; i < rezervasyonlar.size(); i++) {
				Transaction transaction = session.beginTransaction();
				int id = rezervasyonlar.get(i).getRezervasyonNo();
				Rezervasyon rezervasyon = (Rezervasyon) session.get(Rezervasyon.class, id);
				rezervasyon.setRezervasyonDurum(rezervasyonlar.get(i).getAnalizinDurumu());
				transaction.commit();
			}
			for (int i = 0; i < gecmisrezervasyonlar.size(); i++) {
				Transaction transaction = session.beginTransaction();
				int id = gecmisrezervasyonlar.get(i).getRezervasyonNo();
				Rezervasyon rezervasyon = (Rezervasyon) session.get(Rezervasyon.class, id);
				rezervasyon.setRezervasyonDurum(gecmisrezervasyonlar.get(i).getAnalizinDurumu());
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