package com.cache.inmemorycache.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cache.inmemorycache.pojo.CacheData;
import com.cache.inmemorycache.strategy.Cache;

@Service
public class CacheDataService {
	
	final static Logger logger = LoggerFactory.getLogger(CacheDataService.class);

	public CacheData saveCacheDataData(CacheData cacheData) {

		Cache<String, String> cache = new Cache<>(cacheData.getCacheType(), cacheData.getSize());
		cache.put(cacheData.getKey(), cacheData.getValue());
		return cacheData;

	}

	public List<CacheData> findCacheDataData(String key) {
		List<CacheData> list = new ArrayList<>();
		try {
			CacheData cacheData = new CacheData();
			cacheData.setKey(key);
			cacheData.setCacheType("LRU");
			cacheData.setSize(10);

			Cache<String, String> cache = new Cache<>(cacheData.getCacheType(), cacheData.getSize());
			String cacheValue = cache.get(key);

			cache.getStorage();

			System.out.println("aaaaaaaaaaaaaa" + cacheValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public CacheData updatCacheDataData(CacheData cacheData) {
		return null;
	}

	public void removeCacheDataData(String cacheDataId) {
	}
}
