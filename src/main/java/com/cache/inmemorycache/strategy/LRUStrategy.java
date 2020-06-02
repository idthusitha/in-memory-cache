package com.cache.inmemorycache.strategy;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.cache.inmemorycache.utilities.CommonUtils;

/**
 * 
 * @author thusitha
 *
 * @param <K>
 * @param <V>
 */
@Service
public class LRUStrategy<K, V> extends LinkedHashMap<K, V> implements Storage<K, V> {

	private static final long serialVersionUID = 1L;

	private static final float LOAD_FACTOR = 0.75f;
	private static final boolean ACCESS_ORDER = true;
	private Properties prop = CommonUtils.getInstance().getProperties();
	private int CACHE_MAX_SIZE;

	public LRUStrategy() {
		super(Integer.parseInt(CommonUtils.getInstance().getProperties().getProperty("cach.initial.capacity", "0")),
				LOAD_FACTOR, ACCESS_ORDER);
		CACHE_MAX_SIZE = Integer.parseInt(prop.getProperty("cach.initial.capacity", "0"));

	}

	public LRUStrategy(int maxSize) {
		super(maxSize, LOAD_FACTOR, ACCESS_ORDER);
		CACHE_MAX_SIZE = maxSize;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > CACHE_MAX_SIZE;
	}

	@Override
	public Map<K, V> getAllData() {
		return new LinkedHashMap<>(this);
	}
}