package com.tracker.model;

import java.math.BigInteger;


public class TrainDetails {
	
	private BigInteger Train_Number;
	private String Train_Name;
	
	public BigInteger getTrain_Number() {
		return Train_Number;
	}
	public void setTrain_Number(BigInteger train_Number) {
		Train_Number = train_Number;
	}
	public String getTrain_Name() {
		return Train_Name;
	}
	public void setTrain_Name(String train_Name) {
		Train_Name = train_Name;
	}
	
	
}
