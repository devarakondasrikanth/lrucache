package com.test.data.cache.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.data.cache.model.AccountInfo;

@Repository
public interface AccountRepository extends CrudRepository<AccountInfo,String>{
	AccountInfo getAccountInfoById(String id);

}
