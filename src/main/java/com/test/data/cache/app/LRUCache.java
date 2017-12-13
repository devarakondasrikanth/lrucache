package com.test.data.cache.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.test.data.cache.*")
@EnableJpaRepositories("com.test.data.cache.*")
@ComponentScan({"com.test.data.cache.*","com.test.data.cache.app","com.test.data.cache.repository","com.test.data.cache.service","com.test.data.cache.ui"})
public class LRUCache{
	
	
	public static void main(String[] args) {
		SpringApplication.run(LRUCache.class, args);
	}
	
	
}
