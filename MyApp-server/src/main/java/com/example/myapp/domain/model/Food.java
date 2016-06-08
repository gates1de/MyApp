package com.example.myapp.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import javax.validation.constraints.NotNull;

import com.example.myapp.domain.model.City;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table (name = "foods")
public class Food implements Serializable {
	
	@Id
	@NotNull
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private int id;

	@NotNull
	@Column (name = "name", nullable = false)
	private String name;
	
	@NotNull
	@Column (name = "is_specialty", nullable = false)
	private boolean isSpecialty;

	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "created_at")
	private Date createdAt;

	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "updated_at")
	private Date updatedAt;

	@ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable (
		name = "foods_cities", 
		joinColumns = @JoinColumn (
			name = "city_id",
			referencedColumnName = "id"
		),
		inverseJoinColumns = @JoinColumn (
			name = "food_id",
			referencedColumnName = "id"
		)
	)
	private List<City> cities;


	public int getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	public void setIsSpecialty(boolean isSpecialty) {
		this.isSpecialty = isSpecialty;
	}

	public boolean getIsSpecialty() {
		return this.isSpecialty;
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
	public List<City> getCities() {
		return this.cities;
	}
}
