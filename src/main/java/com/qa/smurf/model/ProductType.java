package com.qa.smurf.model;

/**
 * Author - Tom
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ProductType")
public class ProductType {

	@Id
	@Column(name = "PRODUCTTYPE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NAME", nullable = false, length = 255)
	@NotNull
	@Size(min = 2, max = 255)
	private String name;

	public ProductType(int id, String name) {

	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
