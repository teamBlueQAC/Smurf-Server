package com.qa.smurf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Supplier")
public class Supplier {

	@Id
	@Column(name = "SUPPLIER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME", length = 255)
	private String name;

	@JoinColumns({ @JoinColumn(name = "LINE1"), @JoinColumn(name = "POSTCODE") })
	private Address address;

	public Supplier(Address address, String name) {
		this.address = address;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
