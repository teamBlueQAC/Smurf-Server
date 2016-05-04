package com.qa.smurf.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Payment")
public class Payment {

	@Id
	@Column(name = "PAYMENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "CARDNUMBER", length = 16, nullable = false)
	@NotNull
	private String cardNumber;

	@Column(name = "CARDTYPE", length = 20, nullable = false)
	@NotNull
	private String cardType;

	@Temporal(TemporalType.DATE)
	@Column(name = "EXPIRYDATE", nullable = false)
	@NotNull
	private String expiryDate;

	@Column(name = "NAMEONCARD", length = 255, nullable = false)
	@NotNull
	private String nameOnCard;

	@OneToOne

	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

	@JoinColumns({ @JoinColumn(name = "LINE1"), @JoinColumn(name = "POSTCODE") })

	private Address address;

	public Payment(String cardNumber, String cardType, Date date, String nameOnCard, Address address, User user) {

		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.expiryDate = date;
		this.nameOnCard = nameOnCard;
		this.address = address;
		this.user = user;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
