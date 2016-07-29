package com.symphony.resources.services;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class viewController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String page = "templates/initial.xhtml";
	
	@PostConstruct
	public void init() {
		this.setPage("templates/initial.xhtml");
	}
	
	public void pageControl(String page){
		if (page.equals("Demographic")) {
			this.setPage("templates/Demographic.xhtml");
		}
		else {
			this.setPage("templates/initial.xhtml");
		}
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
}
