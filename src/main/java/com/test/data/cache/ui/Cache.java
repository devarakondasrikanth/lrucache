package com.test.data.cache.ui;

import com.test.data.cache.model.AccountInfo;

public interface Cache {
	public void store(AccountInfo accInfo);
	public AccountInfo getAccountInfo(String accountId);
}
