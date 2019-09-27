package com.well.entity;


public class Deal {

	String dealID;
	String dealName;
	
	
	public Deal(String dealID, String dealName){
		this.dealID = dealID;
		this.dealName = dealName;
	}


	public String getDealID() {
		return dealID;
	}


	public void setDealID(String dealID) {
		this.dealID = dealID;
	}


	public String getDealName() {
		return dealName;
	}


	public void setDealName(String dealName) {
		this.dealName = dealName;
	}
	
	
}
