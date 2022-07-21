package com.revature.bankapp.models.dtos;

import java.util.Objects;

import com.revature.bankapp.models.Account;

public class AccountDTO {
	private int account_id;
	private int user_id;
	private String accountType;
	private double accountBal;
	private double previousTransaction;
	
	public AccountDTO() {
		super();
		this.account_id = 0;
		this.user_id = 0;
		this.accountType = "";
		this.accountBal = 0;
		this.previousTransaction = 0;
	}
	
	public AccountDTO(int user_id) {
		super();
		this.user_id = user_id;
	}
	public AccountDTO(String accountType, double accountBal) {
		super();
		this.accountType = accountType;
		this.accountBal = accountBal;
	}
	
	public AccountDTO(int account_id, String accountType, double accountBal) {
		super();
		this.account_id = account_id;
		this.accountType = accountType;
		this.accountBal = accountBal;
		this.previousTransaction = previousTransaction;	
	}
	
	public AccountDTO(int account_id, String accountType, double accountBal, int user_id) {
		super();
		this.account_id = account_id;
		this.accountType = accountType;
		this.accountBal = accountBal;
		this.user_id = user_id;
	}
	
	public AccountDTO(Account account) {
		super();
		setId(account.getId());
		setUser_id(account.getUser_id());
		setAccountType(account.getAccountType());
		setAccountBal(account.getAccountBal());
	}
	public int getId() {
		return account_id;
	}

	public void setId(int account_id) {
		this.account_id = account_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAccountBal() {
		return accountBal;
	}

	public void setAccountBal(double accountBal) {
		this.accountBal = accountBal;
	}

	public void setPreviousTransaction(double previousTransaction) {
		this.previousTransaction = previousTransaction;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountBal, accountType, account_id, previousTransaction, user_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Double.doubleToLongBits(accountBal) == Double.doubleToLongBits(other.getAccountBal())
				&& Objects.equals(accountType, other.getAccountType()) && account_id == other.account_id
				&& Double.doubleToLongBits(previousTransaction) == Double.doubleToLongBits(other.previousTransaction)
				&& user_id == other.getUser_id();
	}

	@Override
	public String toString() {
		return "Account [id=" + account_id + ", user_id=" + user_id + ", accountType=" + accountType + ", accountBal="
				+ accountBal + ", previousTransaction=" + previousTransaction + "]";
	}

}
