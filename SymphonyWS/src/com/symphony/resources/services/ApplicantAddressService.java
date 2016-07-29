package com.symphony.resources.services;

import java.sql.*;
import java.util.ArrayList;

import com.symphony.resources.services.ApplicantAddress;


public class ApplicantAddressService {
	
	public ArrayList<ApplicantAddress> getAllAddresses(Connection con) throws SQLException{
		
		ArrayList<ApplicantAddress> addressList = new ArrayList<ApplicantAddress>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM applicantAddress");
		ResultSet rs = stmt.executeQuery();
		try	{
		while(rs.next()){
		ApplicantAddress addressObj = new ApplicantAddress();
		addressObj.setId(rs.getInt("applicantId"));
		addressObj.setStreetAddr(rs.getString("street"));
		addressObj.setCityAddr(rs.getString("city"));
		addressObj.setStateAddr(rs.getString("state"));
		addressObj.setCountryAddr(rs.getString("country"));
		addressObj.setZipcodeAddr(rs.getString("zipcode"));
		addressObj.setTimeAtResidence(rs.getString("residenceTime"));
		addressList.add(addressObj);
		}
		} catch (SQLException e){
		e.printStackTrace();
		}
		try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }
		return addressList;
	}
	
	// Get Applicant Address by property 
	//(by searching for a specific property the applicant address with that property will be returned)
	
	public ArrayList<ApplicantAddress> getAddressByProperty(String property, Connection con) throws SQLException{
		ArrayList<ApplicantAddress> applicantAddresses = new ArrayList<>();		// new list to be passed back
		ArrayList<ApplicantAddress> appAddresses = new ArrayList<>();			// list for the db collection
		try {
			appAddresses = getAllAddresses(con);
		} catch (SQLException e) {
			//  Auto-generated catch block
			e.printStackTrace();
		}
		
		for(ApplicantAddress address: appAddresses){	// appAddresses = database collection
			
			if(address.getStreetAddr().toLowerCase().equals(property.toLowerCase())){
				applicantAddresses.add(address);
			}			
			else if(address.getCityAddr().toLowerCase().equals(property.toLowerCase())){
				applicantAddresses.add(address);
			}			
			else if(address.getStateAddr().toLowerCase().equals(property.toLowerCase())){
				applicantAddresses.add(address);
			}			
			else if(address.getCountryAddr().toLowerCase().equals(property.toLowerCase())){
				applicantAddresses.add(address);
			}					
			else if(address.getZipcodeAddr().toLowerCase().equals(property.toLowerCase())){
				applicantAddresses.add(address);
			}
			else if(address.getTimeAtResidence().toLowerCase().equals(property.toLowerCase())){
				applicantAddresses.add(address);
			}
		}
		return applicantAddresses;
	}
		
	public ApplicantAddress addAddress(ApplicantAddress address, Connection con) throws SQLException{
		
		// Execute a query
	      System.out.println("Inserting records into the table...");
	      
	   //   Statement stmt = con.createStatement();
	      PreparedStatement stmt = con.prepareStatement("INSERT INTO applicantAddress VALUES "
		      		+ "(?,?,?,?,?,?,?)");
	      Statement cnt = con.createStatement();
	      
	   // Get the number of rows from the result set
	      ResultSet resultCnt = cnt.executeQuery("SELECT COUNT(*) FROM applicantAddress");
	      resultCnt.next();
	      int rowCnt = resultCnt.getInt(1);
	      System.out.println("Number of records in table: "+rowCnt);
	      int newId = rowCnt+1;
	      address.setId(newId);
	      
	   // Try adding address	
		try{
			stmt.setInt(1,newId);
			stmt.setString(2,address.getStreetAddr());
			stmt.setString(3,address.getCityAddr());
			stmt.setString(4,address.getStateAddr());
			stmt.setString(5,address.getCountryAddr());
			stmt.setString(6,address.getZipcodeAddr());
			stmt.setString(7,address.getTimeAtResidence());
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
		    
		    return address;
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
				
			return address;
		}
		System.out.println("Insert was successful.");
		try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }
		
		return address;
	}
	
	//	method for closing connection to database.. so that tomcat doesn't throw warning and do default closing
	public void closeDatabaseCon(Connection con) throws SQLException{		      
		   try{
		         if(con!=null)
		            con.close();		         
		      }catch(SQLException se){
		         throw se;
		      }
		   }	
	
		
}
	
