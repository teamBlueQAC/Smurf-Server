package com.qa.smurf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Category")
public class Category {

	@Id
	@Column(name = "CATEGORY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "NAME", length = 255, nullable = false)
	@NotNull
	private String name;

	public long getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setID(long newID) {
		this.id = newID;
	}

	public void setName(String n) {
		this.name = n;
	}

	public Category(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
