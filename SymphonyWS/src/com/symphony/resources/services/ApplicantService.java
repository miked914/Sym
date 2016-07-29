package com.symphony.resources.services;

import java.sql.*;
import java.util.ArrayList;

import com.symphony.resources.services.Applicant;

public class ApplicantService {

	public ApplicantService(){
			
	}
	
	//Returns all applicants
	public ArrayList<Applicant> getAllApplicants(Connection con) throws SQLException{
		ArrayList<Applicant> appList = new ArrayList<Applicant>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM applicants");
		ResultSet rs = stmt.executeQuery();
		try	{
		while(rs.next()) {
		Applicant appObj = new Applicant();
		appObj.setId(rs.getInt("applicantId"));
		appObj.setFirstName(rs.getString("first"));
		appObj.setLastName(rs.getString("last"));
		appObj.setMiddleInit(rs.getString("middleInit"));
		appObj.setPreferredName(rs.getString("prefName"));
		appObj.setSin(rs.getInt("sin"));
		appObj.setPhoneNumber(rs.getString("number"));
		appObj.setAmountRequested(rs.getInt("amountReq"));
		appObj.setQuestion1(rs.getBoolean("question1"));
		appObj.setQuestion2(rs.getBoolean("question2"));
		appObj.setQuestion3(rs.getBoolean("question3"));		
		appList.add(appObj);
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }
		return appList;	
	}
		
	//Search applicant by Name
	public ArrayList<Applicant> getApplicantByName(String name, Connection con) throws SQLException{
		ArrayList<Applicant> applicantsNames = new ArrayList<>();		// new list to be passed back
		ArrayList<Applicant> appList = new ArrayList<>();			// list for the db collection
		try {
			appList = getAllApplicants(con);
		} catch (SQLException e) {
			//  Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Applicant applicant : appList){
			
			if(applicant.getFirstName().toLowerCase().equals(name.toLowerCase())){
				applicantsNames.add(applicant);
			} else if(applicant.getLastName().toLowerCase().equals(name.toLowerCase())){
				applicantsNames.add(applicant);
			} else if(applicant.getPreferredName().toLowerCase().equals(name.toLowerCase())){
				applicantsNames.add(applicant);
			}
		}
		
		return applicantsNames;
	}
	
	//Search less than loan amount
	public ArrayList<Applicant> lessThanLoanAmount(int amountRequested, Connection con) throws SQLException{
		ArrayList<Applicant> applicantsByLoan = new ArrayList<>();			// new list to be passed back
		ArrayList<Applicant> appList = new ArrayList<>();		// list for the db collection
		try {
			appList = getAllApplicants(con);
		} catch (SQLException e) {
			//  Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Applicant applicant : appList){			
			if(applicant.getAmountRequested() <= amountRequested){
				applicantsByLoan.add(applicant);
			}
		}		
		return applicantsByLoan;
	}
	

	//Adding applicant
	public Applicant addApplicant(Applicant applicant, Connection con) throws SQLException{
				
		// Execute a query
	      System.out.println("Inserting records into the table...");
	     // Statement stmt = con.createStatement();
	      PreparedStatement stmt = con.prepareStatement("INSERT INTO applicants VALUES "
	      		+ "(?,?,?,?,?,?,?,?,?,?,?)");
	      Statement cnt = con.createStatement();
	      
	   // Get the number of rows from the result set
	      ResultSet resultCnt = cnt.executeQuery("SELECT COUNT(*) FROM applicants");
	      resultCnt.next();
	      int rowCnt = resultCnt.getInt(1);
	      System.out.println("Number of records in table: "+rowCnt);
	      int newId = rowCnt+1;
	      
	   // Try adding applicant   
		try{					      
			 stmt.setInt(1,newId);
			 stmt.setString(2,applicant.getFirstName());
			 stmt.setString(3,applicant.getLastName());
			 stmt.setString(4,applicant.getMiddleInit());
			 stmt.setString(5,applicant.getPreferredName());
			 stmt.setInt(6,(int)applicant.getSin());
			 stmt.setString(7,applicant.getPhoneNumber());
			 stmt.setInt(8,applicant.getAmountRequested());
			 stmt.setBoolean(9,applicant.getQuestion1());
			 stmt.setBoolean(10,applicant.getQuestion2());
			 stmt.setBoolean(11,applicant.getQuestion3());
		     stmt.executeUpdate();
		}catch(SQLException se){
			//Handle errors for JDBC
			System.out.println("Sorry, insert was unsuccessful.");
		    se.printStackTrace();		      
		    try{
		    	if(stmt!=null)
		    		stmt.close();
		    }catch(SQLException se2){
		    	se2.printStackTrace();
		    }		    
		    return applicant;
		}catch(Exception e){
			//Handle errors for Class.forName	
			System.out.println("Sorry, insert was unsuccessful.");
			e.printStackTrace();			
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
				se2.printStackTrace();
			}				
			return applicant;
		}
		System.out.println("Insert was successful.");
		try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }
		
		return applicant;
	}
	
	// method for closing connection to database.. so that tomcat doesn't throw warning and do default closing
	public void closeDatabaseCon(Connection con) throws SQLException{		      
		   try{
		         if(con!=null)
		            con.close();		         
		      }catch(SQLException se){
		         throw se;
		      }
	}
	
}





