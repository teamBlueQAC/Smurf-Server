package com.qa.smurf.model;

/**
 * Author - Tom
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "PRODUCT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "NAME", length = 255, nullable = false)
	@NotNull
	private String name;

	@Column(name = "SERIAL", length = 255, nullable = false)
	@NotNull
	private String serial;

	@Column(name = "COLOUR", length = 20, nullable = false)
	@NotNull
	private String colour;

	@Column(name = "PRICE", length = 12, nullable = false)
	@NotNull
	private Double price;

	@Column(name = "DISCONTINUED", nullable = false)
	@NotNull
	private boolean discountinued;

	@Column(name = "PICTURELOC", length = 510, nullable = false)
	@NotNull
	private String pictureLoc;

	@Column(name = "QUANTITYAVAILABLE", length = 20, nullable = false)
	@NotNull
	private int quantityAvailable;

	@ManyToOne
	@JoinColumn(name = "TYPE_ID")
	private ProductType productType;

	@Column(name = "DESCRIPTION", length = 510)
	private String description;

	@Column(name = "REORDERTHRESHOLD", length = 20)
	private int reorderThreshold;

	@Column(name = "REORDEREDAMOUNT", length = 20, nullable = false)
	@NotNull
	private int reorderedAmount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isDiscountinued() {
		return discountinued;
	}

	public void setDiscountinued(boolean discountinued) {
		this.discountinued = discountinued;
	}

	public String getPictureLoc() {
		return pictureLoc;
	}

	public void setPictureLoc(String pictureLoc) {
		this.pictureLoc = pictureLoc;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReorderThreshold() {
		return reorderThreshold;
	}

	public void setReorderThreshold(int reorderThreshold) {
		this.reorderThreshold = reorderThreshold;
	}

	public int getReorderedAmount() {
		return reorderedAmount;
	}

	public void setReorderedAmount(int reorderedAmount) {
		this.reorderedAmount = reorderedAmount;
	}

	public Product(long id, String name, String serial, String colour, Double price, boolean discountinued,
			String pictureLoc, int quantityAvailable, ProductType productType, String description, int reorderThreshold,
			int reorderedAmount) {
		super();
		this.id = id;
		this.name = name;
		this.serial = serial;
		this.colour = colour;
		this.price = price;
		this.discountinued = discountinued;
		this.pictureLoc = pictureLoc;
		this.quantityAvailable = quantityAvailable;
		this.productType = productType;
		this.description = description;
		this.reorderThreshold = reorderThreshold;
		this.reorderedAmount = reorderedAmount;
	}

}
