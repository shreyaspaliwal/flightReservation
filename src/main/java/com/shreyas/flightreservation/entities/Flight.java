package com.shreyas.flightreservation.entities;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Flight extends AbstractEntity {

	private String flightNumber;
	private String operationgAirlines;
	private String departureCity;
	private String arrivalCity;
	private Date dateOfDeparture;
	private Time estimatedDepartureTime;

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOperationgAirlines() {
		return operationgAirlines;
	}

	public void setOperationgAirlines(String operationgAirlines) {
		this.operationgAirlines = operationgAirlines;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	public Time getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}

	public void setEstimatedDepartureTime(Time estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}

}
