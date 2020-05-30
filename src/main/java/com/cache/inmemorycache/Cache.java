package com.cache.inmemorycache;

/**
 * 
 * @author thusitha
 *
 * @param <K>
 * @param <V>
 */
public class Cache<K, V> {
	public static String MAX_SIZE_ERROR_MESSAGE = "The maximum size of the cache should be moare than zero";
	public static String ALGORITHM_ERROR_MESSAGE = "There is no such caching algorithm";
	private Storage<K, V> storage;

	public static final String LRU = "LRU";
	public static final String LFU = "LFU";

	/**
	 * 
	 * @param algorithm
	 * @param cacheMaxSize
	 */
	public Cache(String algorithm, int cacheMaxSize) {
		if (cacheMaxSize <= 0) {
			throw new IllegalArgumentException(MAX_SIZE_ERROR_MESSAGE);
		}
		switch (algorithm) {
		case LFU:
			storage = new LFU<>(cacheMaxSize);
			break;
		case LRU:
			storage = new LRU<>(cacheMaxSize);
			break;
		default:
			throw new IllegalArgumentException(ALGORITHM_ERROR_MESSAGE);
		}
	}

	V get(K key) {
		return storage.get(key);
	}

	V put(K key, V value) {
		return storage.put(key, value);
	}

	int size() {
		return storage.size();
	}

	@Override
	public String toString() {
		return storage.toString();
	}
}
