package com.test.data.cache.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountInfo {
	@Id
	private String id;
	private String accountDetails;
	
	public AccountInfo(){
		
	}
	
	public AccountInfo(String accountId, String accountDetails) {
		super();
		this.id = accountId;
		this.accountDetails = accountDetails;
	}
	public String getAccountId() {
		return id;
	}
	public void setAccountId(String accountId) {
		this.id = accountId;
	}
	public String getAccountDetails() {
		return accountDetails;
	}
	public void setAccountDetails(String accountDetails) {
		this.accountDetails = accountDetails;
	}
	@Override
	public String toString() {
		return "AccountInfo [accountId=" + id + ", accountDetails=" + accountDetails + "]";
	}

}
