package com.symphony.resources.services;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.symphony.resources.services.Database;
import com.symphony.resources.services.ApplicantService;

@Path("/appinfo")
public class ApplicantResources {

	ApplicantService applicants = new ApplicantService();	
	Database db;
	Connection con;
	
	// Create database connection upon accessing resources..
	public ApplicantResources() throws Exception{
		db = new Database();
		con = db.getConnection();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Applicant> getApplicant(@QueryParam("firstname") String firstName, 
										@QueryParam("lastname") String lastName, 
										@QueryParam("prefname") String prefName,
										@QueryParam("amount") int amountRequested
										) throws SQLException{
		System.out.println("Connection succesful. Now displaying list of applicants...");
		ArrayList<Applicant> appList = new ArrayList<Applicant>();
		
		if(firstName != null){
			appList = applicants.getApplicantByName(firstName,con);
			System.out.println("Closing database connection...");
			applicants.closeDatabaseCon(con);
			return appList;
		} if(lastName != null){
			appList = applicants.getApplicantByName(lastName,con);
			System.out.println("Closing database connection...");
			applicants.closeDatabaseCon(con);
			return appList;
		} if(prefName != null){
			appList = applicants.getApplicantByName(prefName,con);
			System.out.println("Closing database connection...");
			applicants.closeDatabaseCon(con);
			return appList;
		} if(amountRequested > 0){
			appList = applicants.lessThanLoanAmount(amountRequested,con);
			System.out.println("Closing database connection...");
			applicants.closeDatabaseCon(con);
			return appList;	
		}
		appList = applicants.getAllApplicants(con);
		System.out.println("Closing database connection...");
		applicants.closeDatabaseCon(con);
		return appList;		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_XML)
	public void addApplicant(		@FormParam("input_first") String first, 
									@FormParam("input_middleInit") String middle,
									@FormParam("input_last") String last,
									@FormParam("input_prefName") String prefName,
									@FormParam("input_sin") long sin,
									@FormParam("input_number") String number,
									@FormParam("input_amount") int amount,
									@FormParam("question1") Boolean q1,
									@FormParam("question2") Boolean q2,
									@FormParam("question3") Boolean q3									
			   								) throws SQLException{
//		Applicant retApplicant= applicants.addApplicant(new Applicant(0,first,middle,last,prefName,sin,number,amount,q1,q2,q3), con);
		applicants.addApplicant(new Applicant(0,first,middle,last,prefName,sin,number,amount,q1,q2,q3), con);
		System.out.println("Closing database connection...");
		applicants.closeDatabaseCon(con);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Applicant addApplicant(Applicant applicant) throws Exception{
		Applicant retApplicant = applicants.addApplicant(applicant, con);
		System.out.println("Closing database connection...");
		applicants.closeDatabaseCon(con);
		return retApplicant;
	}
	
}
