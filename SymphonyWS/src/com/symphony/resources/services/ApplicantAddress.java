package com.symphony.resources.services;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.bind.annotation.XmlRootElement;

//@ManagedBean("ApplicantAddress")
//@SessionScoped
@XmlRootElement(name = "address")
public class ApplicantAddress implements Serializable {
	
//	private final static String limitAddress = "";		// Set bounds
	private static final long serialVersionUID = 1L;
	
	//Basic address properties
	private long id;
	private String streetAddr;
	private String cityAddr;
	private String stateAddr;
	private String countryAddr;
	private String zipcodeAddr;
	private String timeAtResidence; // Time at residence location on form 
	
	public ApplicantAddress() {
		//	Default values if nothing is given to the constructor
		this.setStreetAddr("");
		this.setCityAddr("");
		this.setStateAddr("");
		this.setCountryAddr("");
		this.setZipcodeAddr("");
		this.setTimeAtResidence("");
	}
	
	public ApplicantAddress(long id, String street, String city, String state, String country, String zip, String residence) {
		this.setId(id);
		this.setStreetAddr(street);
		this.setCityAddr(city);
		this.setStateAddr(state);
		this.setCountryAddr(country);
		this.setZipcodeAddr(zip);
		this.setTimeAtResidence(residence);		
	}
	
	//		GETTERS AND SETTERS		
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getStreetAddr() {
		return streetAddr;
	}

	public void setStreetAddr(String streetAddr) {
		this.streetAddr = streetAddr;
	}
	
	public String getCityAddr() {
		return cityAddr;
	}

	public void setCityAddr(String cityAddr) {
		this.cityAddr = cityAddr;
	}
	
	public String getCountryAddr() {
		return countryAddr;
	}

	public void setCountryAddr(String countryAddr) {
		this.countryAddr = countryAddr;
	}
	
	public String getStateAddr() {
		return stateAddr;
	}

	public void setStateAddr(String stateAddr) {
		this.stateAddr = stateAddr;
	}

	public String getZipcodeAddr() {
		return zipcodeAddr;
	}

	public void setZipcodeAddr(String zipcodeAddr) {
		this.zipcodeAddr = zipcodeAddr;
	}

	public String getTimeAtResidence() {
		return timeAtResidence;
	}

	public void setTimeAtResidence(String timeAtResidence) {
		this.timeAtResidence = timeAtResidence;
	}
}
