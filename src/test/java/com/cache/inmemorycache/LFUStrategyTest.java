package com.cache.inmemorycache;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cache.inmemorycache.strategy.LFUStrategy;
import com.cache.inmemorycache.strategy.Storage;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 
 * @author thusitha
 *
 */
class LFUTest {
	private int maxSize;
	private Storage<Integer, Integer> storage;

	@BeforeEach
	void init() {
		maxSize = 4;
		storage = new LFUStrategy(maxSize);
		for (int i = 0; i < maxSize; i++) {
			storage.put(i, i);
		}
	}

	@Test
	void put() {
		Integer key = 1;
		Integer value = 111;
		Integer oldValue = storage.put(key, value);
		assertEquals(value, storage.get(key));
		assertEquals(oldValue, Integer.valueOf(1));
	}

	@Test
	void get() {
		Integer key = 1;
		assertEquals(Integer.valueOf(key), key);
	}

	@Test
	void size() {
		assertEquals(maxSize, storage.size());
		storage.put(maxSize + 1, maxSize + 1);
		assertEquals(maxSize, storage.size());
	}

	@Test
	void lfu() {
		Integer key = maxSize / 2;
		for (int i = 0; i < maxSize; i++) {
			if (i != key) {
				storage.get(i);
				storage.get(i);
			}
		}
		storage.get(key);
		storage.put(maxSize + 1, maxSize + 1);
		assertNull(storage.get(key));
		storage.put(maxSize + 2, maxSize + 2);
		assertNull(storage.get(maxSize + 1));
	}
}