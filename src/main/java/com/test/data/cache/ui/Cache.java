package com.test.data.cache.ui;

import org.springframework.stereotype.Component;

import com.test.data.cache.model.AccountInfo;
@Component
public interface Cache {
	public void store(AccountInfo accInfo);
	public AccountInfo getAccountInfo(String accountId);
}
