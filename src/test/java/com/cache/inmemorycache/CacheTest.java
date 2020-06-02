package com.cache.inmemorycache;

import org.junit.jupiter.api.Test;

import com.cache.inmemorycache.strategy.Cache;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 
 * @author thusitha
 *
 */
class CacheTest {

	@Test
	void checkException() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			Cache<Integer, Integer> cache = new Cache<>("LRU", 0);
		});
		assertEquals(Cache.MAX_SIZE_ERROR_MESSAGE, exception.getMessage());
	}

	@Test
	void checkExceptionAlgorithm() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			Cache<Integer, Integer> cache = new Cache<>("TEST", 10);
		});
		assertEquals(Cache.ALGORITHM_ERROR_MESSAGE, exception.getMessage());
	}
}
