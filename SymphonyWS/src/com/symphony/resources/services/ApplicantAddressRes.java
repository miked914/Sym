package com.symphony.resources.services;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.symphony.resources.services.Database;
import com.symphony.resources.services.ApplicantAddressService;

@Path("/addressinfo")
public class ApplicantAddressRes {
	
	ApplicantAddressService addressService = new ApplicantAddressService();
	Database db;
	Connection con;	
	
	public ApplicantAddressRes() throws Exception{
		db = new Database();
		con = db.getConnection();
	}	

	@GET
	@Produces(MediaType.APPLICATION_XML)							
	public List<ApplicantAddress> getAddress(@QueryParam("street") String street, 
											   @QueryParam("city") String city,
											   @QueryParam("state") String state,
											   @QueryParam("country") String country,
											   @QueryParam("postalCode") String zipcode,
											   @QueryParam("residenceTime") String residence
											   ) throws SQLException{
		
		System.out.println("Connection succesful. Now displaying list of addresses...");
		ArrayList<ApplicantAddress> addressList = new ArrayList<ApplicantAddress>();
		
		if(street != null){			
			addressList = addressService.getAddressByProperty(street,con);
			System.out.println("Closing database connection...");
			addressService.closeDatabaseCon(con);
			return addressList;
		} if(city != null){			
			addressList = addressService.getAddressByProperty(city,con);
			System.out.println("Closing database connection...");
			addressService.closeDatabaseCon(con);
			return addressList;
		} if(state != null){
			addressList = addressService.getAddressByProperty(state,con);
			System.out.println("Closing database connection...");
			addressService.closeDatabaseCon(con);
			return addressList;
		} if(country != null){
			addressList = addressService.getAddressByProperty(country,con);
			System.out.println("Closing database connection...");
			addressService.closeDatabaseCon(con);
			return addressList;
		} if(zipcode != null){
			addressList = addressService.getAddressByProperty(zipcode,con);
			System.out.println("Closing database connection...");
			addressService.closeDatabaseCon(con);
			return addressList;
		} if(residence != null){
			addressList = addressService.getAddressByProperty(residence,con);
			System.out.println("Closing database connection...");
			addressService.closeDatabaseCon(con);
			return addressList;
		}	
		
		addressList = addressService.getAllAddresses(con);
		System.out.println("Closing database connection...");
		addressService.closeDatabaseCon(con);
		return addressList;
	}

	@Path("/setaddress")	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_XML)
	public void createAddress(	@FormParam("input_street") String street, 
											@FormParam("input_city") String city,
											@FormParam("input_state") String state,
											@FormParam("input_country") String country,
											@FormParam("input_postalCode") String zipcode,
											@FormParam("input_residenceTime") String residence
			   								) throws SQLException{

		ApplicantAddress retAddress= addressService.addAddress(new ApplicantAddress(0,street,city,state,country,zipcode,residence), con);
		System.out.println("Closing database connection...");
		addressService.closeDatabaseCon(con);
	
//		return retAddress;
	//	return Response.status(200).entity("Applicant info added:"+street+", "+city+", "+state).build();
//		return street;

	}	
	
	@Path("/setaddress")	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public ApplicantAddress createAddress(ApplicantAddress address) throws Exception{
		ApplicantAddress retAddress= addressService.addAddress(address, con);
		System.out.println("Closing database connection...");
		addressService.closeDatabaseCon(con);
		return retAddress;
	}
	
	// GET IN JSON FORMAT
	@Path("/addressesjson")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAddressListJSON() throws Exception{
		System.out.println("Connection succesful. Now displaying list of adresses...");
		ArrayList<ApplicantAddress> addressList = new ArrayList<ApplicantAddress>();
		addressList = addressService.getAllAddresses(con);
		System.out.println("Closing service connection...");
		addressService.closeDatabaseCon(con);
		Gson gson = new Gson();
		String addresses = gson.toJson(addressList);
		return addresses;		
	}	
}
