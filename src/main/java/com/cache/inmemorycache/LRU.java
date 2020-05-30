package com.cache.inmemorycache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author thusitha
 *
 * @param <K>
 * @param <V>
 */
public class LRU<K, V> extends LinkedHashMap<K, V> implements Storage<K, V> {

	private static final long serialVersionUID = 1L;

	private static final float LOAD_FACTOR = 0.75f;
	private static final boolean ACCESS_ORDER = true;
	private final int CACHE_MAX_SIZE;

	public LRU(int maxSize) {
		super(maxSize, LOAD_FACTOR, ACCESS_ORDER);
		CACHE_MAX_SIZE = maxSize;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > CACHE_MAX_SIZE;
	}
}