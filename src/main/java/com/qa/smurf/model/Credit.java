package com.qa.smurf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Credit")
public class Credit {

	@OneToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@Column(name = "AMOUNT", nullable = false)
	@NotNull
	private Double amount;

	@Column(name = "AMOUNT_REMAINING", nullable = false)
	@NotNull
	private Double amountRemaining;

	@Column(name = "QUARTER", nullable = false)
	@NotNull
	private int quarter;

	public Credit(User user, double amount, double amountRemaining, int quarter) {
		this.user = user;
		this.amount = amount;
		this.amountRemaining = amountRemaining;
		this.quarter = quarter;
	}

	public User getUser() {
		return user;
	}

	public void setUserID(User userID) {
		this.user = userID;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getAmountRemaining() {
		return amountRemaining;
	}

	public void setAmountRemaining(Double amountRemaining) {
		this.amountRemaining = amountRemaining;
	}

	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

}