package com.revature.bankapp.models.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.revature.bankapp.models.Account;
import com.revature.bankapp.models.User;

public class UserDTO {
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private List<Account> accounts;
	
	public UserDTO() {
		super();
		this.id = 0;
		this.firstname = "";
		this.lastname = "";
		this.username = "";
		this.accounts = new ArrayList<>();
	}
	
	public UserDTO(String username, String password) {
		super();
		this.username = username;
		this.accounts = new ArrayList<>();
	}
	
	public UserDTO(String firstname, String lastname, String username, String password ) {
		super();
		this.id = 0;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.accounts = new ArrayList<>();
	}
	public UserDTO(User user) {
		super();
		setId(user.getId());
		setUsername(user.getUsername());
		setAccounts(user.getAccounts());

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accounts, firstname, id, lastname, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(accounts, other.getAccounts()) && Objects.equals(firstname, other.getFirstname()) && id == other.getId()
				&& Objects.equals(lastname, other.getLastname())
				&& Objects.equals(username, other.getUsername());
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", password=" + ", accounts=" + accounts + "]";
	}
}
