package com.cache.inmemorycache.strategy;

import java.util.*;

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
public class LFUStrategy<K, V> implements Storage<K, V> {

	private final int CACHE_MAX_SIZE;
	private HashMap<K, V> storage;
	private HashMap<K, Long> keyFrequency;
	private TreeMap<Long, HashSet<K>> sortedFrequencies;
	private Properties prop = CommonUtils.getInstance().getProperties();

	public LFUStrategy() {
		CACHE_MAX_SIZE = Integer.parseInt(prop.getProperty("cach.initial.capacity", "0"));
		storage = new HashMap<>();
		keyFrequency = new HashMap<>();
		sortedFrequencies = new TreeMap<>();
	}

	public LFUStrategy(int maxSize) {
		CACHE_MAX_SIZE = maxSize;
		storage = new HashMap<>();
		keyFrequency = new HashMap<>();
		sortedFrequencies = new TreeMap<>();
	}

	private void eviction() {
		Long minFrequency = sortedFrequencies.firstKey();
		K evictionKey = sortedFrequencies.get(minFrequency).iterator().next();
		delFromSortedFrequencies(evictionKey, minFrequency);
		keyFrequency.remove(evictionKey);
		storage.remove(evictionKey);
	}

	private void frequencyIncrement(K key) {
		Long frequency = keyFrequency.compute(key, (k, f) -> f + 1L);
		delFromSortedFrequencies(key, frequency - 1);
		sortedFrequencies.computeIfAbsent(frequency, keys -> new HashSet<>()).add(key);
	}

	private void delFromSortedFrequencies(K key, Long frequency) {
		if (sortedFrequencies.get(frequency).size() > 1) {
			sortedFrequencies.get(frequency).remove(key);
		} else {
			sortedFrequencies.remove(frequency);
		}
	}

	@Override
	public V put(K key, V value) {
		if (storage.size() == CACHE_MAX_SIZE) {
			eviction();
		}
		V oldValue = storage.put(key, value);
		Long frequency = keyFrequency.computeIfAbsent(key, f -> 1L);
		sortedFrequencies.computeIfAbsent(frequency, keys -> new HashSet<>()).add(key);
		return oldValue;
	}

	@Override
	public V get(K key) {
		V value = storage.get(key);
		if (value != null) {
			frequencyIncrement(key);
		}
		return value;
	}

	@Override
	public int size() {
		return storage.size();
	}

	@Override
	public String toString() {
		return storage.toString();
	}

	@Override
	public Map<K, V> getAllData() {
		return storage;
	}
}
