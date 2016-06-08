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
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import javax.validation.constraints.NotNull;

import com.example.myapp.domain.model.Region;
import com.example.myapp.domain.model.Area;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table (name = "prefectures")
public class Prefecture implements Serializable {
	
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
	@Column (name = "region_code", nullable = false)
	private String regionCode;

	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "created_at")
	private Date createdAt;

	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "updated_at")
	private Date updatedAt;


	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (nullable = false, insertable = false, updatable = false, name = "region_id")
	private Region region;

	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "prefecture")
	private List<Area> areas;


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
	
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getRegionCode() {
		return this.regionCode;
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
	public Region getRegion() {
		return this.region;
	}

	public List<Area> getAreas() {
		return this.areas;
	}
}
