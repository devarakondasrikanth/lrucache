package com.test.data.cache.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.test.data.cache.model.AccountInfo;
import com.test.data.cache.repository.AccountRepository;

@Service
public class AccountRepositoryService  {
	@Autowired
	public AccountRepository repo;
	
	public AccountRepositoryService(){
		
	}
	
	@Cacheable("accountInfo")
	public AccountInfo getAccountInfo(String id) {
		return (AccountInfo) repo.getAccountInfoById(id);
	}
	
	public void saveAccountToDB(AccountInfo accInfo){
		repo.save(accInfo);
	}
	
	public List<Iterable<AccountInfo>> getAll(){
		return Arrays.asList(repo.findAll());
	}

	
	
}
