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

import com.example.myapp.domain.model.Area;
import com.example.myapp.domain.model.Restaurant;
import com.example.myapp.domain.model.Food;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table (name = "cities")
public class City implements Serializable {
	
	@Id
	@NotNull
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private int id;

	@NotNull
	@Column (name = "name", nullable = false)
	private String name;
	
	@NotNull
	@Column (name = "code", nullable = false)
	private String code;

	@NotNull
	@Column (name = "area_code", nullable = false)
	private String areaCode;

	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "created_at")
	private Date createdAt;

	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "updated_at")
	private Date updatedAt;


	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn (nullable = false, insertable = false, updatable = false, name = "area_id")
	private Area area;

	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "city")
	private List<Restaurant> restaurants;

	@ManyToMany (mappedBy = "cities")
	private List<Food> foods;


	public int getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}
	
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaCode() {
		return this.areaCode;
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
	public Area getArea() {
		return this.area;
	}

	@JsonIgnore
	public List<Restaurant> getRestaurants() {
		return this.restaurants;
	}

	@JsonIgnore
	public List<Food> getFoods() {
		return this.foods;
	}
}
