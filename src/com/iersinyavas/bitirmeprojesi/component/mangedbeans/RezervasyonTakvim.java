package com.iersinyavas.bitirmeprojesi.component.mangedbeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import com.iersinyavas.bitirmeprojesi.entity.Analiz;
import com.iersinyavas.bitirmeprojesi.entity.Rezervasyon;
import com.iersinyavas.bitirmeprojesi.entity.Uye;
import com.iersinyavas.bitirmeprojesi.helper.Database;
import com.iersinyavas.bitirmeprojesi.helper.RezervasyonKontrol;
import com.iersinyavas.bitirmeprojesi.helper.RezervasyonSaat;
import com.iersinyavas.bitirmeprojesi.helper.Tarih;
import com.iersinyavas.bitirmeprojesi.helper.Util;
import com.iersinyavas.bitirmeprojesi.helper.Zaman;

@ManagedBean
@ViewScoped
public class RezervasyonTakvim implements Serializable {

	private static final long serialVersionUID = 1L;

	private ScheduleModel eventModel;

	private ScheduleModel lazyEventModel;

	private ScheduleEvent event = new DefaultScheduleEvent();

	public List<Object[]> rezervasyonlar;

	private String sozlesmeDosyasiYolu;

	private String dosyaadi;
	
	String tarih;
	
	String dosyaYolu = "C:/JavaCalismaAlani/Oxygen/BitirmeProjesi/sozlesmedosyalari/";

	@PostConstruct
	public void init() {

		Date date = new Date();
		Database database = new Database();
		Zaman zaman = new Zaman();

		// rezervasyonlar listesine rezervasyon bilgileri burada eklenecek.
		List<Object[]> gr = database.rezervasyonlariGetir(date);
		Session session = Database.getSessionFactory().openSession();
		try {
			for (int i = 0; i < gr.size(); i++) {
				Transaction transaction = session.beginTransaction();
				Rezervasyon rezervasyon = (Rezervasyon) session.get(Rezervasyon.class, (int) gr.get(i)[0]);
				rezervasyon.setBitisZamani(
						zaman.zamanOlustur((Date) gr.get(i)[2], (int) gr.get(i)[4], (int) gr.get(i)[5], 0, new Date()));
				transaction.commit();
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
			// rezervasyonlar listesi veritabanýndan gelecek rezervasyon bilgilerinin
			// ilk açýlýþta takvime eklenmesi için gerekli verilerdir
			rezervasyonlar = database.rezervasyonlariGetir(date);
			eventModel = new DefaultScheduleModel();
			for (Object[] rezervasyonListesi : rezervasyonlar)
				eventModel.addEvent(new DefaultScheduleEvent((String) rezervasyonListesi[1],
						(Date) rezervasyonListesi[2], (Date) rezervasyonListesi[3]));
		}
	}

	public List<Object[]> getRezervasyonlar() {
		return rezervasyonlar;
	}

	public void setRezervasyonlar(List<Object[]> rezervasyonlar) {
		this.rezervasyonlar = rezervasyonlar;
	}

	public String getSozlesmeDosyasiYolu() {
		return sozlesmeDosyasiYolu;
	}

	public void setSozlesmeDosyasiYolu(String sozlesmeDosyasiYolu) {
		this.sozlesmeDosyasiYolu = sozlesmeDosyasiYolu;
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public ScheduleModel getLazyEventModel() {
		return lazyEventModel;
	}

	private Calendar today() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

		return calendar;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

	public String getDosyaadi() {
		return dosyaadi;
	}

	public void setDosyaadi(String dosyaadi) {
		this.dosyaadi = dosyaadi;
	}

	@ManagedProperty(value = "#{userWizard}")
	private UserWizard userWizard;

	public UserWizard getUserWizard() {
		return userWizard;
	}

	public void setUserWizard(UserWizard userWizard) {
		this.userWizard = userWizard;
	}

	public void addEvent(ActionEvent actionEvent) {
		// Rezervasyon da analizin süresi gelecek olan sonraki rezervasyonun üzerine
		// çýkmamalý. Bunun kontrolüde yapýlmalý. Kesinlikle!!!
		SessionFactory sessionFactory = Database.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			HttpSession httpSession = Util.getSession();
			Date date = new Date();
			Zaman zaman = new Zaman();
			RezervasyonSaat rezervasyonSaat = new RezervasyonSaat();
			RezervasyonKontrol rezervasyonKontrol = new RezervasyonKontrol();

			int kullaniciId = Integer.parseInt(httpSession.getAttribute("kullaniciId").toString());
			String kullanicininadi = httpSession.getAttribute("kullaniciAdiSoyadi").toString();
			int saat = rezervasyonSaat.saatGetir(event.getTitle());
			int dakika = rezervasyonSaat.dakikaGetir(event.getTitle());
			Date bitisZamani = zaman.zamanOlustur(event.getStartDate(), saat, dakika, 0, new Date());

			Query query1 = session.createQuery("select a.aktiflik from Analiz a where a.analizAdi = :analizadi");
			query1.setParameter("analizadi", event.getTitle());
			List<Object[]> liste = query1.list();
			String aktiflik = null;
			for (Object l : liste) {
				aktiflik = (String) l;
			}
			if (((event.getStartDate().getYear() == date.getYear())
					&& (event.getStartDate().getMonth() == date.getMonth())
					&& (event.getStartDate().getDate() > date.getDate()))
					|| ((event.getStartDate().getYear() == date.getYear())
							&& (event.getStartDate().getMonth() > date.getMonth()))
					|| ((event.getStartDate().getYear() > date.getYear())))
				if (event.isEditable() == true && event.getStartDate().getHours() - 1 >= 9
						&& (event.getStartDate().getDay() != 6 && event.getStartDate().getDay() != 0)
						&& (event.getStartDate().getHours() - 1 < 17 || (event.getStartDate().getHours() - 1 == 16
								&& event.getStartDate().getMinutes() < 30))) {
					// rezervasyon bilgileri veritabanýna buradan eklenecek.
					if (event.getTitle() != "" && aktiflik.equals("Aktif")
							&& rezervasyonKontrol.isRezervasyon(event.getTitle(), event.getStartDate(), bitisZamani)) {
						Uye uye = (Uye) session.get(Uye.class, kullaniciId);
						Query query = session
								.createQuery("select a.analizId from Analiz a where a.analizAdi = :analizAdi");
						query.setParameter("analizAdi", event.getTitle());
						List<Object[]> sonuclar = (List<Object[]>) query.list();

						int id = 0;
						for (Object sonuc : sonuclar) {
							id = (int) sonuc;
						}

						Analiz analiz = (Analiz) session.get(Analiz.class, id);

						Rezervasyon rezervasyon = new Rezervasyon(kullanicininadi, date, event.getTitle(),
								event.getStartDate(), bitisZamani, event.getTitle() + " - " + kullanicininadi,
								userWizard.getUser().getNumuneAdi(), "Zamanýný bekliyor", uye, analiz,
								this.getSozlesmeDosyasiYolu(), dosyaadi);
						uye.getRezervasyonlar().add(rezervasyon);
						analiz.getRezervasyonlar().add(rezervasyon);
						Transaction transaction = session.beginTransaction();

						session.save(analiz);
						session.save(uye);
						transaction.commit();

						eventModel.addEvent(new DefaultScheduleEvent(event.getTitle() + " - " + kullanicininadi,
								event.getStartDate(), bitisZamani));
						FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
								"REZERVASYON ÝÞLEMÝ GERÇEKLEÞTÝ", "Rezervasyon kaydý yapýlmýþtýr.");
						addMessage(message);

						eventModel.updateEvent(event);
					} else {
						FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"DÝKKAT REZERVASYONLARDA ÇAKIÞMA VAR!!!",
								"Seçilen tarih ve saat baþkasý tarafýndan ayýrtýlmýþtýr. Rezervasyon iþlemi gerçekleþmemiþtir.");
						addMessage(message);
					}
				}
			eventModel.updateEvent(event);

		} catch (HibernateException he) {

		} finally {
			session.close();
			event = new DefaultScheduleEvent();
		}

	}

	
	public void copyFile(String fileName, InputStream in) {
		try {

			OutputStream out = new FileOutputStream(new File(dosyaYolu + fileName));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

			System.out.println("Yeni dosya oluþtu!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void handleFileUpload(FileUploadEvent event) {
		
		try {
			HttpSession httpSession = Util.getSession();
			Date date = new Date();
			dosyaadi = String.valueOf(date.getDate())+"."+String.valueOf(date.getMonth()+1)+"."+String.valueOf((date.getYear()+1900))+"_"+String.valueOf(date.getHours())+"."+String.valueOf(date.getMinutes())+"_"+httpSession.getAttribute("kullaniciAdiSoyadi").toString()+"_"+this.event.getTitle();
			this.setSozlesmeDosyasiYolu(dosyaYolu + dosyaadi);
			copyFile(dosyaadi, event.getFile().getInputstream());
			
			FacesMessage msg = new FacesMessage("Form gönderildi! ", event.getFile().getFileName() + " dosyasý yüklendi.");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
	}

	public void onDateSelect(SelectEvent selectEvent) {
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
	}

	public String tarihGoster(Tarih tarih) {

		return tarih.getDate() + " " + tarih.getAy() + " " + tarih.getYear() + " -- " + tarih.getGun() + " günü Saat: "
				+ tarih.getSaat() + ":" + tarih.getDakika();
	}

	public void onSelectBeforeToday() {
		Date date = new Date();
		Zaman zaman = new Zaman();
		RezervasyonSaat rezervasyonSaat = new RezervasyonSaat();
		RezervasyonKontrol rezervasyonKontrol = new RezervasyonKontrol();
		int saat = rezervasyonSaat.saatGetir(event.getTitle());
		int dakika = rezervasyonSaat.dakikaGetir(event.getTitle());
		Date bitisZamani = zaman.zamanOlustur(event.getStartDate(), saat, dakika, 0, new Date());

		if (((event.getStartDate().getYear() == date.getYear()) && (event.getStartDate().getMonth() == date.getMonth())
				&& (event.getStartDate().getDate() <= date.getDate()))
				|| ((event.getStartDate().getYear() == date.getYear())
						&& (event.getStartDate().getMonth() < date.getMonth()))
				|| ((event.getStartDate().getYear() < date.getYear()))) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Uyarý",
					"Bugün ve bugünden önceki günleri seçemezsiniz!");
			addMessage(message);
		}

		if (event.isEditable() == true
				&& (event.getStartDate().getHours() - 1 < 9 || (event.getStartDate().getHours() - 1 >= 17
						|| (event.getStartDate().getDay() == 6 || event.getStartDate().getDay() == 0)))) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Uyarý",
					"Hafta ve gün sekmeleri içinde hafta içi ve çalýþma saatleri boyunca rezervasyon yaptýrabilirsiniz!");
			addMessage(message);
		}
	}

	public void tarihOlustur() {
		Tarih tarih = new Tarih();
		tarih.setDate(event.getStartDate().getDate());
		tarih.setAy(tarih.ayAdi(event.getStartDate().getMonth()));
		tarih.setYear(event.getStartDate().getYear() + 1900);
		tarih.setGun(tarih.gunAdi(event.getStartDate().getDay()));
		tarih.setSaat(event.getStartDate().getHours() - 1);
		tarih.setDakika(event.getStartDate().getMinutes());

		setTarih(tarihGoster(tarih));
	}

	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public String cikis() {
		HttpSession httpSession = Util.getSession();
		httpSession.invalidate();
		return "login.xhtml?faces-redirect=true";
	}
}
