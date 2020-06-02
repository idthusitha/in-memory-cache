package com.cache.inmemorycache.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cache.inmemorycache.pojo.CacheData;
import com.cache.inmemorycache.strategy.LFUStrategy;
import com.cache.inmemorycache.strategy.LRUStrategy;
import com.cache.inmemorycache.strategy.Storage;
import com.cache.inmemorycache.utilities.CommonUtils;

@Service
public class CacheDataService {

	final static Logger logger = LoggerFactory.getLogger(CacheDataService.class);

	@Autowired
	private LFUStrategy<String, String> lFUStrategy;

	@Autowired
	private LRUStrategy<String, String> lRUStrategy;

	/**
	 * 
	 * @param cacheData
	 * @return
	 */
	public CacheData saveCacheDataData(CacheData cacheData) {
		Properties prop = CommonUtils.getInstance().getProperties();

		String ALGORITHM_ERROR_MESSAGE = prop.getProperty("cache.algorithm.error.message");

		String algorithm = cacheData.getCacheType();
		Storage<String, String> storage = loadStorage(ALGORITHM_ERROR_MESSAGE, algorithm);

		storage.put(cacheData.getKey(), cacheData.getValue());

		return cacheData;
	}

	/**
	 * 
	 * @param cacheType
	 * @param key
	 * @return
	 */
	public List<CacheData> findCacheDataData(String cacheType, String key) {
		List<CacheData> list = new ArrayList<>();
		Properties prop = CommonUtils.getInstance().getProperties();

		String ALGORITHM_ERROR_MESSAGE = prop.getProperty("cache.algorithm.error.message");
		Storage<String, String> storage = loadStorage(ALGORITHM_ERROR_MESSAGE, cacheType);

		for (String keyTemp : storage.getAllData().keySet()) {

			CacheData cacheData = new CacheData();
			cacheData.setKey(keyTemp);
			cacheData.setCacheType(cacheType);
			cacheData.setSize(storage.size());
			cacheData.setValue(storage.getAllData().get(keyTemp));
			list.add(cacheData);

			logger.info("Type: " + cacheType + " keyTemp:  " + keyTemp + " : " + storage.getAllData().get(keyTemp));
		}

		return list;
	}

	/**
	 * 
	 * @param cacheData
	 * @return
	 */
	public CacheData updatCacheDataData(CacheData cacheData) {
		// update cache data base on the key and cache type (remove and adding)

		return null;
	}

	/**
	 * 
	 * @param cacheDataId
	 */
	public void removeCacheDataData(String cacheDataId) {
		// remove cache data base on the key and cache type

	}

	/**
	 * 
	 * @param ALGORITHM_ERROR_MESSAGE
	 * @param algorithm
	 */
	private Storage<String, String> loadStorage(String ALGORITHM_ERROR_MESSAGE, String algorithm) {
		Storage<String, String> storage;
		switch (algorithm) {
		case "LFU":
			storage = lFUStrategy;
			break;
		case "LRU":
			storage = lRUStrategy;
			break;
		default:
			throw new IllegalArgumentException(ALGORITHM_ERROR_MESSAGE);
		}
		return storage;
	}
}
