package com.example.myapp.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import javax.validation.constraints.NotNull;

import com.example.myapp.domain.model.City;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table (name = "restaurants")
public class Restaurant implements Serializable {
	
	@Id
	@NotNull
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private int id;

	@NotNull
	@Column (name = "name", nullable = false)
	private String name;
	
	@Column (name = "address")
	private String address;

	@NotNull
	@Column (name = "phone_number", nullable = false)
	private String phoneNumber;

	@NotNull
	@Column (name = "lat", nullable = false)
	private BigDecimal lat;

	@NotNull
	@Column (name = "lon", nullable = false)
	private BigDecimal lon;

	@Column (name = "message")
	private String message;

	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "created_at")
	private Date createdAt;

	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "updated_at")
	private Date updatedAt;


	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (nullable = false, insertable = false, updatable = false, name = "city_id")
	private City city;


	public int getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLat() {
		return this.lat;
	}
	
	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}

	public BigDecimal getLon() {
		return this.lon;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
	
	public Date getCreatedAt() {
		return this.createdAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}
	

	@JsonIgnore
	public City getCity() {
		return this.city;
	}
}
