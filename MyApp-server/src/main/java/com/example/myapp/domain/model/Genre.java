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

import javax.validation.constraints.NotNull;


@Entity
@Table (name = "genres")
public class Genre implements Serializable {
	
	@Id
	@NotNull
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private int id;

	@NotNull
	@Column (name = "name", nullable = false)
	private String name;

	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "created_at")
	private Date createdAt;

	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "updated_at")
	private Date updatedAt;


	public int getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
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
}
