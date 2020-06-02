# in-memory cache

Create in-memory cache (for caching Objects) with configurable max size and eviction strategy. Two strategies should be implemented: LRU and LFU. For this task it is assumed that only one thread will access the cache, so there is no need to make it thread-safe. Please provide an example of usage of the cache as a unit test(s).


### High-level architecture diagram of the system, identifying all major components

![Test Image 1](https://github.com/idthusitha/in-memory-cache/blob/master/doc/in-memory.png)


### Prerequisites:
   * Java 1.8
   * Gradle 5.0
   * Sprint Boot 2.2.7 
   * Junit Testing
   * Swagger API
   

### Build instructions   
	cd {{ WORKSPACE_PATH }}
	git clone https://github.com/idthusitha/in-memory-cache.git
	cd  in-memory-cache
	
	/**WAR file copy into /system/tomcat1/apache-tomcat-9.0.34/webapp	
	*change the tomcat deploy location in build.gradle file	
	**/
	
	gradle deploy
	
### Application Home Page
   	
http://localhost:8080/in-memory-cache/ [Click here](http://localhost:8080/in-memory-cache/).
	
	
### Application Swagger API
	
http://localhost:8080/in-memory-cache/swagger-ui.html#/cache-data-controller [Click here](http://localhost:8080/in-memory-cache/swagger-ui.html#/cache-data-controller).
	

	

		
	