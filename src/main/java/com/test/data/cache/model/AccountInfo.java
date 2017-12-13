package com.test.data.cache.model;
import javax.persistence.Entity;

@Entity
public class AccountInfo {
	
	private String accountId;
	private String accountDetails;
	
	public AccountInfo(){
		
	}
	
	public AccountInfo(String accountId, String accountDetails) {
		super();
		this.accountId = accountId;
		this.accountDetails = accountDetails;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountDetails() {
		return accountDetails;
	}
	public void setAccountDetails(String accountDetails) {
		this.accountDetails = accountDetails;
	}
	@Override
	public String toString() {
		return "AccountInfo [accountId=" + accountId + ", accountDetails=" + accountDetails + "]";
	}

}
