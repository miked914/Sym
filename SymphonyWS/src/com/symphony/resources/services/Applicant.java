//package com.symphony.resources.services;
package com.symphony.resources.services;


import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Applicant implements Serializable {
		//Set bounds on variables
	
		private static final long serialVersionUID = 1L;

		public final static int intLowerLimit			=		0;
		private final static int limitName 				= 		15;
		private final static int limitMiddleInit		=		1;
		private final static int limitPrefName			=		10;
		private final static int limitSin				=		999999999;
		private final static int limitPhoneNumber		=		10;
		
		//Declared applicant variables
		private long id;
		private String firstName;
		private String middleInit;
		private String lastName;
		private String preferredName;
		private long sin;
		private String phoneNumber;
		private int amountRequested;
		private boolean question1;
		private boolean question2;
		private boolean question3;
		
		
		public Applicant(){
			this.setFirstName("");
			this.setMiddleInit("");
			this.setLastName("");
			this.setPreferredName("");
			this.setSin(0);
			this.setPhoneNumber("");
			this.setAmountRequested(0);
			this.setQuestion1(false);
			this.setQuestion2(false);
			this.setQuestion3(false);
		}
		
		public Applicant(long id, String fName, String mInit, String lName, String prefName, long sin, String pNumber, int amount, boolean q1, boolean q2, boolean q3){
			this.setId(id);
			this.setFirstName(fName);
			this.setMiddleInit(mInit);
			this.setLastName(lName);
			this.setPreferredName(prefName);
			this.setSin(sin);
			this.setPhoneNumber(pNumber);
			this.setAmountRequested(amount);
			this.setQuestion1(q1);
			this.setQuestion2(q2);
			this.setQuestion3(q3);
		}
		
		//Below: getter/setters
		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
//			if(firstName.length() >= intLowerLimit && firstName.length() <= limitName){
				this.firstName = firstName;
//			}else {
//				return;
//			}
		}
		
		public String getMiddleInit() {
			return middleInit;
		}

		public void setMiddleInit(String middleInit) {
		//	if(middleInit.length() >= intLowerLimit && middleInit.length() <= limitMiddleInit){
				this.middleInit = middleInit;
	//		} else{
	//			return;
	//		}
			
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
//			if(lastName.length() >= intLowerLimit && lastName.length() <= limitName){
				this.lastName = lastName;
//			} else {
//				return;
//			}	
		}

		public String getPreferredName() {
			return preferredName;
		}

		public void setPreferredName(String preferredName) {
//			if(preferredName.length() >= intLowerLimit && preferredName.length() <= limitPrefName){
				this.preferredName = preferredName;
//			} else {
//				return;
//			}
		}

		public long getSin() {			
			return sin;
		}

		public void setSin(long sin) {
//			if(sin >= intLowerLimit && sin <= limitSin){
				this.sin = sin;
//			} else {
//				return;
//			}
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
//			if(phoneNumber.length() == limitPhoneNumber){
				this.phoneNumber = phoneNumber;
//			} else {
//				return;
//			}
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
//			if(id >= intLowerLimit){
				this.id = id;
//			} else {
//				return;
//			}
		}
		
		public int getAmountRequested(){
			return amountRequested;
		}
		
		public void setAmountRequested(int amountRequested){
//			if(amountRequested > 0){
				this.amountRequested = amountRequested;
//			} else {
//				return;
//			}
		}
		
		public boolean getQuestion1(){
			return question1;
		}

		public void setQuestion1(boolean question1){
			this.question1 = question1;
		}
		
		public boolean getQuestion2(){
			return question2;
		}

		public void setQuestion2(boolean question2){
			this.question2 = question2;
		}
		
		public boolean getQuestion3(){
			return question3;
		}

		public void setQuestion3(boolean question3){
			this.question3 = question3;
		}
		
}
