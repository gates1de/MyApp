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
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import javax.validation.constraints.NotNull;

import com.example.myapp.domain.model.Area;
import com.example.myapp.domain.model.Prefecture;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table (name = "areas")
public class Area implements Serializable {
	
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
	@Column (name = "prefecture_code", nullable = false)
	private String prefectureCode;

	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "created_at")
	private Date createdAt;

	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "updated_at")
	private Date updatedAt;


	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (nullable = false, insertable = false, updatable = false, name = "prefecture_id")
	private Prefecture prefecture;

	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "area")
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
	
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}
	
	public void setPrefectureCode(String prefectureCode) {
		this.prefectureCode = prefectureCode;
	}

	public String getPrefectureCode() {
		return this.prefectureCode;
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
	public Prefecture getPrefecture() {
		return this.prefecture;
	}

	public List<City> getCities() {
		return this.cities;
	}
}
