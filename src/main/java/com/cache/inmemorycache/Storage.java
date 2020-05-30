package com.cache.inmemorycache;

/**
 * 
 * @author thusitha
 *
 * @param <K>
 * @param <V>
 */
public interface Storage<K, V> {
	V get(K key);

	V put(K key, V value);

	int size();
}