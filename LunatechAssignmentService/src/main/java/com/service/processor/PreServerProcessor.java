package com.service.processor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.cache.CacheManager;

@Component
public class PreServerProcessor{
	@Autowired
	private CacheManager cacheImpl;

	@PostConstruct
	public void loadData() {
		cacheImpl.loadData();
	}

}
