package com.cache.inmemorycache.strategy;

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

	public static final String LRU_STRATEGY = "LRU";
	public static final String LFU_STRATEGY = "LFU";

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
		case LFU_STRATEGY:
			storage = new LFUStrategy<>(cacheMaxSize);
			break;
		case LRU_STRATEGY:
			storage = new LRUStrategy<>(cacheMaxSize);
			break;
		default:
			throw new IllegalArgumentException(ALGORITHM_ERROR_MESSAGE);
		}
	}

	public V get(K key) {
		return storage.get(key);
	}

	public V put(K key, V value) {
		return storage.put(key, value);
	}

	public int size() {
		return storage.size();
	}

	public Storage<K, V> getStorage() {
		return storage;
	}

	@Override
	public String toString() {
		return storage.toString();
	}
}
