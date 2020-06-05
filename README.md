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
   
   
### The reasons for Selecting Java.
Java is one of the best programming language that is based on the concept of Objects. And thus, it is also known as the Object Oriented Programming Language. Also, there are some of the striking features that Java provides and hence, it makes programmers to use it as one of the most effective and the efficient programming language. 
   
   
### The reasons for Selecting Sprint Boot.
Spring is a very popular Java-based framework for building web and enterprise applications which provides a wide verity of features addressing the modern business needs via its portfolio projects. Spring framework provides flexibility to configure beans in multiple ways such as XML, Annotations, and JavaConfig. With the number of features increased the complexity also gets increased and configuring Spring applications becomes tedious and error-prone.
   
   
### The reasons for Selecting Swagger API.
Swagger allows us to describe the structure of our APIs so that machines can read them. The ability of APIs to describe their own structure is the root of all awesomeness in Swagger. So by reading our API’s structure, we can automatically build beautiful and interactive API documentation. We can also automatically generate client libraries for our API in many languages and explore other possibilities like automated testing. Swagger does this by asking our API to return a YAML or JSON that contains a detailed description of our entire API.

### The reasons for Selecting Junit Testing.
We can use JUnit as a tool to write simple tests against small bits of logical behavior in our code. The tests you write involve:
setting up some context (put the system into a certain state, by perhaps populating elements or invoking some methods), executing whatever it is you want to verify; asserting against conditions you expect to hold true at this point. If an assertion does not hold true, the test fails.
   

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
	
### The reasons for Selecting AWS Cloud.

AWS has millions of users all over the world because of better security, quick procurement, easy to use, and more reliability. It is the top choice for businesses. With the introduction of AWS, businesses across many verticals have a new chance of supplanting infrastructure-related high costs.

### The reasons for Selecting r5.large EC2 instance.

Amazon EC2 R5 instances are the next generation of memory optimized instances for the Amazon Elastic Compute Cloud.  R5 instances are well suited for memory intensive applications such as high performance databases, distributed web scale in-memory caches, mid-size in-memory databases, real time big data analytics, and other enterprise applications. Additionally, R5d, R5dn, and R5ad instances have local storage, offering up to 3.6TB of NVMe-based SSDs.

### The reasons for Selecting r5.large X 2 instances.

If we have only one load balancer, and it fails, our entire system is in trouble. This is known as a single point of failure (SPOF). This applies to hardware load balancers as well as software based load balancers.

### The reasons for Selecting private network.

The benefit of VPC is that it helps in aspects of cloud computing like privacy, security and preventing loss of proprietary data. Let's take a look at some of the basics of a VPC. Subnets: A subnet can be thought of as dividing a large network into smaller networks.
	

### Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.		
	