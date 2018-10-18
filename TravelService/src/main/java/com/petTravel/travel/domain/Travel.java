package com.petTravel.travel.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="travel")
public class Travel {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
	@Column(name="destination")
	String destination;
	
	@Column(name="departure")
	String departure;
	
	@Column(name="date")
	String date;

	public Travel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Travel(Integer id, String destination, String departure, String date) {
		super();
		this.id = id;
		this.destination = destination;
		this.departure = departure;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Travel [id=" + id + ", destination=" + destination + ", departure=" + departure + ", date=" + date
				+ "]";
	}
}
