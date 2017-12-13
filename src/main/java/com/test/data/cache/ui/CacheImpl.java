package com.test.data.cache.ui;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.data.cache.model.AccountInfo;
import com.test.data.cache.service.AccountRepositoryService;

@Component
public class CacheImpl implements Cache{
	
	private LinkedHashMap<String,AccountInfo> cache;
	@Autowired
	AccountRepositoryService accountService;
	
	public CacheImpl(){
		  this.cache = new LinkedHashMap<String,AccountInfo>(1000, 0.75F, true) {
              private static final long serialVersionUID = -1236481390177598762L;
              @Override
              protected boolean removeEldestEntry(Map.Entry<String,AccountInfo> eldest){            
                 return size() > 1000;
              }
           };
          
	}

	
	public void store(AccountInfo accInfo) {		
		 synchronized(cache) {
	          cache.put(accInfo.getAccountId(), accInfo);
	       }
		 accountService.saveAccountToDB(accInfo);
	}

	
	public AccountInfo getAccountInfo(String accountId) {
		AccountInfo accInfo = null;
		synchronized(cache) {
			accInfo = cache.get(accountId);
	       }
		if(accInfo == null){
			accInfo = accountService.getAccountInfo(accountId);
			cache.put(accInfo.getAccountId(), accInfo);
		}
		return accInfo;
	}

}
