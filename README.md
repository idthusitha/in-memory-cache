# in-memory cache

Create in-memory cache (for caching Objects) with configurable max size and eviction strategy. Two strategies should be implemented: LRU and LFU. For this task it is assumed that only one thread will access the cache, so there is no need to make it thread-safe. Please provide an example of usage of the cache as a unit test(s).


### High-level architecture diagram of the system, identifying all major components

![Test Image 1](https://github.com/idthusitha/in-memory-cache/blob/master/doc/in-memory.png)


### Prerequisites:
   * git
   * Java 1.8
   * Gradle 5.0  
   * apache-tomcat-9.0.34
   

### Technology selection:
   * Java Programming Language
   * Sprint Boot 2.2.7
   * Swagger API
   * Junit Testing
   

### Build and Deploy instructions   
	cd {{ WORKSPACE_PATH }}
	git clone https://github.com/idthusitha/in-memory-cache.git
	cd  in-memory-cache
	
	/**WAR file copy into /system/tomcat1/apache-tomcat-9.0.34/webapp	
	*change the tomcat deploy location in build.gradle file	
	**/
	
	gradle deploy
	
	cd {{ TOMCAT_HOME }}/bin
	sh startup.sh
	
### Application Home Page
   	
http://localhost:8080/in-memory-cache/ [Click here](http://localhost:8080/in-memory-cache/).

	User Name: admin	
	Password: password

![Test Image 2](https://github.com/idthusitha/in-memory-cache/blob/master/doc/home-page.png)
	
	
### Application Swagger API
	
http://localhost:8080/in-memory-cache/swagger-ui.html#/cache-data-controller [Click here](http://localhost:8080/in-memory-cache/swagger-ui.html#/cache-data-controller).

![Test Image 3](https://github.com/idthusitha/in-memory-cache/blob/master/doc/swagger-api.png)


### Sequence diagram for Cache Save

![Test Image 4](https://github.com/idthusitha/in-memory-cache/blob/master/doc/sequence-diagram-cache-save.png)


### High-level infrastructure Architecture


![Test Image 5](https://github.com/idthusitha/in-memory-cache/blob/master/doc/High-level-infrastructure-Architecture.png)
	

	

### Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.		
	