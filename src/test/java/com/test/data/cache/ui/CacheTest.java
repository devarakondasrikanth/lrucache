package com.test.data.cache.ui;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.data.cache.app.LRUCache;
import com.test.data.cache.model.AccountInfo;
import com.test.data.cache.service.AccountRepositoryService;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes={LRUCache.class})
public class CacheTest {
	@Autowired
	private AccountRepositoryService service;
	
	@Test
	public void storeTest(){
		service.saveAccountToDB(new AccountInfo("001","New AccountInformation"));
		assertTrue(service.getAccountInfo("001").getAccountDetails().equals("New AccountInformation"));
	}
	
	@Test
	public void retriveTest(){
		for(int i=0;i<999;i++)
		service.saveAccountToDB(new AccountInfo(UUID.randomUUID().toString(),"New AccountInformation"));
		assertNotNull(service.getAll());
	}
}
