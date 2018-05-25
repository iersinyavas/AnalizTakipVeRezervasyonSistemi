package com.iersinyavas.bitirmeprojesi.component.mangedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.event.FlowEvent;

import com.iersinyavas.bitirmeprojesi.helper.Database;

@ManagedBean
@ViewScoped
public class UserWizard implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user = new User();

	private boolean skip;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*
	 * public void save() { FacesMessage msg = new FacesMessage("Successful",
	 * "Welcome :" + user.getFirstname());
	 * FacesContext.getCurrentInstance().addMessage(null, msg); }
	 */

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}
}