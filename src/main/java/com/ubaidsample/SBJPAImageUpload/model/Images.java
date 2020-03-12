package com.ubaidsample.SBJPAImageUpload.model;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "images")
public class Images {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Blob photo;

	// Generate Getters and Setters...

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

}
