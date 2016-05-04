package com.qa.smurf.model;

/**
 * 
 * Created by Omar
 * 
 */

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "WishListEntry")
public class WishListEntry {

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_ADDED", nullable = false)
	@NotNull
	private Date dateAdded;

	public WishListEntry(Product product, Date dateAdded, User user) {
		this.product = product;
		this.dateAdded = dateAdded;
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

}
