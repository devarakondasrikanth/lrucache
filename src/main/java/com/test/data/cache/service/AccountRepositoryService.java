package com.test.data.cache.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.test.data.cache.model.AccountInfo;
import com.test.data.cache.repository.AccountRepository;

@Component
public class AccountRepositoryService  {
	
	
	@Autowired
	public AccountRepository<AccountInfo> repo;
	
	@Cacheable("accountInfo")
	public AccountInfo getAccountInfo(String id) {
		return (AccountInfo) repo.getAccountInfoById(id);
	}
	
	public void saveAccountToDB(AccountInfo accInfo){
		repo.save(accInfo);
	}

	
	
}
