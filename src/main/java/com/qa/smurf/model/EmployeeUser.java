package com.qa.smurf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.qa.smurf.util.AccountType;

@Entity
@Table(name = "EmployeeUser")
public class EmployeeUser {

	@Id
	@Column(name = "EMPLOYEEUSER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "ACCOUNTTYPE_ID")
	private AccountType accountType;

	@Column(name = "NAME", nullable = false, length = 255)
	@NotNull
	private String name;

	public EmployeeUser(AccountType accountType, String name) {
		this.accountType = accountType;
		this.name = name;
	}

	public long getID() {
		return id;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public String getName() {
		return name;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public void setName(String name) {
		this.name = name;
	}

}
