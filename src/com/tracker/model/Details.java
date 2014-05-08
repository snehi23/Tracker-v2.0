package com.tracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tracker")
public class Details {
	
	@Id @GeneratedValue
	int train_journey_id;
	String DOJ;
	String train;
	String from_Station;
	String to_Station;
	String classes;
	String comments;
	
		
	
	
	public Details() {
		super();
	}


	public Details(int train_journey_id, String dOJ, String train,
			String from_Station, String to_Station, String classes,
			String comments) {
		super();
		this.train_journey_id = train_journey_id;
		DOJ = dOJ;
		this.train = train;
		this.from_Station = from_Station;
		this.to_Station = to_Station;
		this.classes = classes;
		this.comments = comments;
	}
	
	
	public int getTrain_journey_id() {
		return train_journey_id;
	}
	public void setTrain_journey_id(int train_journey_id) {
		this.train_journey_id = train_journey_id;
	}
	public String getDOJ() {
		return DOJ;
	}
	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}
	public String getTrain() {
		return train;
	}
	public void setTrain(String train) {
		this.train = train;
	}
	public String getFrom_Station() {
		return from_Station;
	}
	public void setFrom_Station(String from_Station) {
		this.from_Station = from_Station;
	}
	public String getTo_Station() {
		return to_Station;
	}
	public void setTo_Station(String to_Station) {
		this.to_Station = to_Station;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
		

}
