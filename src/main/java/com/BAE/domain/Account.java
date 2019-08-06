package com.BAE.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	
	private String lastName;
 
	private int accountNumber;
	
	private String prize;
	public Account() {

	}

	public Account(Long id, String firstName, String lastName, int accountNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
		this.prize = prize;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public int getaccountNumber() {
		return accountNumber;
	}

	public void setaccountNumber(int accountnumber) {
		this.accountNumber = accountnumber;
	}
	
	public String getprize() {
		return prize;
	}

	public void setprize(String prize) {
		this.prize = prize;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {

		return "id: " + id + ", name: " + firstName;
	}

}
