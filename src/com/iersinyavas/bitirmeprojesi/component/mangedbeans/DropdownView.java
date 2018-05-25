package com.iersinyavas.bitirmeprojesi.component.mangedbeans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.iersinyavas.bitirmeprojesi.helper.Database;

@ManagedBean
@ViewScoped
public class DropdownView implements Serializable {

	private static final long serialVersionUID = 1L;
	private Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();
	private String analiz;
	private Map<String, String> analizler;

	@PostConstruct
	public void init() {

		analizler = new HashMap<String, String>();

		Session session = Database.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			List<Object[]> analizlerdb = session.createQuery("select a.analizAdi, a.aktiflik from Analiz a").list();
			for (Object[] analiz : analizlerdb) {
				if ((((String) analiz[1]).equals("Pasif")))
					analizler.put((String) analiz[0] + "(ARIZALI)", (String) analiz[0] + "(ARIZALI)");
				else
					analizler.put((String) analiz[0], (String) analiz[0]);
			}

			transaction.commit();
		} catch (Exception e) {

		} finally {
			session.close();
		}
	}

	public Map<String, Map<String, String>> getData() {
		return data;
	}

	public String getAnaliz() {
		return analiz;
	}

	public void setAnaliz(String analiz) {
		this.analiz = analiz;
	}

	public Map<String, String> getAnalizler() {
		return analizler;
	}
}