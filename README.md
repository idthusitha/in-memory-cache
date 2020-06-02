# in-memory cache

Create in-memory cache (for caching Objects) with configurable max size and eviction strategy. Two strategies should be implemented: LRU and LFU. For this task it is assumed that only one thread will access the cache, so there is no need to make it thread-safe. Please provide an example of usage of the cache as a unit test(s).


### High-level architecture diagram of the system, identifying all major components

![Test Image 1](https://github.com/idthusitha/in-memory-cache/blob/master/doc/in-memory.png)


### Prerequisites:
   * Java 1.8
   * Gradle 5.0
   * Sprint Boot 2.2.7 
   * Junit Testing
   
   
### API 1.0.0

Constuctor definition:
Cache(String algorithm, int cacheMaxSize)

	//LFU
	Cache cache = new Cache<>("LFU", 5);
	
	//LRU
	Cache cache = new Cache<>("LRU", 5);
	
	//LFU
	Storage<String, String> storage = new LFUStrategy(10);
	storage.put("TEST_KEY", "TEST_VALUE");
	storage.get(key); //return the stored value
	
	//LFU
	Storage<String, String> storage = new LRUStrategy(10);
	storage.put("TEST_KEY", "TEST_VALUE");
	storage.get(key); //return the stored value
	
	
		
	