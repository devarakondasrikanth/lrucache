package com.test.data.cache.ui;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.data.cache.model.AccountInfo;
import com.test.data.cache.repository.AccountRepository;

public class CacheImpl implements Cache{
	
	private LinkedHashMap<String,AccountInfo> cache;
	@Autowired
    private AccountRepository<AccountInfo> accountRepository;
	
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
		 accountRepository.save(accInfo);
	}

	
	public AccountInfo getAccountInfo(String accountId) {
		AccountInfo accInfo = null;
		synchronized(cache) {
			accInfo = cache.get(accountId);
	       }
		if(accInfo == null){
			accInfo = accountRepository.getAccountInfoById(accountId);
			cache.put(accInfo.getAccountId(), accInfo);
		}
		return accInfo;
	}

}
